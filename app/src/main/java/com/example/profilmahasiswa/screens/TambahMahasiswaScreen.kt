package com.example.profilmahasiswa.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Save
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.profilmahasiswa.model.Mahasiswa
import com.example.profilmahasiswa.ui.theme.ProfilMahasiswaTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TambahMahasiswaScreen(
    onNavigateBack: () -> Unit,
    onSaveMahasiswa: (Mahasiswa) -> Unit
) {
    var nim by rememberSaveable { mutableStateOf("") }
    var nama by rememberSaveable { mutableStateOf("") }
    var jurusan by rememberSaveable { mutableStateOf("") }
    var email by rememberSaveable { mutableStateOf("") }
    var telepon by rememberSaveable { mutableStateOf("") }
    var alamat by rememberSaveable { mutableStateOf("") }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Tambah Mahasiswa", fontWeight = FontWeight.Bold) },
                navigationIcon = {
                    IconButton(onClick = onNavigateBack) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Kembali")
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer
                )
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .verticalScroll(rememberScrollState())
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            OutlinedTextField(
                value = nim,
                onValueChange = { nim = it },
                label = { Text("NIM") },
                modifier = Modifier.fillMaxWidth()
            )
            OutlinedTextField(
                value = nama,
                onValueChange = { nama = it },
                label = { Text("Nama") },
                modifier = Modifier.fillMaxWidth()
            )
            OutlinedTextField(
                value = jurusan,
                onValueChange = { jurusan = it },
                label = { Text("Jurusan") },
                modifier = Modifier.fillMaxWidth()
            )
            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                label = { Text("Email") },
                modifier = Modifier.fillMaxWidth()
            )
            OutlinedTextField(
                value = telepon,
                onValueChange = { telepon = it },
                label = { Text("Telepon") },
                modifier = Modifier.fillMaxWidth()
            )
            OutlinedTextField(
                value = alamat,
                onValueChange = { alamat = it },
                label = { Text("Alamat") },
                modifier = Modifier.fillMaxWidth()
            )

            Button(
                onClick = {
                    if (nim.isNotBlank() && nama.isNotBlank()) {
                        onSaveMahasiswa(
                            Mahasiswa(nim, nama, jurusan, email, telepon, alamat)
                        )
                    }
                },
                modifier = Modifier.fillMaxWidth(),
                contentPadding = PaddingValues(16.dp)
            ) {
                Icon(Icons.Default.Save, contentDescription = null)
                Spacer(modifier = Modifier.width(8.dp))
                Text("Simpan Mahasiswa")
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun TambahMahasiswaScreenPreview() {
    ProfilMahasiswaTheme {
        TambahMahasiswaScreen(
            onNavigateBack = {},
            onSaveMahasiswa = {}
        )
    }
}
