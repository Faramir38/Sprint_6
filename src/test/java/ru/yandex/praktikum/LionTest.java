//ошибка была с объявлениями пакетов
//напахал с гитом, пришлось персоздать
package ru.yandex.praktikum;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.List;

@RunWith(Parameterized.class)
public class LionTest {

    //подключаем Mockito
    @Before
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Mock
    Feline feline;

    //Готовим данные для параметризованного теста doesHaveMane
    private final String sex;
    private final boolean expectedHasMane;
    private final String expectedExceptionMessage;

    public LionTest(String sex, boolean expectedHasMane, String expectedExceptionMessage) {
        this.sex = sex;
        this.expectedHasMane = expectedHasMane;
        this.expectedExceptionMessage = expectedExceptionMessage;
    }

    @Parameterized.Parameters
    public static Object[][] getDoesHaveManeResult() {
        return new Object[][] {
                {"Самец", true, ""},
                {"Самка", false, ""},
                {"Никто", true, "Используйте допустимые значения пола животного - самец или самка"}
        };
    }


    @Test
    //getKittens
    public void getKittensReturnsOne() throws Exception {
        //Arrange
        Lion lion = new Lion(feline, "Самка");
        Mockito.when(feline.getKittens()).thenReturn(1);
        int expectedResult = 1;
        //Act
        int actualResult = lion.getKittens();
        //Assert
        Assert.assertEquals("Возвращаемое значение должно быть: 1", expectedResult,
                actualResult);
    }

    @Test
    //doesHaveMane (параметризованный)
    public void doesHaveManeReturnsCorrectManeValue() {
        try {
            //Arrange
            Lion lion = new Lion(feline, sex);
            //Act
            boolean actualResult = lion.doesHaveMane();
            //Assert
            Assert.assertEquals("Возвращает неверное значение hasMane", expectedHasMane,
                    actualResult);
        }
        catch (Exception e) {
            Assert.assertEquals(e.getMessage(), expectedExceptionMessage);
        }
    }

    @Test
    //getFood
    public void getFoodReturnsPredatorList() throws Exception {
        //Arrange
        Lion lion = new Lion(feline, "Самец");
        List<String> expectedResult = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(feline.getFood("Хищник")).
                thenReturn(List.of("Животные", "Птицы", "Рыба"));
        //Act
        List<String> actualResult = lion.getFood();
        //Assert
        Assert.assertEquals("Возвращаемый список должен быть: [Животные, Птицы, Рыба]",
                expectedResult, actualResult);

    }
}
