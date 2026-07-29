# Aplikasi Profil Mahasiswa

Aplikasi Android berbasis Jetpack Compose untuk mengelola profil mahasiswa, melakukan pengeditan data kontak, dan melihat data nilai akademik.

## Fitur Utama

- **Navigasi Antar Layar**: Perpindahan mulus antara Layar Profil, Layar Edit Profil, dan Layar Data Nilai menggunakan state management di `MainActivity`.
- **Layar Profil**: Menampilkan informasi utama mahasiswa, foto profil dengan badge status, kartu informasi kontak, dan statistik akademik (IPK, SKS, Semester).
- **Layar Edit Profil**: Memungkinkan pengguna untuk mengubah data kontak (Email, Telepon, Alamat) dengan mode edit yang dapat diaktifkan/dinonaktifkan.
- **Layar Data Nilai**: Menampilkan daftar mata kuliah beserta nilai dan grade dalam format kartu dan tabel yang rapi.

## Perubahan yang Telah Dilakukan

### 1. Arsitektur & Navigasi
- Mengimplementasikan logika navigasi manual menggunakan `mutableStateOf` di `MainActivity` untuk berpindah antar screen tanpa library eksternal, sesuai dengan kebutuhan tugas.
- Menambahkan parameter callback (`onNavigateToEdit`, `onNavigateBack`, dll.) pada setiap screen untuk mendukung komunikasi antar komponen.

### 2. Antarmuka Pengguna (UI) & Material 3
- **Scaffold & TopAppBar**: Menggunakan struktur layout standar Material 3 dengan bilah aplikasi atas yang memiliki ikon navigasi (back) dan aksi (edit).
- **Komponen Kustom**: Membuat komponen reusable seperti `ContactRow` untuk informasi kontak, `StatItem` untuk angka statistik, dan `EditRow` untuk field input.
- **Styling Lanjut**: 
    - Penggunaan `Card` dengan elevasi dan sudut membulat (`RoundedCornerShape`).
    - Implementasi `Box` untuk layering elemen (contoh: badge status di atas foto profil).
    - Penggunaan `Brush.linearGradient` untuk background foto profil.
- **Responsivitas**: Menggunakan `Modifier.weight()` untuk pembagian kolom statistik yang sama rata dan `fillMaxWidth()` agar UI adaptif terhadap lebar layar.

### 3. State Management
- Menggunakan `remember` dan `mutableStateOf` untuk mengelola data input di form edit.
- Menangani status interaksi seperti `editCount` (penghitung klik) dan `isEditing` (toggle mode baca/tulis).

### 4. Media & Resource
- Mengganti penggunaan ikon placeholder dengan komponen `Image` dan `painterResource` untuk menampilkan foto profil dari drawable project.
- Integrasi warna kustom dari `colors.xml` (seperti `colorPrimary` dan `colorOrange`).

## Tampilan Aplikasi

![Preview Screenshot](preview.png)

## Teknologi yang Digunakan
- **Kotlin**
- **Jetpack Compose**
- **Material Design 3**
- **Android Studio Ladybug**
