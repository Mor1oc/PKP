import Models.Component;
import Models.ComponentCategory;
import Models.Order;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Map<String, String> acc = new HashMap<>();
        acc.put("manager", "123");
        acc.put("warehouse", "123");
        SaveLoadFiles.saveAccounts(acc);
        Map<String, String> accounts = SaveLoadFiles.loadAccounts();
        while (true) {
            System.out.println("Выберити, что хотите сделать:\n" +
                    "1 -- Авторизоваться\n" +
                    "2 -- Зарегистрироваться\n" +
                    "else -- Закончить работу");
            Scanner in = new Scanner(System.in);
            String index = in.nextLine();
            switch (index) {
                case "1":
                    authorization(accounts);
                    break;
                case "2":
                    registration(accounts);
                    break;
                default:
                    System.exit(0);
            }
        }
    }

    private static void authorization(Map<String, String> accounts) {
        Scanner in = new Scanner(System.in);
        String login = "";
        boolean log = true;
        while (true) {
            if (log) {
                System.out.print("Введите логи: ");
                login = in.nextLine();
            }
            System.out.print("Введите пароль: ");
            String password = in.nextLine();
            if (!accounts.containsKey(login)) {
                System.out.println("Такого логина нет");
                return;
            } else if (!accounts.get(login).equals(password)) {
                System.out.println("Неправильный пароль");
                log = false;
            } else {
                switch (login) {
                    case "manager": {
                        managerMenu();
                        break;
                    }
                    case "warehouse":
                        storekeeperMenu();
                }
            }
        }

    }

    private static void registration(Map<String, String> accounts) {
        Scanner in = new Scanner(System.in);
        String login;
        while (true) {
            System.out.println("--------------------------------");
            System.out.print("Введите логин: ");
            login = in.nextLine();
            if (!accounts.containsKey(login))
                break;
            System.out.println("Пользователь с таким логином уже есть, придумайте новый");
        }
        System.out.print("Введите пароль: ");
        String password = in.nextLine();
        accounts.put(login, password);
        SaveLoadFiles.saveAccounts(accounts);
        storekeeperMenu();
    }

    private static void managerMenu() {
        while (true) {
            System.out.println("""
                    -----------------------------------------
                    1 -- Просмотр информации о запасах
                    2 -- Планирование закупок
                    3 -- Оформление заказов
                    4 -- Выйти из аккаунта
                    -----------------------------------------""");
            Scanner in = new Scanner(System.in);
            int index = in.nextInt();
            switch (index) {
                case 1:
                    showAllComponents();
                    break;
                case 2:
                    planingOrders();
                    break;
                case 3:

                    break;
                case 4:
                    return;
            }
        }
    }

    private static void storekeeperMenu() {
        while (true) {
            System.out.println("""
                    -----------------------------------------
                    1 -- Просмотр информации о запасах
                    2 -- Учет приходов и расходов
                    3 -- Изменение данных о текущих запасах
                    4 -- Выйти из аккаунта
                    -----------------------------------------""");
            Scanner in = new Scanner(System.in);
            int index = in.nextInt();
            System.out.println("-----------------------------------------");
            switch (index) {
                case 1:
                    showAllComponents();
                    break;
                case 2:

                    break;
                case 3:
                    inventory();
                    break;
                case 4:
                    return;
            }
        }
    }

    public static void printComponents(ArrayList<Component> components) {
        int length = components.size();
        for (int i = 0; i < length; i++)
            System.out.println(STR."\{i + 1} \{components.get(i).toString()}");
    }

    /**
     * Просмотр инфомации о запасах
     */
    public static void showAllComponents() {
        var list = new ArrayList<Component>();
        list.add(new Component("Процессор Intel", ComponentCategory.CPU, "Intel", "Core i5-12400K", 445, 18));
        list.add(new Component("Видеокарта NVIDIA", ComponentCategory.GPU, "Ventus", "RTX 3060 12GB", 1190, 10));
        list.add(new Component("Процессор AMD", ComponentCategory.CPU, "AMD", "Ryzen 5 7600X", 560, 7));
        list.add(new Component("Материнская плата Colorful", ComponentCategory.MOTHERBOARD, "Colorful", "B760M-D", 410, 21));
        list.add(new Component("SSD Накопитель", ComponentCategory.STORAGE, "Samsung", "870 Evo", 320, 33));
        list.add(new Component("Оперативная память Corsair", ComponentCategory.RAM, "Corsair", "Vengeance LPX 16GB", 116, 25));
        list.add(new Component("Блок питания Cooler Master", ComponentCategory.POWER_SUPPLY_UNIT, "Cooler Master", "V750 Gold", 140, 34));
        list.add(new Component("Монитор Dell", ComponentCategory.MONITOR, "Dell", "UltraSharp U2720Q", 1700, 3));
        list.add(new Component("Клавиатура Logitech", ComponentCategory.KEYBOARD, "Logitech", "MX Keys", 350, 15));
        list.add(new Component("Мышь Razer", ComponentCategory.MOUSE, "Razer", "DeathAdder V2", 430, 11));
        SaveLoadFiles.saveComponents(list);
        var components = SaveLoadFiles.loadComponents();
        printComponents(components);
    }

    /**
     * Планирование закупок
     */
    public static void planingOrders() {
//        var list = new ArrayList<Order>();
//        list.add(new Order(
//                LocalDate.of(2024, 8, 10),
//                LocalDate.of(2024, 8, 23),
//                new Component("Внешний жёсткий диск Seagate", ComponentCategory.STORAGE, "Seagate", "Backup Plus 4TB", 230, 15),
//                15));
//        list.add(new Order(
//                LocalDate.of(2024, 9, 4),
//                LocalDate.of(2024, 9, 12),
//                new Component("Корпус NZXT", ComponentCategory.COMPUTER_CASE, "NZXT", "H510 Elite", 260, 10),
//                10));
//        list.add(new Order(
//                LocalDate.of(2024, 9, 6),
//                LocalDate.of(2024, 9, 13),
//                new Component("Вентилятор Noctua", ComponentCategory.COOLING, "Noctua", "NF-A12x25 PWM", 45, 20),
//                20));
//        list.add(new Order(
//                LocalDate.of(2024, 9, 15),
//                LocalDate.of(2024, 9, 24),
//                new Component("Материнская плата ASUS", ComponentCategory.MOTHERBOARD, "ASUS", "ROG Strix Z490-E", 560, 10),
//                10));
//        list.add(new Order(
//                LocalDate.of(2024, 9, 25),
//                LocalDate.of(2024, 10, 3),
//                new Component("Игровой монитор Xiaomi Redmi", ComponentCategory.MONITOR, "Xiaomi Redmi", "G24 A24FAA-RG", 335, 8),
//                8));
//        SaveLoadFiles.saveOrders(list);
        var orders = SaveLoadFiles.loadOrders();
        var components = SaveLoadFiles.loadComponents();
        System.out.println("Текущее количество комплектующих:");
        int len = components.size(), i = 0;
        while (i < len) {
            var component = components.get(i++);
            System.out.println(STR."\{i} Название: \{component.getName()} Модель: \{component.getModel()} Количество: \{component.getQuantity()}");
        }
        System.out.println("---------------------------\nТекущее заказы:");
        for (Order order : orders)
            System.out.println(STR."Заказ: \{order}");
        while (true) {
            System.out.print("---------------------------\nВведите номер компонента, который хотите заказать\nили введите слово 'new':");
            try {
                Scanner in = new Scanner(System.in);
                String stringIndex = in.nextLine();
                if (stringIndex.equals("new")) {
//                System.out.print("Введите дату заказа (Например, '2024 10 10'): ");
//                String orderDate = in.nextLine();
//                int orderYear = Integer.parseInt(orderDate.substring(0,4));
//                int orderMonth = Integer.parseInt(orderDate.substring(5,7));
//                int orderDayOfMonth = Integer.parseInt(orderDate.substring(8));
                    System.out.print("Введите дату доставки (Например, '2024 10 10'): ");
                    String deliveryDate = in.nextLine();
                    int deliveryYear = Integer.parseInt(deliveryDate.substring(0, 4));
                    int deliveryMonth = Integer.parseInt(deliveryDate.substring(5, 7));
                    int deliveryDayOfMonth = Integer.parseInt(deliveryDate.substring(8));
                    System.out.println("Введите всё необходимую информацию о комплектующем: ");
                    System.out.print("Введите название: ");
                    String name = in.nextLine();
                    System.out.println("Введите одну из следующих категорий\n(CPU,GPU,RAM,STORAGE,MOUSE,MONITOR,KEYBOARD,POWER_SUPPLY_UNIT,COMPUTER_CASE,COOLING):");
                    String categoryOfComponent = in.nextLine();
                    ComponentCategory category = ComponentCategory.valueOf(categoryOfComponent.toUpperCase());
                    System.out.print("Введите производителя: ");
                    String manufacture = in.nextLine();
                    System.out.print("Введите модель: ");
                    String model = in.nextLine();
                    System.out.print("Введите стоимость: ");
                    String priceOfComponent = in.nextLine();
                    int price = Integer.parseInt(priceOfComponent);
                    System.out.print("Введите количество: ");
                    String quantityOfComponent = in.nextLine();
                    int quantity = Integer.parseInt(quantityOfComponent);
                    orders.add(new Order(
                            LocalDate.now(),
                            LocalDate.of(deliveryYear, deliveryMonth, deliveryDayOfMonth),
                            new Component(name, category, manufacture, model, price, quantity),
                            quantity
                    ));
                } else {
                    int index = Integer.parseInt(stringIndex);
                    if (!(index > 0 && index < len + 1))
                        throw new Exception();
                    var component = components.get(index - 1);
                    System.out.print("Введите дату доставки (Например, '2024 10 10'): ");
                    String deliveryDate = in.nextLine();
                    int deliveryYear = Integer.parseInt(deliveryDate.substring(0, 4));
                    int deliveryMonth = Integer.parseInt(deliveryDate.substring(5, 7));
                    int deliveryDayOfMonth = Integer.parseInt(deliveryDate.substring(8));
                    System.out.print("Введите количество: ");
                    String quantityOfComponent = in.nextLine();
                    int quantity = Integer.parseInt(quantityOfComponent);
                    component.setQuantity(quantity);
                    orders.add(new Order(
                            LocalDate.now(),
                            LocalDate.of(deliveryYear, deliveryMonth, deliveryDayOfMonth),
                            component,
                            quantity
                    ));
                }
                SaveLoadFiles.saveOrders(orders);
                System.out.println("\n**** Добавление заказа прошло успешно ****");
                break;
            } catch (Exception e) {
                System.out.println("""
                        ******************
                        Некорректный ввод
                        ******************""");
            }
        }
    }

    /**
     * Изменение данных о текущих запасах
     */
    public static void inventory() {
        var components = SaveLoadFiles.loadComponents();
        printComponents(components);
        while (true) {
            System.out.print("\nНапишите номер комплектующего,\n количество которого хотите изменить: ");
            try {
                Scanner in = new Scanner(System.in);
                String stringIndex = in.nextLine();
                int index = Integer.parseInt(stringIndex);
                if (!(index > 0 && index < components.size() + 1))
                    throw new Exception();
                System.out.print("\nВведите новое количество комплектующего: ");
                stringIndex = in.nextLine();
                int quantity = Integer.parseInt(stringIndex);
                if (quantity < 0 || quantity > 400)
                    throw new Exception();
                components.get(index - 1).setQuantity(quantity);
                SaveLoadFiles.saveComponents(components);
                System.out.println("\n**** Количество успешно обновлено ****");
                break;
            } catch (Exception e) {
                System.out.println("""
                        ******************
                        Некорректный ввод
                        ******************""");
            }
        }

    }
}