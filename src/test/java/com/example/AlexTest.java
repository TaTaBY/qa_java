package com.example;

import org.junit.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.Assert.*;


public class AlexTest {

    Alex alex = new Alex();

    @Test
    public void validateGetFriendsAlex() {
        List <String> expected = List.of("Марти", "Глория", "Мелман");
        List <String> actual = alex.getFriends();
        assertEquals(expected, actual);
    }

    @Test
    public void validateGetPlaceOfLivingAlex() {
        String expected = "Нью-Йоркский зоопарк";
        String actual = alex.getPlaceOfLiving();
        assertEquals(expected, actual);
    }

    @Test
    public void validateGetKittensAlex() {
        int expected = 0;
        int actual = alex.getKittens();
        assertEquals(expected, actual);
    }

}