package com.shurpeta.models;

public class InternetTariff extends Tariff {
    public InternetTariff(String name, double price, int clients, int minutes, int internetGb) {
        super(name, price, clients, minutes, internetGb);
    }
    @Override
    public String toCSV() {
        return "Internet," + super.toCSV();
    }
}