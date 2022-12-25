//ошибка была с объявлениями пакетов
//напахал с гитом, пришлось пересоздать, комменты к сожалению потерялись(


package ru.yandex.praktikum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {
    @Mock
    Feline feline;

    @Test
    //getSound
    public void getSoundReturnsMyau() {
        //Arrange
        Cat cat = new Cat(feline);
        String expectedResult = "Мяу";
        //Act
        String actualResult = cat.getSound();
        //Assert
        Assert.assertEquals("Возвращаемое значение должно быть: Мяу", expectedResult,
                actualResult);
    }

    @Test
    //getFood
    public void getFoodReturnsPredatorList() throws Exception {
        //Arrange
        Cat cat = new Cat(feline);
        List<String> expectedResult = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(feline.eatMeat()).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        //Act
        List<String> actualResult = cat.getFood();
        //Assert
        Assert.assertEquals("Возвращаемый список должен быть: [Животные, Птицы, Рыба]",
                expectedResult, actualResult);

    }
}
