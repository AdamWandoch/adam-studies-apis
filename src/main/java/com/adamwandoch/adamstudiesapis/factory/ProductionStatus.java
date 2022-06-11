package com.adamwandoch.adamstudiesapis.factory;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

/**
 * @author Adam Wandoch
 */

@Entity
public class ProductionStatus {

    @Id
    @GeneratedValue
    private long id;
    private String lineName;
    private int sensor1temp;
    private int sensor2temp;
    private String status;
    private String currentProduct;
    private int outputRate;

    public ProductionStatus(long id, String lineName, int sensor1temp, int sensor2temp, String status, String currentProduct, int outputRate) {
        this.id = id;
        this.lineName = lineName;
        this.sensor1temp = sensor1temp;
        this.sensor2temp = sensor2temp;
        this.status = status;
        this.currentProduct = currentProduct;
        this.outputRate = outputRate;
    }

    public ProductionStatus() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLineName() {
        return lineName;
    }

    public void setLineName(String lineName) {
        this.lineName = lineName;
    }

    public int getSensor1temp() {
        return sensor1temp;
    }

    public void setSensor1temp(int sensor1temp) {
        this.sensor1temp = sensor1temp;
    }

    public int getSensor2temp() {
        return sensor2temp;
    }

    public void setSensor2temp(int sensor2temp) {
        this.sensor2temp = sensor2temp;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCurrentProduct() {
        return currentProduct;
    }

    public void setCurrentProduct(String currentProduct) {
        this.currentProduct = currentProduct;
    }

    public int getOutputRate() {
        return outputRate;
    }

    public void setOutputRate(int outputRate) {
        this.outputRate = outputRate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductionStatus that = (ProductionStatus) o;
        return id == that.id && sensor1temp == that.sensor1temp && sensor2temp == that.sensor2temp && Objects.equals(lineName, that.lineName) && Objects.equals(status, that.status) && Objects.equals(currentProduct, that.currentProduct);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, lineName, sensor1temp, sensor2temp, status, currentProduct);
    }

    @Override
    public String toString() {
        return "ProductionLineData{" +
                "id=" + id +
                ", lineName='" + lineName + '\'' +
                ", sensor1temp=" + sensor1temp +
                ", sensor2temp=" + sensor2temp +
                ", status='" + status + '\'' +
                ", currentProduct='" + currentProduct + '\'' +
                '}';
    }
}
