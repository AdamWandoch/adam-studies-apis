package com.adamwandoch.adamstudiesapis.factory.output;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

/**
 * @author Adam Wandoch
 */

@Entity
public class OutputRecord {

    @Id
    @GeneratedValue
    private long id;
    private String productName;
    private String lineName;
    private long amount;

    public OutputRecord() {
    }

    public OutputRecord(long id, String productName, String lineName, long amount) {
        this.id = id;
        this.productName = productName;
        this.lineName = lineName;
        this.amount = amount;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getLineName() {
        return lineName;
    }

    public void setLineName(String lineName) {
        this.lineName = lineName;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, productName, lineName, amount);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OutputRecord that = (OutputRecord) o;
        return id == that.id && amount == that.amount && Objects.equals(productName, that.productName) && Objects.equals(lineName, that.lineName);
    }

    @Override
    public String toString() {
        return "OutputRecord{" +
                "id=" + id +
                ", productName='" + productName + '\'' +
                ", lineName='" + lineName + '\'' +
                ", amount=" + amount +
                '}';
    }
}
