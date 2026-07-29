package com.example.profilmahasiswa.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.School
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.profilmahasiswa.model.Mahasiswa
import com.example.profilmahasiswa.ui.theme.ProfilMahasiswaTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    mahasiswaList: List<Mahasiswa>,
    onMahasiswaClick: (Mahasiswa) -> Unit,
    onAddMahasiswaClick: () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Daftar Mahasiswa", fontWeight = FontWeight.Bold) },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer
                )
            )
        },
        floatingActionButton = {
            FloatingActionButton(onClick = onAddMahasiswaClick) {
                Icon(Icons.Default.Add, contentDescription = "Tambah Mahasiswa")
            }
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(mahasiswaList) { mahasiswa ->
                MahasiswaCard(
                    mahasiswa = mahasiswa,
                    onClick = { onMahasiswaClick(mahasiswa) }
                )
            }
        }
    }
}

@Composable
fun MahasiswaCard(
    mahasiswa: Mahasiswa,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        onClick = onClick,
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Default.School,
                contentDescription = null,
                modifier = Modifier.size(40.dp),
                tint = MaterialTheme.colorScheme.primary
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column {
                Text(
                    text = mahasiswa.nama,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "NIM: ${mahasiswa.nim}",
                    fontSize = 14.sp,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun HomeScreenPreview() {
    val sampleMahasiswaList = listOf(
        Mahasiswa(
            "20210001",
            "Ahmad Fauzi Rahman",
            "Teknik Informatika",
            "ahmad.fauzi@student.ac.id",
            "+62 812-3456-7890",
            "Malang, Jawa Timur"
        ),
        Mahasiswa(
            "20210002",
            "Siti Aminah",
            "Sistem Informasi",
            "siti.aminah@student.ac.id",
            "+62 812-3456-7891",
            "Surabaya, Jawa Timur"
        )
    )
    ProfilMahasiswaTheme {
        HomeScreen(
            mahasiswaList = sampleMahasiswaList,
            onMahasiswaClick = {},
            onAddMahasiswaClick = {}
        )
    }
}
