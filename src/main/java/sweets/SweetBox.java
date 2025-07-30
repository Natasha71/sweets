package sweets;

import java.util.List;

// класс который определяет методы, которые должна реализовать коробка со сладостями
public interface SweetBox {
    void addSweet(Sweet sweet); //добавить сладости в коробку
    void removeLast();//удалить послед-юю добав-ую сладость
    void removeByIndex(int index);//удалить сладость по индексу
    double getTotalWeight();//получить общий вес коробки
    double getTotalPrice();//получить общую стоимость
    void printAllSweets();//вывести информацию о всех сладостях
    void optimizeByWeight(double maxWeight);//оптимизировать по весу
    void optimizeByPrice(double maxWeight);//оптимизировать по цене
    void fullOptimization(double maxWeight, double maxPrice);
    void printBoxInfo();
    List<Sweet> getSweets();//получить список всех сладостей
}