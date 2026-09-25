# Tugas 2 Pengembangan Aplikasi Mobile (PAM)
**Nama        :** Aditya Kristian Novalino
**NIM         :** 124140079
**Mata Kuliah :** Pengembangan Aplikasi Mobile - RA

Aplikasi **News Feed Simulator** dibuat memakai **Kotlin Multiplatform** dengan **Compose Multiplatform** untuk UI, target platform Android.

## Fitur

1. **Flow simulasi berita real-time** — berita baru dihasilkan secara otomatis setiap 2 detik menggunakan Kotlin `Flow`.
2. **Filter berdasarkan kategori** — pengguna dapat memfilter tampilan berita berdasarkan kategori (Semua, Technology, Sports).
3. **Transform data** — data berita mentah ditransformasikan ke format tampilan menggunakan operator `map` pada Flow.
4. **StateFlow untuk jumlah berita dibaca** — jumlah berita yang telah dibaca pengguna disimpan dan diperbarui secara reaktif menggunakan `StateFlow`.
5. **Coroutines untuk detail berita async** — detail lengkap berita diambil secara asynchronous (disimulasikan dengan delay) menggunakan `suspend function` dan `Coroutines`, lengkap dengan indikator loading.

## Teknologi yang Digunakan

- StateFlow untuk reactive state management
- Kotlin Multiplatform
- Kotlin Coroutines & Flow
- Compose Multiplatform (Jetpack Compose untuk UI)

## Cara Menjalankan

### Prasyarat
- **Android Studio** (versi terbaru, disarankan Ladybug atau lebih baru)
- Plugin **Kotlin Multiplatform** sudah terinstall di Android Studio (Settings → Plugins → cari "Kotlin Multiplatform")
- Android SDK sudah terkonfigurasi

### Langkah-langkah

1. **Clone repository ini**
   ```bash
   git clone <link-repository-ini>
   cd TUGAS2PAM124140079
   ```

2. **Buka project di Android Studio**
- Pilih **Open**, arahkan ke folder hasil clone
- Tunggu proses **Gradle Sync** selesai (bisa memakan waktu beberapa menit di percobaan pertama)

3. **Jalankan aplikasi (target Android)**
- Pilih run configuration **androidApp** di dropdown atas
- Pilih emulator atau device Android yang aktif
- Klik tombol **Run ▶️**

4. **Jalankan aplikasi (target iOS, khusus macOS)**
- Pastikan Xcode sudah terinstall
- Pilih run configuration **iosApp**
- Pilih simulator iOS
- Klik tombol **Run ▶️**

## Screenshot

Beberapa tampilan aplikasi:

![Screenshot_20260925_232042.png](Screenshot/Screenshot_20260925_232042.png)
![Screenshot_20260925_232206.png](Screenshot/Screenshot_20260925_232206.png)
![Screenshot_20260925_232214.png](Screenshot/Screenshot_20260925_232214.png)
![Screenshot_20260925_232222.png](Screenshot/Screenshot_20260925_232222.png)
![Screenshot_20260925_232233.png](Screenshot/Screenshot_20260925_232233.png)
![Screenshot_20260925_232240.png](Screenshot/Screenshot_20260925_232240.png)