package com.adamwandoch.adamstudiesapis.factory.output;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * @author Adam Wandoch
 */

@Service
public class OutputService {
    
    @Autowired
    private OutputRepository outputRepository;

    public OutputService() {
    }

    public ArrayList<OutputRecord> getOutputRecords() {
        ArrayList<OutputRecord> allData = new ArrayList<>();
        outputRepository.findAll().forEach(allData::add);
        return allData;
    }

    public void saveOutput(OutputRecord data) {
        outputRepository.save(data);
    }
}
