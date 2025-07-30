package sweets;

//базовый абстрактыный класс
//этот класс определяет общие характиричтики и поведение для всех видов сладостей
public abstract class Sweet {
    private String name; //название сладостей
    private double weight; //вес в граммах
    private double price; // цена
    private String uniqueParameter; //уникальный параметр(вкус, цвет и тд)

    //конструктор - инициализирует поля при создании объекта
    public Sweet(String name, double weight, double price, String uniqueParameter) {
        this.name = name;
        this.weight = weight;
        this.price = price;
        this.uniqueParameter = uniqueParameter;
    }

    //геттеры - позволяют получать значения полей извне класса
    public String getName() {
        return name;
    }

    public double getWeight() {
        return weight;
    }

    public double getPrice() {
        return price;
    }

    public String getUniqueParameter() {
        return uniqueParameter;
    }

    public double getValue() {
        return price / weight;
    }

    //переопределение метода для лучшего вывода информации
    @Override
    public String toString() {
        return String.format("%s (Вес: %.1f, Цена: %.1f, Параметр: %s)",
                name, weight, price, uniqueParameter);
    }
}