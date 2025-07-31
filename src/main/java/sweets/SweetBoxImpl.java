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
    // cоздаем временный список для сортировки
    List<Sweet> sorted = new ArrayList<>(sweets);
        sorted.sort(Comparator.comparingDouble(s -> s.getWeight() / s.getPrice()));

        while (getTotalWeight() > maxWeight && !sweets.isEmpty()) {
        // поиск индекса сладости с минимальной ценностью в основном списке
        Sweet toRemove = sorted.get(0);
        int index = sweets.indexOf(toRemove);

        if (index != -1) {
            Sweet removed = sweets.get(index);
            removeByIndex(index);
            sorted.remove(0);

            System.out.printf("Удалена сладость (ценность): %s, вес: %.1f, цена: %.1f, ценность: %.1f%n",
                    removed.getName(), removed.getWeight(), removed.getPrice(),
                    removed.getWeight() / removed.getPrice());
        }
    }
}
    @Override
    public void optimizeByPrice(double maxWeight) {
        // создание временного списка для сортировки
        List<Sweet> sorted = new ArrayList<>(sweets);
        sorted.sort(Comparator.comparingDouble(Sweet::getPrice));

        while (getTotalWeight() > maxWeight && !sweets.isEmpty()) {
            // поиск индекса самой дешевой сладости в основном списке
            Sweet toRemove = sorted.get(0);
            int index = sweets.indexOf(toRemove);

            if (index != -1) {
                Sweet removed = sweets.get(index);
                removeByIndex(index);
                sorted.remove(0);

                System.out.printf("Удалена сладость (цена): %s, вес: %.1f, цена: %.1f%n",
                        removed.getName(), removed.getWeight(), removed.getPrice());
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