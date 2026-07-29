package com.example.profilmahasiswa.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.profilmahasiswa.R
import com.example.profilmahasiswa.ui.theme.ProfilMahasiswaTheme

data class Subject(
    val code: String,
    val name: String,
    val score: Int,
    val grade: String
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DataNilaiScreen(onNavigateBack: () -> Unit = {}) {

    val subjects = listOf(
        Subject("TIF401", "Pemrograman Mobile", 85, "A"),
        Subject("TIF402", "Basis Data Lanjut", 78, "B+"),
        Subject("TIF403", "Jaringan Komputer", 92, "A"),
        Subject("TIF404", "Kecerdasan Buatan", 88, "A"),
        Subject("TIF405", "Sistem Operasi", 74, "B"),
        Subject("TIF406", "Statistika", 81, "A-")
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Data Nilai") },
                navigationIcon = {
                    IconButton(onClick = onNavigateBack) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .padding(16.dp)
                .fillMaxSize()
        ) {
            Card(modifier = Modifier.fillMaxWidth()) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(12.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Text("NIM", fontSize = 12.sp)
                        Text("220411100001", fontWeight = FontWeight.Bold)
                    }
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Text("Nama", fontSize = 12.sp)
                        Text("Ahmad Fauzi", fontWeight = FontWeight.Bold)
                    }
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Text("Semester", fontSize = 12.sp)
                        Text("6", fontWeight = FontWeight.Bold)
                    }
                }

            }

            Spacer(modifier = Modifier.height(8.dp))

            Card(modifier = Modifier.fillMaxWidth()) {
                Row (
                  modifier = Modifier
                      .fillMaxWidth()
                      .padding(8.dp)
                ) {
                    // Kode | Mata Kuliah | Nilai | Huruf
                    Text("Kode", modifier = Modifier.weight(1.5f), fontWeight = FontWeight.Bold)
                    Text("Mata Kuliah", modifier = Modifier.weight(3f), fontWeight = FontWeight.Bold)
                    Text("Nilai", modifier = Modifier.weight(1.5f), fontWeight = FontWeight.Bold)
                    Text("Huruf", modifier = Modifier.weight(1.5f), fontWeight = FontWeight.Bold)
                }
            }

            Card(modifier = Modifier.fillMaxWidth()) {
                Column {
                    subjects.forEach { subject ->
                        Row (
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(10.dp),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(subject.code, modifier = Modifier.weight(1.5f))
                            Text(subject.name, modifier = Modifier.weight(3f))
                            Text(subject.score.toString(), modifier = Modifier.weight(1.5f))
                            Text(subject.grade, modifier = Modifier.weight(1.5f))
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            Card(modifier = Modifier.fillMaxWidth()) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(12.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text("IP Sementara", fontWeight = FontWeight.Bold)
                    Text("3.75", fontWeight = FontWeight.Bold)
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DataNilaiScreenPreview() {
    ProfilMahasiswaTheme {
        DataNilaiScreen()
    }
}
