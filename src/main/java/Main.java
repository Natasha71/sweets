import sweets.*;

public class Main {
    public static void main(String[] args) {
        SweetBox sweetBox = new SweetBoxImpl();

        sweetBox.addSweet(new Chocolate("Twix", 50.0, 100.0, "карамель"));
        sweetBox.addSweet(new Chocolate("Alpen Gold", 100.0, 10.0, "70"));
        sweetBox.addSweet(new Candy("Mars", 30.0, 25.0, "розовый"));
        sweetBox.addSweet(new Candy("Snickers", 40.0, 80.0, "арахис"));
        sweetBox.addSweet(new Marmalade("Haribo", 20.0, 30.0, "красный"));

        System.out.println("=== Начальное состояние коробки ===");
        sweetBox.printBoxInfo();

        // оптимизация (сначала по весу, потом по цене)
        sweetBox.fullOptimization(150.0, 200.0);
    }
}