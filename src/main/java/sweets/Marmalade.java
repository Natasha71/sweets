package sweets;

//конкретный класс сладостей
//передает параметры в родит-кий класс
public class Marmalade extends Sweet {

    private String color; // color - цвет мармелада
    public Marmalade(String name, double weight, double price, String color) {
        super(name, weight, price, color);
        this.color = color;
    }

    public String getColor(){
        return color;
    }

}