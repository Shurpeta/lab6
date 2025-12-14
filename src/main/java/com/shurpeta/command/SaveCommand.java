package com.shurpeta.command;

public class SaveCommand implements Command {
    private TariffManager manager;
    public SaveCommand(TariffManager manager) {
        this.manager = manager;
    }

    @Override
    public void execute(String details) {
        manager.saveToFile();
    }

    @Override
    public String getDescription() {
        return "Зберегти у файл";
    }
}