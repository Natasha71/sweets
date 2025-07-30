package sweets;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

//реализация интерфейса свитбокс
public class SweetBoxImpl implements SweetBox {
    private List<Sweet> sweets = new ArrayList<>();

    //добавление сладостей в список
    @Override
    public void addSweet(Sweet sweet) {
        sweets.add(sweet);
    }
    //удаление послед-ей сладости
    @Override
    public void removeLast() {
        if (!sweets.isEmpty()) {
            sweets.remove(sweets.size() - 1);
        }
    }

    //удвление по индексу + проверка границ
    @Override
    public void removeByIndex(int index) {
        if (index >= 0 && index < sweets.size()) {
            sweets.remove(index);
        }
    }
    //суммирование веса всех сладостей
    @Override
    public double getTotalWeight() {
        return sweets.stream().mapToDouble(Sweet::getWeight).sum();
    }
    //суммирование цены всех сладостей
    @Override
    public double getTotalPrice() {
        return sweets.stream().mapToDouble(Sweet::getPrice).sum();
    }
    //вывод информацию о всех сладостях
    @Override
    public void printAllSweets() {
        sweets.forEach(System.out::println);
    }

    @Override
    public void optimizeByWeight(double maxWeight) {
        // Сортируем по весу по убыванию (чтобы удалять самые тяжелые сначала)
        sweets.sort(Comparator.comparingDouble(Sweet::getWeight).reversed());

        System.out.println("\nОптимизация веса (удаляем самые тяжелые):");
        while (getTotalWeight() > maxWeight && !sweets.isEmpty()) {
            Sweet removed = sweets.remove(0);
            System.out.printf("Удалено по весу: %s (вес: %.1f, цена: %.1f)\n",
                    removed.getName(), removed.getWeight(), removed.getPrice());
        }
    }

    public void optimizeByPrice(double maxPrice) {
        sweets.sort(Comparator.comparingDouble(Sweet::getPrice));

        System.out.println("\nОптимизация цены (удаляем самые дешевые):");
        while (getTotalPrice() > maxPrice && !sweets.isEmpty()) {
            Sweet removed = sweets.remove(0);
            System.out.printf("Удалено по цене: %s (цена: %.1f, вес: %.1f)\n",
                    removed.getName(), removed.getPrice(), removed.getWeight());
        }
    }

    public void fullOptimization(double maxWeight, double maxPrice) {
        System.out.println("\n=== Полная оптимизация ===");
        System.out.println("1. Оптимизация по весу (макс. " + maxWeight + ")");
        optimizeByWeight(maxWeight);

        System.out.println("\n2. Оптимизация по цене (макс. " + maxPrice + ")");
        optimizeByPrice(maxPrice);

        System.out.println("\nИтоговые параметры коробки:");
        printBoxInfo();
    }

    public void printBoxInfo() {
        System.out.println("=== Информация о коробке ===");
        System.out.printf("Общий вес: %.1f г\n", getTotalWeight());
        System.out.printf("Общая стоимость: %.1f руб\n", getTotalPrice());
        System.out.println("Содержимое коробки:");
        printAllSweets();
    }

    //возврат копии списка сладостей
    @Override
    public List<Sweet> getSweets() {
        return new ArrayList<>(sweets);
    }
}