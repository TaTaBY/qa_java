package com.example;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    @Mock
    Feline feline;

    @Test
    public void validateGetKittensLion() throws Exception {
        Lion lion = new Lion("Самец", feline);
        Mockito.when(feline.getKittens()).thenReturn(1);
        int expected = 1;
        int actual = lion.getKittens();
        assertEquals(expected,actual);
    }

    @Test
    public void validateDoesHaveManeWhenMale() throws Exception {
        Lion lion = new Lion("Самец", feline);
        boolean expected = true;
        boolean actual = lion.doesHaveMane();
        assertEquals(expected, actual);
    }

    @Test
    public void validateDoesHaveManeWhenFemale() throws Exception {
        Lion lion = new Lion("Самка", feline);
        boolean expected = false;
        boolean actual = lion.doesHaveMane();
        assertEquals(expected, actual);
    }

    @Test
    public void validateGetFoodLion() throws Exception {
        Lion lion = new Lion("Самец", feline);
        Mockito.when(feline.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        List<String> actual = lion.getFood();
        assertEquals(expected, actual);
    }

    @Test
    public void validateConstructorLionWithSexWhichNotExistShouldThrowExceptionWithCorrectMessage() throws Exception {
        try {
            new Lion("Другое", feline);
        } catch (Exception e) {
            assertEquals("Используйте допустимые значения пола животного - самей или самка",
                    e.getMessage());
            return;
        }
        fail("Expected validation exception was not thrown");
    }
}