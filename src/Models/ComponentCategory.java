package Models;

import java.util.Locale;

public enum ComponentCategory {
    CPU("Процессор"),
    GPU("Видеокарта"),
    RAM("Оперативная память"),
    MOTHERBOARD("Материнская плата"),
    STORAGE("Накопитель"),
    MOUSE("Компьютерная мышь"),
    MONITOR("Монитор"),
    KEYBOARD("Клавиатура"),
    POWER_SUPPLY_UNIT("Блок питания"),
    COMPUTER_CASE("Корпус"),
    COOLING("Система охлождения");

    private final String title;

    ComponentCategory(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return this.title;
    }
}
