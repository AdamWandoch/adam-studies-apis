package com.adamwandoch.adamstudiesapis.factory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author Adam Wandoch
 */

@RestController
@CrossOrigin
public class FactoryController {

    public static final Logger LOG = LoggerFactory.getLogger(FactoryController.class);

    @Autowired
    private ProductionLineDataService repository;

    @GetMapping("/factory/v1/get")
    public ProductionLineDataWrapper getAll() {
        System.out.println("[ FACTORY ] : get method called");
        return new ProductionLineDataWrapper(repository.getData());
    }

    @PostMapping("/factory/v1/save")
    public ResponseEntity saveData(@RequestBody ProductionLineData data) {
        System.out.println("[ FACTORY ] : save method called");
        repository.saveData(data);
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
