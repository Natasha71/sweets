import sweets.*;

public class Main {
    public static void main(String[] args) {
        SweetBox sweetBox = new SweetBoxImpl();

        sweetBox.addSweet(new Chocolate("Twix", 50.0, 45.0, "карамель"));
        sweetBox.addSweet(new Chocolate("Alpen Gold", 45.0, 10.0, "70"));
        sweetBox.addSweet(new Candy("Mars", 30.0, 25.0, "розовый"));
        sweetBox.addSweet(new Candy("Snickers", 40.0, 60.0, "арахис"));
        sweetBox.addSweet(new Marmalade("Haribo", 20.0, 30.0, "красный"));

        System.out.println("Начальный вес: " + sweetBox.getTotalWeight());
        System.out.println("Начальная цена: " + sweetBox.getTotalPrice());
        sweetBox.printAllSweets();

        System.out.println("\nОптимизация по весу (макс. вес 140:");
        sweetBox.optimizeByWeight(140);

        System.out.println("\nОптимизированный вес: " + sweetBox.getTotalWeight());
        sweetBox.printAllSweets();


        System.out.println("\nПеред оптимизацией по цене:");
        System.out.println("Вес: " + sweetBox.getTotalWeight());
        System.out.println("Цена: " + sweetBox.getTotalPrice());
        sweetBox.printAllSweets();

        System.out.println("\nОптимизация по цене (макс. вес 70):");
        sweetBox.optimizeByPrice(100);

        System.out.println("\nПосле оптимизации по цене:");
        System.out.println("Вес: " + sweetBox.getTotalWeight());
        System.out.println("Цена: " + sweetBox.getTotalPrice());
        sweetBox.printAllSweets();
    }
}