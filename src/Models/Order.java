package Models;

import java.io.Serializable;
import java.time.LocalDate;

public class Order implements Serializable {
    private LocalDate orderDate;
    private LocalDate deliveryDate;
    private Component component;
    private int quantity;

    public Order(LocalDate orderDate, LocalDate deliveryDate, Component component, int quantity) {
        this.orderDate = orderDate;
        this.deliveryDate = deliveryDate;
        this.component = component;
        this.quantity = quantity;
    }

    public Component getComponent() {
        return component.clone();
    }

    @Override
    public String toString() {
        return STR."Дата заказа: \{orderDate}, \n\tДата доставки: \{deliveryDate}, \n\tКомплектующая: [ Название: \{component.getName()} Модель: \{component.getModel()} ], \n\tКоличество: \{quantity}";
    }
}
