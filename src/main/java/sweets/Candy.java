package sweets;


//конкретный класс сладостей
//передает параметры в родит-кий класс
public class Candy extends Sweet {
    public Candy(String name, double weight, double price, String flavor) {
        super(name, weight, price, flavor); //flavor- уникальный параметр для шокода
    }
}