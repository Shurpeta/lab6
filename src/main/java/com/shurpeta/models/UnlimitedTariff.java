package com.shurpeta.models;

public class UnlimitedTariff extends Tariff {
    public UnlimitedTariff(String name, double price, int clients, int minutes, int internetGb) {
        super(name, price, clients, minutes, internetGb);
    }
    @Override
    public String toCSV() {
        return "Unlimited," + super.toCSV();
    }
}