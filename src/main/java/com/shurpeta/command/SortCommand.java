package com.shurpeta.command;

public class SortCommand implements Command {
    private TariffManager manager;
    public SortCommand(TariffManager manager) { this.manager = manager; }

    @Override
    public void execute(String details) {
        boolean asc = (details == null || !details.trim().equalsIgnoreCase("desc"));
        manager.sort(asc);
    }

    @Override
    public String getDescription() {
        return "Сортувати (за замовчуванням зростання, 'desc' - спадання)";
    }
}
