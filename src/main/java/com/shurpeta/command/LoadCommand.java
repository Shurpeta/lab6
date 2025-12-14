package com.shurpeta.command;

public class LoadCommand implements Command {
    private TariffManager manager;
    public LoadCommand(TariffManager manager) {
        this.manager = manager;
    }

    @Override
    public void execute(String details) {
        manager.loadFromFile();
    }

    @Override
    public String getDescription() {
        return "Завантажити з файлу";
    }
}