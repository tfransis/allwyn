package net.azurewebsites.fakerestapi.utils;

import lombok.experimental.UtilityClass;

@UtilityClass
public class Utilities {
    public int getRandomNumber(int min, int max) {
        return (int) (Math.random() * (max - min + 1)) + min;
    }
}
