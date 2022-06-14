package com.adamwandoch.adamstudiesapis.factory;

import com.adamwandoch.adamstudiesapis.factory.output.OutputRecord;
import com.adamwandoch.adamstudiesapis.factory.output.OutputService;
import com.adamwandoch.adamstudiesapis.factory.status.ProductionStatus;
import com.adamwandoch.adamstudiesapis.factory.status.ProductionStatusService;
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
    private ProductionStatusService statusService;
    @Autowired
    private OutputService outputService;

    @GetMapping("/factory/v1/getstatus")
    public ArrayList<ProductionStatus> getStatus() {
        LOG.info("[ FACTORY ] : get status called");
        return statusService.getStatus();
    }

// THIS ENDPOINT CONTROLS EACH FIELD OF THE STATUS BUT ONLY ALL TOGETHER
    @PostMapping("/factory/v1/savestatus")
    public ResponseEntity saveStatus(@RequestBody ProductionStatus data) {
        LOG.info("[ FACTORY ] : save status called");
        statusService.saveStatus(data);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    // TODO: 14/06/2022 implement a way to control each field individually

    @GetMapping("/factory/v1/getoutputs")
    public ArrayList<OutputRecord> getOutputs() {
        LOG.info("[ FACTORY ] : get outputs called");
        return outputService.getOutputRecords();
    }

    @GetMapping("/factory/v1/gettotalsreport")
    public long getTotalsReport() {
        LOG.info("[ FACTORY ] : get totals report called");
        return outputService.getTotalsReport();
    }
}
