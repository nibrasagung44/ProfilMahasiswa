package com.example.profilmahasiswa.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Mahasiswa(
    val nim: String,
    val nama: String,
    val jurusan: String,
    val email: String,
    val telepon: String,
    val alamat: String
) : Parcelable
