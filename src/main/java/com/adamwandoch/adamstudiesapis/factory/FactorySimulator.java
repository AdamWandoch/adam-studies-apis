package com.adamwandoch.adamstudiesapis.factory;

import com.adamwandoch.adamstudiesapis.factory.output.OutputRecord;
import com.adamwandoch.adamstudiesapis.factory.output.OutputService;
import com.adamwandoch.adamstudiesapis.factory.status.ProductionStatus;
import com.adamwandoch.adamstudiesapis.factory.status.ProductionStatusService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * @author Adam Wandoch
 */

@Service
public class FactorySimulator {

    private static final Logger LOG = LoggerFactory.getLogger(FactorySimulator.class);

    @Autowired
    private ProductionStatusService statusService;
    @Autowired
    private OutputService outputService;
    private ArrayList<ProductionStatus> status;
    private ArrayList<OutputRecord> outputs = new ArrayList<>();

    public FactorySimulator() {
    }

    private ArrayList<ProductionStatus> initialStatus() {
        LOG.info("[ SIMULATOR ] : initialStatus() called");
        ArrayList<ProductionStatus> data = new ArrayList<>();
        int initialTemp = 15;
        String initialStatus = "idling";
        String initialProduct = "none";
        int initialOutputRate = 0;
        int numberOfLines = 24;
        for (int i = 0; i < numberOfLines; i++) {
            data.add(new ProductionStatus(0,
                    "Line " + (i + 1),
                    initialTemp,
                    initialTemp,
                    initialStatus,
                    initialProduct,
                    initialOutputRate));
        }
        return data;
    }

    public void runFactoryCycle() {
        ArrayList<ProductionStatus> status = statusService.getStatus();
        if (status.size() < 1) status = initialStatus();
        status.forEach(s -> {
            if (s.getStatus().equals("producing")) {
                if (getRandomNumber(0, 10) > 7) {
                    s.setSensor1temp(s.getSensor1temp() + getRandomNumber(1, 3));
                }
                if (getRandomNumber(0, 10) > 7) {
                    s.setSensor2temp(s.getSensor2temp() + getRandomNumber(1, 3));
                }
                logOutputRecord(s);
            } else {
                // cools down if not producing
                if (s.getSensor1temp() > 15) {
                    s.setSensor1temp(s.getSensor1temp() - getRandomNumber(0, 2));
                }
                if (s.getSensor2temp() > 15) {
                    s.setSensor2temp(s.getSensor2temp() - getRandomNumber(0, 2));
                }
            }
            // set to fail if temperature above 40 degrees
            if (s.getSensor1temp() > 30 || s.getSensor2temp() > 30) {
                s.setStatus("failure");
            }
            statusService.saveStatus(s);
        });
    }

    private void logOutputRecord(ProductionStatus status) {
        outputService.saveOutput(new OutputRecord(0,
                status.getLineName(),
                status.getCurrentProduct(),
                status.getOutputRate()));
    }

    private int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }
}
