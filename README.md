# Janji
Saya Nuansa Bening Aura Jelita dengan NIM 2301410 mengerjakan Tugas Praktikum 6 dalam mata kuliah Desain dan Pemrograman Berorientasi Objek 
untuk keberkahanNya maka saya tidak melakukan kecurangan seperti yang telah dispesifikasikan. Aamiin.

# Desain Program
Program ini adalah merupakan implementasi dari game klasik "Flappy Bird" menggunakan Java Swing untuk antarmuka grafis (GUI). 
Game ini memungkinkan pemain untuk mengendalikan seekor burung yang harus melewati rintangan berupa pipa. Program ini terdiri dari 5 kelas utama:

**1. App**
* **Fungsi:**
  * Entry point aplikasi
  * Menginisialisasi dan menampilkan menu start game

**2. StartForm (Menu Awal)**
* **Mewarisi kelas `JFrame`**
* **Komponen UI:**
  * Panel utama dengan background image
  * Label judul dan subtitle
  * Tombol start game
* **Metode:**
  * Constructor untuk inisialisasi form
  * `launchGame()` untuk memulai permainan

**3. FlappyBird**
* **Mewarisi kelas `JPanel` dan mengimplementasikan `ActionListener` dan `KeyListener`**
* **Atribut:**
  * Ukuran frame (lebar dan tinggi)
  * Gambar untuk background, burung, dan pipa
  * Properti pemain dan pipa
  * Timer untuk game loop dan cooldown pipa
  * Score dan status game
* **Metode:**
  * Constructor untuk inisialisasi game
  * `paintComponent` dan `draw` untuk bagian grafis
  * `move` untuk menangani pergerakan objek
  * `placePipes` untuk membuat pipa baru
  * `restartGame` untuk reset game

**4. Player**
* **Atribut:**
  * Posisi (posX, posY)
  * Dimensi (width, height)
  * Gambar burung
  * Kecepatan vertikal (velocityY)
* **Metode:**
  * Constructor untuk inisialisasi objek
  * Getter & Setter untuk setiap atribut

**5. Pipe (Model Rintangan)**
* **Atribut:**
  * Posisi (posX, posY)
  * Dimensi (width, height)
  * Gambar pipa
  * Kecepatan horizontal (velocityX)
  * Status (passed)
* **Metode:**
  * Constructor untuk inisialisasi objek
  * Getter & Setter untuk setiap atribut

## Implementasi Grafis
* Gambar latar (background.png)
* Sprite karakter pemain (bird.png)
* Pipa atas dan bawah (upperPipe.png, lowerPipe.png)

# Alur Program
**1. Memulai Aplikasi**
* Program menampilkan menu start dengan judul dan tombol start

**2. Memulai Game**
* Saat tombol start ditekan, menu start ditutup dan game dimulai
* Game diinisialisasi dengan pemain di posisi tengah
* Score dimulai dari 0

**3. Mekanisme Game**
* Pemain bisa seperti "melompat" ke atas dengan menekan tombol spasi
* Pipa bergerak dari kanan ke kiri dengan interval tertentu
* Pemain harus menghindari tabrakan dengan pipa
* Skor bertambah setiap kali pemain berhasil melewati satu set pipa

**4. Game Over**
* Game berakhir jika pemain menabrak pipa atau keluar dari batas layar (jatuh)
* Tampilan "Game Over" dan petunjuk untuk restart muncul
* Pemain dapat me-restart game dengan menekan tombol 'R'

# Dokuemntasi 
![Deskripsi Gambar](Screenshots/SCREEN-RECORD.gif)
