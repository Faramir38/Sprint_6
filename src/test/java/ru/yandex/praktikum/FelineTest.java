package ru.yandex.praktikum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;


import java.util.List;


@RunWith(Parameterized.class)
public class FelineTest {

    //данные для параметризованного теста getKittens
    private final int getKittensArg;
    private final int getKittensExpectedResult;

    public FelineTest (int getKittensArg, int getKittensExpectedResult) {
        this.getKittensArg = getKittensArg;
        this.getKittensExpectedResult = getKittensExpectedResult;
    }

    @Parameterized.Parameters
    public static Object[][] getGetKittensResult() {
        return new Object[][] {
                {1, 1},
                {0, 0},
                {15, 15}};
    }


    @Test
    //eatMeat()
    public void eatMeatReturnsPredatorsList() throws Exception {
        //Arrange
        List<String> expectedList = List.of("Животные", "Птицы", "Рыба");
        Feline feline = new Feline();
        //Act
        List<String> actualList = feline.eatMeat();
        //Assert
        Assert.assertEquals("Выведен неверный список в eatMeat", expectedList, actualList);
    }

    @Test
    //getFamily()
    public void getFamilyReturnsFeline() {
        //Arrange
        String expectedResult = "Кошачьи";
        Feline feline = new Feline();
        //Act
        String actualResult = feline.getFamily();
        //Assert
        Assert.assertEquals("Возвращаемое значение должно быть: Кошачьи", expectedResult,
                actualResult);
    }

    @Test
    //getKittens() without arguments
    public void getKittensWithoutArgReturnsOne() {
        //Arrange
        int expectedResult = 1;
        Feline feline = new Feline();
        //Act
        int actualResult = feline.getKittens();
        //Assert
        Assert.assertEquals("Возвращаемое значение должно быть: 1", expectedResult,
                actualResult);
    }

    @Test
    //getKittens() with arguments (параметризованный)
    public void getKittensWithArgReturnsArg() {
        //Arrange
        Feline feline = new Feline();
        //Act
        int actualResult = feline.getKittens(getKittensArg);
        //Assert
        Assert.assertEquals("Возвращаемое значение должно быть равно аргументу",
                getKittensExpectedResult, actualResult);
    }



}
