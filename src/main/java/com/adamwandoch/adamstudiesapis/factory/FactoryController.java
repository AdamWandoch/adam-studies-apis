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
        return statusService.getStatus();
    }

// THIS ENDPOINT CONTROLS EACH FIELD OF THE STATUS BUT ONLY ALL TOGETHER
    @PostMapping("/factory/v1/savestatus")
    public ResponseEntity saveStatus(@RequestBody ProductionStatus data) {
        statusService.saveStatus(data);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/factory/v1/getoutputs")
    public ArrayList<OutputRecord> getOutputs() {
        return outputService.getOutputRecords();
    }
}
