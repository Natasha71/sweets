package sweets;

//конкретный класс сладостей
//передает параметры в родит-кий класс
public class Marmalade extends Sweet {
    public Marmalade(String name, double weight, double price, String color) {
        super(name, weight, price, color); // color - цвет мармелада
    }
}