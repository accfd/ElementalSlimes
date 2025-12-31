# Elemental Slimes 🧪
### Game Development Project - PBO Sistem Informasi Universitas Andalas

Elemental Slimes adalah game refleks warna berbasis kecepatan dan ketepatan yang dikembangkan menggunakan **Java** dan framework **Greenfoot**. Proyek ini dibuat untuk memenuhi penilaian akhir mata kuliah Pemrograman Berorientasi Objek (PBO).

---

## 👥 Identitas Kelompok (Kelompok 6)
* **Fuadi Dhiyaulhaq** (2411522001) - Pemrograman & Logika
* **Lyvia Putri Lestari** (2411521006) - Visual, Dokumentasi & Audio
* **Hana Rahmadini** (2411523010) - Visual, Aset & Dokumentasi

---

## ✨ Tentang Game
Terinspirasi dari *Color Switch* dan *Slime Rancher*, game ini menantang pemain mengendalikan slime yang bisa berubah warna (Merah, Biru, Hijau) untuk menangkap orb yang sesuai di dunia hutan ajaib.

### 🎮 Aturan Main:
* **Tombol Arah**: Menggerakkan slime ke kiri/kanan.
* **Matching Color**: Skor **+10** jika warna orb sama, **-10** jika berbeda.
* **Skull Orb**: Mengurangi 1 nyawa.
* **Star Orb**: Menambah 1 nyawa (Maksimal 3).
* **Rainbow Orb**: Efek bebas warna selama 10 detik (Bonus poin).

---

## 🛠️ Stack Teknologi & Pengembangan
* **Bahasa**: Java
* **Framework**: Greenfoot
* **Konsep PBO**: Mengimplementasikan *Inheritance, Polymorphism, Modular Classes,* dan *Interface*.
* **Sumber Aset**: Craftpix.net (Karakter, Orb, Ikon) & Custom design oleh tim.

---

## 📦 Cara Menjalankan
1. Pastikan **Greenfoot** sudah terinstal di komputer Anda.
2. Clone repositori ini:
   ```bash
   git clone [https://github.com/accfd/ElementalSlimes.git](https://github.com/accfd/ElementalSlimes.git)
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

## 📄 Tujuan Pembuatan
Proyek ini dibuat sebagai bagian dari penilaian akhir mata kuliah **Pemrograman Berorientasi Objek (PBO)** di Program Studi Sistem Informasi Universitas Andalas. Tujuan utamanya adalah mengimplementasikan konsep-konsep OOP seperti *class*, *inheritance*, *polymorphism*, dan *interface* ke dalam media interaktif.

---

## 📜 Lisensi & Kredit
* **Pemrograman & Logika**: Fuadi Dhiyaulhaq.
* **Visual & Audio**: Lyvia Putri Lestari & Hana Rahmadini.
* **Sumber Aset**: [Craftpix.net](https://craftpix.net/) (untuk aset non-komersial pendidikan).

---
**© 2025 Kelompok 6 - PBO SI UNAND**
*Dibuat dengan kolaborasi dan semangat belajar oleh Fuadi, Lyvia, dan Hana.*
