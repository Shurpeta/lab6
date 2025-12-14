package com.shurpeta.command;

public class ViewCommand implements Command {
    private TariffManager manager;
    public ViewCommand(TariffManager manager) { this.manager = manager; }

    @Override
    public void execute(String details) { manager.showAll(); }

    @Override
    public String getDescription() { return "Показати всі тарифи"; }
}