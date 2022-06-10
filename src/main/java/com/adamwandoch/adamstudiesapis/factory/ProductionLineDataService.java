package com.adamwandoch.adamstudiesapis.factory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * @author Adam Wandoch
 */

@Service
public class ProductionLineDataService {

    @Autowired
    private ProductionLineDataRepository productionLineDataRepository;

    public ProductionLineDataService() {
    }

    public ArrayList<ProductionLineData> getData() {
        ArrayList<ProductionLineData> allData = new ArrayList<>();
        productionLineDataRepository.findAll().forEach(allData::add);
        return allData;
    }

    public void saveData(ProductionLineData data) {
        productionLineDataRepository.save(data);
    }
}
