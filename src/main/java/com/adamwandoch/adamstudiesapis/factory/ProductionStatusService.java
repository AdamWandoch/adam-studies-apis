package com.adamwandoch.adamstudiesapis.factory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * @author Adam Wandoch
 */

@Service
public class ProductionStatusService {

    @Autowired
    private ProductionStatusRepository productionLineDataRepository;

    public ProductionStatusService() {
    }

    public ArrayList<ProductionStatus> getStatus() {
        ArrayList<ProductionStatus> allData = new ArrayList<>();
        productionLineDataRepository.findAll().forEach(allData::add);
        return allData;
    }

    public void saveStatus(ProductionStatus data) {
        productionLineDataRepository.save(data);
    }
}
