package com.shurpeta.models;

public class BasicTariff extends Tariff {
    public BasicTariff(String name, double price, int clients, int minutes, int internetGb) {
        super(name, price, clients, minutes, internetGb);
    }
    @Override
    public String toCSV() {
        return "Basic," + super.toCSV();
    }
}