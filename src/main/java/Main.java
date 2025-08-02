import sweets.*;


/*
Оптимизация по весу:
сортировка от легких к тяжелым, последовательное удаление самых легкие, пока вес не станет ≤ maxWeight


Оптимизация по цене:
сортируем от дешевых к дорогим, удаляем самые дешевые, пока вес не станет ≤ maxWeight
 */
public class Main {
    public static void main(String[] args) {
        //создание коробки
        SweetBox sweetBox = new SweetBoxImpl();

        //добавление сладостей
        sweetBox.addSweet(new Chocolate("Twix", 50.0, 45.0, "карамель"));
        sweetBox.addSweet(new Candy("Mars", 10.0, 25.0, "розовый"));
        sweetBox.addSweet(new Candy("Snickers", 40.0, 60.0, "арахис"));
        sweetBox.addSweet(new Marmalade("Haribo", 20.0, 30.0, "красный"));
        sweetBox.addSweet(new Chocolate("Dave", 70.0, 35.0, "карамель"));
        sweetBox.addSweet(new Candy("Milka", 40.0, 45.0, "розовый"));
        sweetBox.addSweet(new Candy("Leo", 90.0, 60.0, "арахис"));
        sweetBox.addSweet(new Marmalade("MixBar", 85.0, 90.0, "красный"));

        //информация о коробке
        System.out.println("Начальный вес: " + sweetBox.getTotalWeight());
        System.out.println("Начальная цена: " + sweetBox.getTotalPrice());
        sweetBox.printAllSweets();

        System.out.println("\nОптимизация по весу (макс. вес 320:");
        sweetBox.optimizeByWeight(320);

        System.out.println("\nОптимизированный вес: " + sweetBox.getTotalWeight());
        sweetBox.printAllSweets();


        System.out.println("\nПеред оптимизацией по цене:");
        System.out.println("Вес: " + sweetBox.getTotalWeight());
        System.out.println("Цена: " + sweetBox.getTotalPrice());
        sweetBox.printAllSweets();

        System.out.println("\nОптимизация по цене (макс. вес 300):");
        sweetBox.optimizeByPrice(250);

        System.out.println("\nПосле оптимизации по цене:");
        System.out.println("Вес: " + sweetBox.getTotalWeight());
        System.out.println("Цена: " + sweetBox.getTotalPrice());
        sweetBox.printAllSweets();
    }
}