package com.example.profilmahasiswa.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.profilmahasiswa.model.Mahasiswa
import com.example.profilmahasiswa.ui.theme.ProfilMahasiswaTheme

/**
 * DataNilaiScreen - Menampilkan daftar nilai akademik mahasiswa.
 * Layout dioptimalkan sesuai dengan referensi gambar (Blue Theme).
 */
data class Subject(
    val code: String,
    val name: String,
    val score: Int,
    val grade: String
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DataNilaiScreen(
    mahasiswa: Mahasiswa,
    onNavigateBack: () -> Unit = {}
) {
    val subjects = listOf(
        Subject("TIF401", "Pemrograman Mobile", 85, "A"),
        Subject("TIF402", "Basis Data Lanjut", 78, "B+"),
        Subject("TIF403", "Jaringan Komputer", 92, "A"),
        Subject("TIF404", "Kecerdasan Buatan", 88, "A"),
        Subject("TIF405", "Sistem Operasi", 74, "B"),
        Subject("TIF406", "Statistika", 81, "A-")
    )

    // Palette Warna Premium (Blue Theme)
    val primaryBlue = Color(0xFF4A5A8A)      // Biru Utama (TopBar & Header Tabel)
    val lightAccentBlue = Color(0xFFD4E1FF)  // Biru Muda (Kartu Identitas)
    val pageBackground = Color(0xFFF8F9FE)   // Background Halaman
    val textLabel = Color(0xFF8A9AB5)        // Warna Label Teks
    val textValue = Color(0xFF2D3D5B)        // Warna Nilai Teks

    Scaffold(
        topBar = {
            TopAppBar(
                title = { 
                    Text(
                        "Data Nilai", 
                        color = Color.White,
                        fontWeight = FontWeight.Bold
                    ) 
                },
                navigationIcon = {
                    IconButton(onClick = onNavigateBack) {
                        Icon(
                            Icons.AutoMirrored.Filled.ArrowBack, 
                            contentDescription = "Kembali",
                            tint = Color.White
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = primaryBlue
                )
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
                .background(pageBackground)
                .verticalScroll(rememberScrollState())
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // --- KARTU IDENTITAS MAHASISWA ---
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(24.dp),
                colors = CardDefaults.cardColors(containerColor = lightAccentBlue),
                elevation = CardDefaults.cardElevation(defaultElevation = 0.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 24.dp, horizontal = 16.dp),
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.Top
                ) {
                    InfoColumn("NIM", mahasiswa.nim, Modifier.weight(1f), textLabel, textValue)
                    InfoColumn("Nama", mahasiswa.nama, Modifier.weight(1.5f), textLabel, textValue)
                    InfoColumn("Semester", "6", Modifier.weight(1f), textLabel, textValue)
                }
            }

            // --- HEADER TABEL ---
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(12.dp),
                colors = CardDefaults.cardColors(containerColor = primaryBlue)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 14.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text("Kode", color = Color.White, fontWeight = FontWeight.Bold, modifier = Modifier.weight(1.2f), fontSize = 14.sp)
                    Text("Mata Kuliah", color = Color.White, fontWeight = FontWeight.Bold, modifier = Modifier.weight(3f), fontSize = 14.sp)
                    Text("Nilai", color = Color.White, fontWeight = FontWeight.Bold, modifier = Modifier.weight(1f), fontSize = 14.sp, textAlign = TextAlign.End)
                    Spacer(modifier = Modifier.width(32.dp))
                    Text("Huruf", color = Color.White, fontWeight = FontWeight.Bold, modifier = Modifier.weight(1.2f), fontSize = 14.sp, textAlign = TextAlign.Center)
                }
            }

            // --- DAFTAR NILAI (BARIS) ---
            Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                subjects.forEach { subject ->
                    SubjectItemRow(subject, Color.White)
                }
            }

            // --- FOOTER (IP SEMENTARA) ---
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(20.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White),
                elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(12.dp)
                        .padding(start = 8.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        "IP Sementara", 
                        fontSize = 20.sp, 
                        fontWeight = FontWeight.Bold,
                        color = textValue
                    )
                    Surface(
                        color = primaryBlue,
                        shape = RoundedCornerShape(12.dp)
                    ) {
                        Text(
                            "3.67",
                            color = Color.White,
                            fontWeight = FontWeight.Bold,
                            fontSize = 22.sp,
                            modifier = Modifier.padding(horizontal = 32.dp, vertical = 10.dp)
                        )
                    }
                }
            }
            
            Spacer(modifier = Modifier.height(24.dp))
        }
    }
}

@Composable
fun InfoColumn(label: String, value: String, modifier: Modifier = Modifier, labelColor: Color, valueColor: Color) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(label, fontSize = 13.sp, color = labelColor, fontWeight = FontWeight.Medium)
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            value, 
            fontWeight = FontWeight.Bold, 
            fontSize = 18.sp, 
            color = valueColor, 
            textAlign = TextAlign.Center,
            lineHeight = 22.sp
        )
    }
}

@Composable
fun SubjectItemRow(subject: Subject, bgColor: Color) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = bgColor),
        elevation = CardDefaults.cardElevation(defaultElevation = 1.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(subject.code, modifier = Modifier.weight(1.2f), fontSize = 14.sp, color = Color(0xFF8897AD))
            Text(subject.name, modifier = Modifier.weight(3f), fontSize = 15.sp, fontWeight = FontWeight.Bold, color = Color.Black)
            Text(subject.score.toString(), modifier = Modifier.weight(1f), fontSize = 15.sp, fontWeight = FontWeight.Bold, textAlign = TextAlign.End, color = Color.Black)
            
            Spacer(modifier = Modifier.width(32.dp))

            // Badge Nilai Huruf dengan warna sesuai grade
            Box(
                modifier = Modifier.weight(1.2f),
                contentAlignment = Alignment.Center
            ) {
                Surface(
                    color = when (subject.grade) {
                        "A", "A-" -> Color(0xFF4CAF50) // Green
                        "B+" -> Color(0xFF8BC34A)      // Light Green
                        "B" -> Color(0xFFFFC107)       // Amber
                        else -> Color.Gray
                    },
                    shape = RoundedCornerShape(8.dp),
                    modifier = Modifier.width(60.dp)
                ) {
                    Text(
                        subject.grade,
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        fontSize = 15.sp,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(vertical = 8.dp)
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DataNilaiScreenPreview() {
    val sampleMahasiswa = Mahasiswa(
        "20210001",
        "Ahmad Fauzi Rahman",
        "Teknik Informatika",
        "ahmad.fauzi@student.ac.id",
        "+62 812-3456-7890",
        "Malang, Jawa Timur"
    )
    ProfilMahasiswaTheme {
        DataNilaiScreen(mahasiswa = sampleMahasiswa)
    }
}
