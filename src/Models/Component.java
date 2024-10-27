package Models;

import java.io.Serializable;
import java.util.Objects;

public class Component implements Serializable {
    private String name;
    private ComponentCategory category;
    private String manufacture;
    private String model;
    private int price;
    private int quantity;

    public Component(String name, ComponentCategory category, String manufacture, String model, int price, int quantity) {
        this.name = name;
        this.category = category;
        this.manufacture = manufacture;
        this.model = model;
        this.price = price;
        this.quantity = quantity;
    }

    public Component(Component component) {
        this.name = component.name;
        this.category = component.category;
        this.manufacture = component.manufacture;
        this.model = component.model;
        this.price = component.price;
        this.quantity = component.quantity;
    }

    public Component clone() {  // Прототип
        return new Component(this);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ComponentCategory getCategory() {
        return category;
    }

    public void setCategory(ComponentCategory category) {
        this.category = category;
    }

    public String getManufacture() {
        return manufacture;
    }

    public void setManufacture(String manufacture) {
        this.manufacture = manufacture;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return STR."Название: \{name}\{'\''}, Категория: \{category}, Производитель: '\{manufacture}\{'\''}, Модель: '\{model}\{'\''}, Цена: \{price}, Количество: \{quantity}\{'}'}";
    }
}
