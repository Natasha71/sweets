package sweets;


//конкретный класс сладостей
//передает параметры в родит-кий класс
public class Candy extends Sweet {

    private String flavor; //уникальный параметр

    public Candy(String name, double weight, double price, String flavor) {
        super(name, weight, price, flavor);
        this.flavor = flavor;
}

public String getFlavor(){
    return flavor;
    };
}
