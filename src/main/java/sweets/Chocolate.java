package sweets;

//конкретный класс сладостей
//передает параметры в родит-кий класс

public class Chocolate extends Sweet {
    private String type; // type - уникальный параметр

    public Chocolate(String name, double weight, double price, String type) {
        super(name, weight, price, type);
        this.type = type;
    }

    public String getType(){
        return type;
    }
}