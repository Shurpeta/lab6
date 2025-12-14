package com.shurpeta.command;

import java.util.Scanner;

public class FindCommand implements Command {
    private TariffManager manager;
    public FindCommand(TariffManager manager) { this.manager = manager; }

    @Override
    public void execute(String details) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Введіть 4 числа через пробіл (хв_мін хв_макс ГБ_мін ГБ_макс):");
            System.out.print("> ");
            String line = scanner.nextLine();
            String[] parts = line.split(" ");

            if (parts.length < 4) {
                System.out.println("Помилка: потрібно 4 числа.");
                return;
            }

            manager.find(
                    Integer.parseInt(parts[0]), Integer.parseInt(parts[1]),
                    Integer.parseInt(parts[2]), Integer.parseInt(parts[3])
            );
        } catch (NumberFormatException e) {
            System.out.println("Вводьте лише цифри");
        }
    }

    @Override
    public String getDescription() {
        return "Знайти тариф за параметрами";
    }
}