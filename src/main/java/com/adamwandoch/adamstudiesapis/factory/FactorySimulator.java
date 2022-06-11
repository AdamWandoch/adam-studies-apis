package com.adamwandoch.adamstudiesapis.factory;

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

//    @Autowired
//    private ProductionStatusRepository statusRepo;
    @Autowired
    private ProductionStatusService statusService;
    private ArrayList<ProductionStatus> linesData = new ArrayList<>();

    public FactorySimulator() {
        initializeArrayList();
    }

    public void initializeArrayList() {
        LOG.info("[ SIMULATOR ] : initialize ArrayList called");
        int initialTemp = 15;
        String initialStatus = "idle";
        String initialProduct = "none";
        int initialOutputRate = 0;
        for (int i = 0; i < 4; i++) {
            linesData.add(new ProductionStatus(0,
                    "Line " + (i + 1),
                    initialTemp,
                    initialTemp,
                    initialStatus,
                    initialProduct,
                    initialOutputRate));
        }
    }

    public void refreshData() {
        LOG.info("[ SIMULATOR ] : refresh data called");
        linesData.forEach(p -> {
            p.setSensor1temp(p.getSensor1temp() + getRandomNumber());
            p.setSensor2temp(p.getSensor2temp() + getRandomNumber());
            statusService.saveStatus(p);
        });
    }

    public int getRandomNumber() {
        int max = 5, min = -5;
        int result = (int) ((Math.random() * (max - min)) + min);
        return result;
    }
}
