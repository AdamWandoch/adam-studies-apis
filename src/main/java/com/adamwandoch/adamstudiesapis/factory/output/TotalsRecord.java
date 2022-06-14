package com.adamwandoch.adamstudiesapis.factory.output;

import java.util.Objects;

/**
 * @author Adam Wandoch
 */

public class TotalsRecord {

    private String lineName;
    private String productName;
    private long amount;

    public TotalsRecord() {
    }

    public TotalsRecord(String lineName, String productName, long amount) {
        this.lineName = lineName;
        this.productName = productName;
        this.amount = amount;
    }

    public String getLineName() {
        return lineName;
    }

    public void setLineName(String lineName) {
        this.lineName = lineName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(lineName, productName, amount);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TotalsRecord that = (TotalsRecord) o;
        return amount == that.amount && Objects.equals(lineName, that.lineName) && Objects.equals(productName, that.productName);
    }

    @Override
    public String toString() {
        return "TotalsRecord{" +
                "lineName='" + lineName + '\'' +
                ", productName='" + productName + '\'' +
                ", amount=" + amount +
                '}';
    }
}
