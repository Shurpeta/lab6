package com.shurpeta.command;

import com.shurpeta.models.*;
import java.util.Scanner;

public class AddCommand implements Command {
    private TariffManager manager;

    public AddCommand(TariffManager manager) {
        this.manager = manager;
    }

    @Override
    public void execute(String details) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Додавання нового тарифу");

            System.out.println("Оберіть тип (1 - Basic, 2 - Internet, 3 - Unlimited):");
            System.out.print("> ");
            int typeChoice = Integer.parseInt(scanner.nextLine());

            System.out.print("Введіть назву: ");
            String name = scanner.nextLine();

            System.out.print("Введіть ціну: ");
            double price = Double.parseDouble(scanner.nextLine());

            System.out.print("Кількість клієнтів: ");
            int clients = Integer.parseInt(scanner.nextLine());

            System.out.print("Хвилини: ");
            int minutes = Integer.parseInt(scanner.nextLine());

            System.out.print("Інтернет (ГБ): ");
            int gb = Integer.parseInt(scanner.nextLine());

            Tariff tariff = null;
            switch (typeChoice) {
                case 1 -> tariff = new BasicTariff(name, price, clients, minutes, gb);
                case 2 -> tariff = new InternetTariff(name, price, clients, minutes, gb);
                case 3 -> tariff = new UnlimitedTariff(name, price, clients, minutes, gb);
                default -> System.out.println("Невірний тип тарифу!");
            }

            if (tariff != null) {
                manager.addTariff(tariff);
            }

        } catch (NumberFormatException e) {
            System.out.println("Помилка: введено не число. Спробуйте ще раз.");
        }
    }

    @Override
    public String getDescription() {
        return "Додати новий тариф";
    }
}