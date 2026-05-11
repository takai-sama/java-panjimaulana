Soal Essay: Simulasi ATM Multi-User (Array & Logic)
Skenario
Anda diminta membuat program Java Console yang mensimulasikan mesin ATM untuk 3
orang nasabah. Data nasabah disimpan dalam array (bukan objek).
Data Awal (Hardcoded):
● Array No. Rekening: {101, 102, 103}
● Array PIN: {1111, 2222, 3333}
● Array Saldo: {500000, 1000000, 200000}
● Array Status Blokir: {false, false, false} (gunakan array boolean atau integer 0/1)
Instruksi Tugas:
Buatlah alur program di dalam main method yang menangani kondisi berikut:
1. Sistem Login & Looping Utama:
   ○ Program harus terus berjalan (looping) sampai pengguna memilih menu
   "Exit".
   ○ Gunakan looping untuk mencari index nasabah berdasarkan nomor rekening
   yang dimasukkan.
   ○ Jika PIN salah 3 kali pada nomor rekening yang sama, ubah status nasabah
   tersebut menjadi terblokir di dalam array.
2. Logika Penarikan (If & Modulo):
   ○ Input jumlah penarikan harus kelipatan Rp50.000. Jika tidak, tampilkan pesan
   error.
   ○ Saldo minimal yang harus tersisa di akun setelah penarikan adalah
   Rp50.000.
   ○ Jika saldo kurang, transaksi dibatalkan.
3. Fitur Transfer (Antar Array):
   ○ Pengguna memasukkan nomor rekening tujuan.
   ○ Program harus mencari (looping) apakah rekening tujuan ada di dalam array
   atau tidak.
   ○ Jika ada, kurangi saldo pengirim dan tambah saldo penerima pada index
   yang tepat.
   Potongan Kode yang Menjadi Bagian "Tricky" (Logic Challenge):
   Bagian yang paling sering membuat mahasiswa terjebak adalah sinkronisasi antar index
   array. Berikut adalah cuplikan logika yang harus mereka selesaikan:
   Java
   // Contoh potongan logika pencarian nasabah (Linear Search)
   int userIndex = -1;
   System.out.print("Masukkan No Rekening: ");
   int inputRek = sc.nextInt();
   for (int i = 0; i < norek.length; i++) {
   if (inputRek == norek[i]) {
   userIndex = i; // Menemukan index nasabah
   break;
   }
   }
   if (userIndex == -1) {
   System.out.println("Rekening tidak ditemukan!");
   } else if (isBlocked[userIndex]) {
   System.out.println("Akun Anda terblokir!");
   } else {
   // Lanjut ke input PIN dengan counter maksimal 3x
   // ...
   }
   Pertanyaan Essay:
1. Analisis Error: Bagaimana cara Anda memastikan bahwa saat fitur Transfer
   dilakukan, saldo tidak hanya berkurang di pengirim tapi benar-benar bertambah di
   index rekening tujuan yang benar? Tunjukkan potongan logikanya.
2. Validasi Pecahan: Tuliskan kondisi if untuk memastikan bahwa uang yang ditarik
   hanya kelipatan 50.000 dan minimal penarikan adalah 50.000.
3. Manajemen Array: Jika ada nasabah baru yang ingin mendaftar (registrasi), kendala
   apa yang akan dihadapi oleh struktur Array yang Anda buat di atas, dan bagaimana
   cara mengatasinya tanpa menggunakan ArrayList?
   Indikator Penilaian:
   ● Kemampuan Indexing: Ketepatan menggunakan i sebagai pointer untuk
   menghubungkan data di 4 array yang berbeda.
   ● Logika Boolean: Penggunaan variabel flag atau status untuk menentukan apakah
   user berhasil login atau tidak.
   ● Looping Bersarang (Nested Loop): Penggunaan loop di dalam menu (misal: menu
   utama di dalam loop while, dan proses input PIN di dalam loop for atau do-while).
   ● Validasi Input: Penggunaan if untuk mencegah penarikan saldo di bawah limit atau
   nominal yang tidak valid.