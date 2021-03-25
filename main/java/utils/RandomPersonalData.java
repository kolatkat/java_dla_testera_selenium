package utils;

import java.util.Random;

public class RandomPersonalData {

    public static String EmailAddress() {
        Random random= new Random();
        String[] imiona = {"Kasia","Basia","Zosia"};
            int m = random.nextInt(imiona.length - 1);
            int n = random.nextInt(10);
            int k = random.nextInt(10);
            int l = random.nextInt(10);
        String email = imiona[m] + m + n + k + l + "@test.pl";
        return email;
    }
}
