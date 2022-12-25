//ошибка была с объявлениями пакетов
//напахал с гитом, пришлось персоздать


package ru.yandex.praktikum;

import java.util.List;

public class Cat {

    private Predator predator;

    public Cat(Feline feline) {
        this.predator = feline;
    }

    public String getSound() {
        return "Мяу";
    }

    public List<String> getFood() throws Exception {
        return predator.eatMeat();
    }

}
