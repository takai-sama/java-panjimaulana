package com.juaracoding;
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
        if (jenisProduk <= 0 ) {
            System.out.println("Jumlah jenis produk tidak valid");
            return; //biar berhenti
        }


        for(int i = 0; i < produk.length; i++){
            System.out.println("Product "+ i + " : " + produk[i]);
        }

        for(int i = 0; i < jenisProduk; i++){
            System.out.println("Item ke-"+(i+1));
            System.out.print("Pilih kategori [0-4] :" );
            int pilih = input.nextInt();

            if(pilih >= produk.length || pilih < 0){
                System.out.println("Pilihan tidak valid");
                continue;
            }

            System.out.print("Masukan Jumlah : ");
            int jumlah = input.nextInt();

            if (jumlah <= 0) {
                System.out.println("Jumlah tidak boleh negatif atau nol!");
            }else if (jumlah > stok[pilih]) {
                System.out.println("Stok tidak cukup! Stok "+ produk[pilih] + " hanya tersisa " + stok[pilih]);
            }else{
                double subtotal = jumlah * harga[pilih];
                total += subtotal;
                stok[pilih] -= jumlah;
                System.out.println("Berhasil ditambahkan!");
                System.out.printf("Subtotal: Rp %,.0f\n", subtotal);
            }
        }

        System.out.println("===Status Member=== ");
        System.out.println("Gold");
        System.out.println("Silver");
        System.out.println("Bronze");
        System.out.print("Input status member : ");
        input.nextLine();

        String member = input.nextLine().toLowerCase();

        double diskonMember ;

        switch (member) {
            case "gold":
                diskonMember = total*0.15;
                break;
            case "silver":
                diskonMember = total*0.10;
                break;
            case "bronze":
                diskonMember = total*0.05;
                break;
            default:
                diskonMember = 0;
                break;
        }

        // Setelah diskon member
        double setelahDiskonMember = total - diskonMember;

        // Nested IF diskon volume
        double potonganVolume = 0;

        if (setelahDiskonMember > 5000000) {

            if (setelahDiskonMember > 10000000) {
                potonganVolume = 500000;
            } else {
                potonganVolume = 200000;
            }

        }

        double totalAkhir = setelahDiskonMember - potonganVolume;
        System.out.println("===== STRUK PEMBELIAN =====");
        System.out.printf("Total Belanja Sebelum Diskon : Rp %,.0f\n" , total);
        System.out.printf("Diskon Member                : Rp %,.0f\n" , diskonMember);
        System.out.printf("Potongan Volume              : Rp %,.0f\n" , potonganVolume);
        System.out.printf("Total Akhir                  : Rp %,.0f\n" , totalAkhir);

        System.out.println("===== SISA STOK AKHIR =====");
        for (int i = 0; i < produk.length; i++) {
            System.out.println(produk[i] + " : " + stok[i]);
        }

        input.close();

    }
}
