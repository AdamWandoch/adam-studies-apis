package com.adamwandoch.adamstudiesapis.factory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

/**
 * @author Adam Wandoch
 */

@RestController
@CrossOrigin
public class FactoryController {

    public static final Logger LOG = LoggerFactory.getLogger(FactoryController.class);

    @Autowired
    private ProductionStatusService statusRepoService;

    @GetMapping("/factory/v1/getstatus")
    public ArrayList<ProductionStatus> getStatus() {
        LOG.info("[ FACTORY ] : get status called");
        return statusRepoService.getStatus();
    }

    @PostMapping("/factory/v1/savestatus")
    public ResponseEntity saveStatus(@RequestBody ProductionStatus data) {
        LOG.info("[ FACTORY ] : save status called");
        statusRepoService.saveStatus(data);
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
