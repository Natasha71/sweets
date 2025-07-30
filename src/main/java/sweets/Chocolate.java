package sweets;

//конкретный класс сладостей
//передает параметры в родит-кий класс
public class Chocolate extends Sweet {
    public Chocolate(String name, double weight, double price, String type) {
        super(name, weight, price, type); // type - уникальный параметр для шокода
    }
}