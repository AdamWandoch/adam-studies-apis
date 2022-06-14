package com.adamwandoch.adamstudiesapis.factory;

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
    private ArrayList<ProductionStatus> data;

    public FactorySimulator() {
    }

    private ArrayList<ProductionStatus> initialData() {
        LOG.info("[ SIMULATOR ] : initialData() called");
        ArrayList<ProductionStatus> data = new ArrayList<>();
        int initialTemp = 15;
        String initialStatus = "idling";
        String initialProduct = "none";
        int initialOutputRate = 0;
        for (int i = 0; i < 4; i++) {
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

    public void refreshData() {
        // FIXME: 14/06/2022 temperature not rising, looks like data is not retrieved from db on each run
        LOG.info("[ SIMULATOR ] : refresh data called");
        data = statusService.getStatus();
        LOG.info("[ SIMULATOR ] : dataSize() : " + data.size());
        if (data.size() < 1) data = initialData();
        data.forEach(p -> {
            int random = getRandomNumber(0, 10);
//            if (random > 8 && p.getStatus() == "producing") {
            if (p.getStatus() == "producing") {
                p.setSensor1temp(p.getSensor1temp() + getRandomNumber(1, 2));
                p.setSensor2temp(p.getSensor2temp() + getRandomNumber(1, 2));
            }
            // slowly cools down if idling
            if (p.getStatus() == "idling") {
                if (p.getSensor1temp() > 15) {
                    p.setSensor1temp(p.getSensor1temp() - getRandomNumber(0, 1));
                }
                if (p.getSensor2temp() > 15) {
                    p.setSensor2temp(p.getSensor2temp() - getRandomNumber(0, 1));
                }
            }
            statusService.saveStatus(p);
        });
    }

    private int getRandomNumber(int min, int max) {
        int result = (int) ((Math.random() * (max - min)) + min);
        return result;
    }
}
