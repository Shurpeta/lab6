package com.shurpeta.models;

public abstract class Tariff {
    private String name;
    private double price;
    private int clients;
    private int minutes;
    private int internetGb;

    public Tariff(String name, double price, int clients, int minutes, int internetGb) {
        this.name = name;
        this.price = price;
        this.clients = clients;
        this.minutes = minutes;
        this.internetGb = internetGb;
    }

    public double getPrice() { return price; }
    public int getClients() { return clients; }
    public int getMinutes() { return minutes; }
    public int getInternetGb() { return internetGb; }
    public String getName() { return name; }

    public String toCSV() {
        return name + "," + price + "," + clients + "," + minutes + "," + internetGb;
    }

    @Override
    public String toString() {
        return String.format("Тариф: %-12s | Ціна: %-6.2f | Клієнтів: %-5d | Хв: %-4d | ГБ: %-4d",
                name, price, clients, minutes, internetGb);
    }
}
