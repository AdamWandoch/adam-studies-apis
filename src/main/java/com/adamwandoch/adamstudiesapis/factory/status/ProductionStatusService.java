package com.adamwandoch.adamstudiesapis.factory.status;

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

    public void setStatus(ProductionStatus oldStatus) {
        ProductionStatus newStatus = new ProductionStatus(oldStatus.getId(),
                oldStatus.getLineName(),
                oldStatus.getSensor1temp(),
                oldStatus.getSensor2temp(),
                "",
                "",
                0);

    }
}
