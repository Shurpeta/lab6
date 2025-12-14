package com.shurpeta;

import com.shurpeta.command.*;
import java.util.Map;
import java.util.Scanner;

public class Menu {
    private Map<String, Command> menuItems;

    public Menu() {
        CommandInvoker invoker = new CommandInvoker();
        this.menuItems = invoker.getCommands();
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Мобільний Оператор");
        System.out.println("Введіть 'help' для списку або 'exit' для виходу.");

        while (true) {
            System.out.print("\n> ");
            String input = scanner.nextLine().trim();
            if (input.isEmpty()) continue;

            String[] parts = input.split(" ", 2);
            String commandKey = parts[0].toLowerCase();
            String details = (parts.length > 1) ? parts[1] : null;

            if (commandKey.equals("exit")) {
                System.out.println("Робота завершена.");
                break;
            }

            if (commandKey.equals("help")) {
                showHelp();
                continue;
            }

            if (menuItems.containsKey(commandKey)) {
                menuItems.get(commandKey).execute(details);
            } else {
                System.out.println("Невідома команда.");
            }
        }
    }

    private void showHelp() {
        System.out.println("help : Показати команди");
        System.out.println("exit : Вихід");
        for (Map.Entry<String, Command> entry : menuItems.entrySet()) {
            System.out.printf("%-6s : %s%n", entry.getKey(), entry.getValue().getDescription());
        }
    }
}