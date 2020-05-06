package com.company;

import java.sql.SQLOutput;

import static java.lang.Math.floorMod;

public class Main {

    public static void main(String[] args) {
	// write your code here
        double r = Math.random();

        /* provera
        * da li je treci broj posle decimalnog zareza
        * veci ili jednak od 5
        * i dodeliti broj 1 ako je iskaz tacan */

        /*
        int oneToThousand = (int) (r*1000);
        int lastNumber = floorMod(oneToThousand, 10);

        int oneToHundred = (int) (r*100);

        if (lastNumber >= 5) {
            oneToHundred = oneToHundred + 1;
        }
        */

        int oneToHundred = (int) (r*100) + 1;

        System.out.println("oneToHundred " + oneToHundred);

        // 5th task
        /*
        boolean isEven = (floorMod(oneToHundred, 2) == 0);

        if (isEven) {
            System.out.println(oneToHundred + " je paran broj.");
        } else {
            System.out.println(oneToHundred + " je neparan broj.");
        }
         */

        // 6th task
        /*
        for(int i=1; i <= 100; i++) {

            System.out.println(i);
            if (i == oneToHundred) {
                break;
            }
        }
         */

        int number = 4;
        // for checking the right solution:
        //int number = 0;
        //int number = 1;
        //int number = 2;
        //int number = 3;
        // int number = 5;
        int prod = 1;

        for (int j = number; j > 0; j--) {

            prod = prod*j;
        }

        System.out.println("factorial " + prod);

        int [] array = {1, 2, 3, 4, 5};

        int [] nizOneToHundred = new int[oneToHundred];

        int sum = 0;

        for(int k=0; k < (oneToHundred); k++){
            nizOneToHundred[k] = k+1;
            System.out.println(nizOneToHundred[k]);
            sum = sum + nizOneToHundred[k];
        }

        System.out.println("suma " + sum);

    }
}
