package com.xjtuse.drug_management.utils;

import java.text.DecimalFormat;
import java.util.Random;

public class RandomUtil {
    private static final Random random = new Random();
    private static final DecimalFormat four = new DecimalFormat("0000");
    private static final DecimalFormat six = new DecimalFormat("000000");

    public static String getFourRandom() {
        return four.format(random.nextInt(10000));
    }

    public static String getSixRandom() {
        return six.format(random.nextInt(1000000));
    }

    public static String getVerificationCode() {
        char[] chars = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n',
                'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
                'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N',
                'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            stringBuilder.append(chars[random.nextInt(chars.length)]);
        }
        return stringBuilder.toString();
    }
}
