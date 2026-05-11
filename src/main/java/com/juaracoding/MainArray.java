package com.juaracoding;

import java.util.Arrays;
import java.util.Scanner;

public class MainArray {

    public static void main(String[] args) {

        // Cara 1
        int[] prices = { 20000, 15000, 30000, 100000, 50000 };

        System.out.println(prices[0]);

        // Cara 2
        int[] harga = new int[5];
        harga[0] = 20000;
        harga[1] = 15000;
        harga[2] = 30000;
        harga[3] = 100000;
        harga[4] = 50000;

        System.out.println(harga[3]);

        int[] sizeRam = { 4, 8, 16 };
        System.out.println(sizeRam[2]);

        for (int i = 0; i < sizeRam.length; i++) {
            System.out.println(sizeRam[i]);
        }

        // sum prices
        int sum = 0;
        for (int price : prices) {
            sum += price;
        }
        System.out.println("Total: " + sum);

        // array multidimensi
        int[][] numbers = { { 1, 2, 3, 4 }, { 5, 6, 7 }, { 8, 9, 10 } };
        System.out.println(numbers[1][1]); // 6
        System.out.println(numbers[0][2]); // 3
        System.out.println(numbers[2][1]); // 9

        for (int i = 0; i < numbers.length; i++) { // 3 < 3 -> false
            for (int j = 0; j < numbers[i].length; j++) {
                System.out.print(numbers[i][j] + " "); // numbers[2][2]
            }
            System.out.println();
        }

        // Sorting use Arrays.sort()
        Arrays.sort(prices);
        for (int price : prices) {
            System.out.println(price);
        }

        // Search use Arrays.binarySearch()
        int index = Arrays.binarySearch(prices, 30000);
        System.out.println(index);

        // linear search
        String[] cities = { "jakarta", "bandung", "surabaya", "yogyakarta", "medan", "semarang", "bandung" };
        for(int i=0; i < cities.length; i++){
            if(cities[i]=="medan"){
                System.out.println("medan index ke"+ i);
            }
        }


        Scanner scanner = new Scanner(System.in);
        String[] colors = new String[5];

        for (int i = 0; i < colors.length; i++) {
            System.out.println("Masukkan warna ke " + (i + 1));
            colors[i] = scanner.nextLine();
        }
        scanner.close();

        // foreach
        for (String color : colors) {
            System.out.println(color);
        }
    }

}
