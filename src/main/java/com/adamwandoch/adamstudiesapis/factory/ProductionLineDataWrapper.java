package com.adamwandoch.adamstudiesapis.factory;

import java.util.ArrayList;

/**
 * @author Adam Wandoch
 */

public class ProductionLineDataWrapper {

    private ArrayList<ProductionLineData> data;

    public ProductionLineDataWrapper(ArrayList<ProductionLineData> data) {
        this.data = data;
    }

    public ProductionLineDataWrapper() {
    }

    public ArrayList<ProductionLineData> getData() {
        return data;
    }

    public void setData(ArrayList<ProductionLineData> data) {
        this.data = data;
    }
}
