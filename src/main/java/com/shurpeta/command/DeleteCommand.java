package com.shurpeta.command;

import java.util.Scanner;

public class DeleteCommand implements Command {
    private TariffManager manager;

    public DeleteCommand(TariffManager manager) {
        this.manager = manager;
    }

    @Override
    public void execute(String details) {
        if (details != null && !details.isEmpty()) {
            manager.deleteTariff(details);
            return;
        }
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введіть назву тарифу для видалення: ");
        String name = scanner.nextLine();

        manager.deleteTariff(name);
    }

    @Override
    public String getDescription() {
        return "Видалити тариф (за назвою)";
    }
}