package com.adamwandoch.adamstudiesapis.factory.output;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.stream.Collectors;

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

    public long getTotalsReport() {
        // TODO: 14/06/2022 decide what do you need in the totals report
        // FIXME: 14/06/2022 implement the above
    }
}
