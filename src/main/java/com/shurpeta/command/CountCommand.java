package com.shurpeta.command;


public class CountCommand implements Command {
    private TariffManager manager;
    public CountCommand(TariffManager manager) {
        this.manager = manager;
    }

    @Override
    public void execute(String details) {
        manager.countClients();
    }

    @Override
    public String getDescription() {
        return "Підрахувати клієнтів";
    }
}