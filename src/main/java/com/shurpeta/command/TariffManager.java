package com.shurpeta.command;

import com.shurpeta.models.BasicTariff;
import com.shurpeta.models.InternetTariff;
import com.shurpeta.models.Tariff;
import com.shurpeta.models.UnlimitedTariff;
import java.io.*;
import java.util.*;

import java.util.ArrayList;
import java.util.List;

public class TariffManager {
    private List<Tariff> tariffs = new ArrayList<>();
    private final String FILE_NAME = "tariffs.csv";

    public void loadFromFile() {
        tariffs.clear();
        File file = new File(FILE_NAME);

        if (!file.exists()) {
            System.out.println("Файл не знайдено. Генерую тестові дані...");
            loadTestDefaultData();
            return;
        }

        try (Scanner fileScanner = new Scanner(file)) {
            while (fileScanner.hasNextLine()) {
                parseLine(fileScanner.nextLine());
            }
            System.out.println("-> Дані завантажено.");
        } catch (Exception e) {
            System.out.println("Помилка читання: " + e.getMessage());
        }
    }

    private void parseLine(String line) {
        try {
            String[] parts = line.split(",");
            if (parts.length < 6) return;

            String type = parts[0];
            Tariff t = switch (type) {
                case "Basic" -> new BasicTariff(parts[1], Double.parseDouble(parts[2]), Integer.parseInt(parts[3]), Integer.parseInt(parts[4]), Integer.parseInt(parts[5]));
                case "Internet" -> new InternetTariff(parts[1], Double.parseDouble(parts[2]), Integer.parseInt(parts[3]), Integer.parseInt(parts[4]), Integer.parseInt(parts[5]));
                case "Unlimited" -> new UnlimitedTariff(parts[1], Double.parseDouble(parts[2]), Integer.parseInt(parts[3]), Integer.parseInt(parts[4]), Integer.parseInt(parts[5]));
                default -> null;
            };
            if (t != null) tariffs.add(t);
        } catch (Exception e) { }
    }

    private void loadTestDefaultData() {
        tariffs.add(new BasicTariff("Start", 100, 500, 100, 5));
        tariffs.add(new InternetTariff("NetPro", 200, 1000, 200, 50));
        tariffs.add(new UnlimitedTariff("Unlim", 400, 200, 9999, 9999));
        System.out.println("-> Тестові дані створено.");
    }

    public void saveToFile() {
        try (PrintWriter writer = new PrintWriter(new File(FILE_NAME))) {
            for (Tariff t : tariffs) writer.println(t.toCSV());
            System.out.println("-> Збережено.");
        } catch (IOException e) { System.out.println("Помилка: " + e.getMessage()); }
    }
    public void addTariff(Tariff tariff) {
        tariffs.add(tariff);
        System.out.println("-> Тариф '" + tariff.getName() + "' успішно додано до списку.");
        System.out.println("-> Не забудьте викликати 'save', щоб зберегти зміни у файл!");
    }

    public boolean deleteTariff(String name) {
        boolean removed = tariffs.removeIf(t -> t.getName().equalsIgnoreCase(name));

        if (removed) {
            System.out.println("-> Тариф '" + name + "' видалено.");
            System.out.println("-> Не забудьте викликати 'save'.");
        } else {
            System.out.println("-> Тариф з назвою '" + name + "' не знайдено.");
        }
        return removed;
    }

    public void showAll() {
        if (tariffs.isEmpty()) System.out.println("Список пустий.");
        else tariffs.forEach(System.out::println);
    }

    public void countClients() {
        int total = tariffs.stream().mapToInt(Tariff::getClients).sum();
        System.out.println("-> Клієнтів: " + total);
    }

    public void sort(boolean ascending) {
        tariffs.sort(Comparator.comparingDouble(Tariff::getPrice));
        if (!ascending) Collections.reverse(tariffs);
        System.out.println("-> Відсортовано.");
        showAll();
    }

    public void find(int minMin, int maxMin, int minGb, int maxGb) {
        boolean found = false;
        for (Tariff t : tariffs) {
            if (t.getMinutes() >= minMin && t.getMinutes() <= maxMin &&
                    t.getInternetGb() >= minGb && t.getInternetGb() <= maxGb) {
                System.out.println(t);
                found = true;
            }
        }
        if (!found) System.out.println("Нічого не знайдено.");
    }
}