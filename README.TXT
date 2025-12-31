# Elemental Slimes 🧪
### Game Development Project - PBO Sistem Informasi Universitas Andalas

Elemental Slimes adalah game refleks warna berbasis kecepatan dan ketepatan yang dikembangkan menggunakan **Java** dan framework **Greenfoot**. Proyek ini dibuat untuk memenuhi penilaian akhir mata kuliah **Pemrograman Berorientasi Objek (PBO)** di Program Studi Sistem Informasi Universitas Andalas.

---

## 👥 Identitas Kelompok (Kelompok 6)
* **Fuadi Dhiyaulhaq** (2411522001) - Pemrograman & Logika
* **Lyvia Putri Lestari** (2411521006) - Visual, Dokumentasi & Audio
* **Hana Rahmadini** (2411523010) - Visual, Aset & Dokumentasi

---

## ✨ Tentang Game
Terinspirasi dari *Color Switch* dan *Slime Rancher*, game ini menantang pemain mengendalikan slime yang dapat berubah warna (merah, biru, atau hijau) untuk menangkap orb yang sesuai di dunia hutan ajaib.

### 🎮 Aturan Main:
* **Pergerakan**: Pemain menggerakkan slime ke kiri atau kanan menggunakan tombol arah.
* **Matching Color**: Skor **+10** jika menangkap orb dengan warna yang sama, dan skor berkurang **-10** jika berbeda.
* **Skull Orb**: Mengurangi satu nyawa pemain.
* **Star Orb**: Menambah satu nyawa hingga batas maksimal tiga.
* **Rainbow Orb**: Memberi efek bebas warna selama 10 detik dan setiap orb yang ditangkap menambah +10 poin.
* **Game Over**: Permainan berakhir jika nyawa habis, menampilkan skor akhir dengan opsi replay atau keluar.

---

## 🛠️ Stack Teknologi & Pengembangan
* **Bahasa**: Java
* **Framework**: Greenfoot
* **Konsep PBO**: Mengimplementasikan konsep OOP seperti *Inheritance, Polymorphism, Modular Classes,* dan *Interface*.
* **Sumber Aset**: Sebagian besar aset grafis diperoleh dari **Craftpix.net** dan disesuaikan ulang oleh tim pengembang.

---

## 📦 Cara Instalasi dan Menjalankan
1. Pastikan **Greenfoot** sudah terinstal di komputer Anda.
2. Clone repositori ini:
   `git clone https://github.com/accfd/ElementalSlimes.git`
3. Membuka Proyek:
   * Buka aplikasi Greenfoot.
   * Pilih menu **Open Project**.
   * Navigasikan ke folder hasil clone dan pilih file `project.greenfoot`.
4. Menjalankan Game:
   * Klik tombol **Compile** pada pojok kanan bawah antarmuka Greenfoot.
   * Klik tombol **Run** untuk memulai permainan.

---

## 📂 Struktur Repositori (Core Logic)
* **World**: `OpeningWorld`, `ChooseSlimeWorld`, `MyWorld` (Arena Utama), `GameOverWorld`.
* **Actors**: `Slime` (Karakter Utama), `Element` (Parent Class), `BlueOrb`, `GreenOrb`, `RedOrb`, `YellowOrb`.
* **UI Components**: `Button`, `StartButton`, `BackButton`, `HowToPlay`.
* **Aset**: Folder `images/` (Sprites), `sounds/` (Audio), dan `selectable/`.

---

## 📜 Kredit dan Kontribusi
* **Pemrograman dan Logika Permainan**: Fuadi Dhiyaulhaq
* **Visual, Aset, dan Dokumentasi**: Lyvia Putri Lestari, Hana Rahmadini
* **Sound dan Efek Audio**: Lyvia Putri Lestari
* **Desain Game**: Tim Kelompok 6

---
**© 2025 Kelompok 6 - PBO SI UNAND**
*Dibuat dengan kolaborasi dan semangat belajar oleh Fuadi, Lyvia, dan Hana.*
