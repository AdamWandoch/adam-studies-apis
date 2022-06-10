package com.adamwandoch.adamstudiesapis.factory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Adam Wandoch
 */

@Service
public class FactorySimulator {

    private static final Logger LOG = LoggerFactory.getLogger(FactorySimulator.class);

    @Autowired
    private ProductionLineDataRepository repository;

    public FactorySimulator() {
    }

    public void startProduction() {
        LOG.info("[ SIMULATOR ] : start production called");
        ProductionLineData data = new ProductionLineData(0,
                "Line 1",
                25,
                29,
                "idle",
                "none");
        repository.save(data);
    }
}
