package com.juaracoding;

import java.sql.SQLOutput;
import java.util.Scanner;

public class SistemECommerce {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String[] produk = {"Laptop", "Smartphone", "Tablet", "Aksesori", "Smartwatch"};
        int[] stok = {10,10,10,10,10};
        double[] harga = {10000000,5000000,7000000,500000,3000000};
        double total = 0;


        System.out.println("===================");
        System.out.println("Welcome to Sistem ECommerce");

        System.out.print("Masukkan jumlah jenis produk yang ingin dibeli: ");
        int jenisProduk = input.nextInt();

        for(int i = 0; i < produk.length; i++){
            System.out.println("Product "+ i + " : " + produk[i]);
        }

        for(int i = 0; i < jenisProduk; i++){
            System.out.println("Item ke-"+(i+1));
            System.out.print("Pilih kategori [0-4] :" );
            int pilih = input.nextInt();

            if(pilih > produk.length){
                System.out.println("Pilihan tidak valid");
                break;
            }

            System.out.print("Masukan Jumlah : ");
            int jumlah = input.nextInt();

            if (jumlah <= 0) {
                System.out.println("Jumlah tidak boleh negatif atau nol!");
                break;
            }else if (jumlah > stok[pilih]) {
                System.out.println("Stok tidak cukup! Stok "+ produk[pilih] + " hanya tersisa " + stok[pilih]);
                break;
            }

        }




    }
}
