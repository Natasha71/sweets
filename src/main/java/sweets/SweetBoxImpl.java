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

    public void optimizeByWeight(double maxWeight) {
        // копия для сортировки
        List<Sweet> sortedByWeight = new ArrayList<>(sweets);

        // сортировка от лег  к тяж
        sortedByWeight.sort(Comparator.comparingDouble(Sweet::getWeight));

        while (getTotalWeight() > maxWeight && !sortedByWeight.isEmpty()) {
            Sweet lightest = sortedByWeight.remove(0); // самая легкая
            int index = sweets.indexOf(lightest);
            if (index != -1) {
                removeByIndex(index); //удаление
                System.out.printf("Удалена лёгкая сладость: %s (Вес: %.1fг)\n",
                        lightest.getName(), lightest.getWeight());
            }
        }
    }
    @Override
    public void optimizeByPrice(double maxWeight) {
        // копия для сортирвоки
        List<Sweet> sortedByPrice = new ArrayList<>(sweets);

        // сортировка от деш к дорогим
        sortedByPrice.sort(Comparator.comparingDouble(Sweet::getPrice));

        while (getTotalWeight() > maxWeight && !sortedByPrice.isEmpty()) {
            Sweet cheapest = sortedByPrice.remove(0); //самая деш
            int index = sweets.indexOf(cheapest);
            if (index != -1) {
                removeByIndex(index); // удаляем
                System.out.printf("Удалена дешёвая сладость: %s (Цена: %.1fр)\n",
                        cheapest.getName(), cheapest.getPrice());
            }
        }
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