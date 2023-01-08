package org.example;

import java.util.*;

public class random {
    public static void main(String[] args) {

        List<Integer> number = new ArrayList<>(26);
        String[] name = {"erkam", "Erdoğan", "Etka", "Mahmut", "MehmetObi", "Sinan", "Behlül", "Erdem"};

        while (true) {
            int x = (int) ((Math.random() * 26) + 1);

            if (!number.contains(x)) {
                number.add(x);
            }


            if (number.size() == 26) {
                break;
            }
        }

        for (int i = 0; i < name.length; i++) {
            System.out.printf("%-15s", name[i]);

        }
        System.out.println();

        for (int i = 0; i < number.size() - 3; i += 3) {

            System.out.printf("%-14s ", (number.get(i) + "-" + number.get(i + 1) + "-" + number.get(i + 2)));

        }


    }


}

