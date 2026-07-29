package com.example.profilmahasiswa

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.profilmahasiswa.model.Mahasiswa
import com.example.profilmahasiswa.screens.*
import com.example.profilmahasiswa.ui.theme.ProfilMahasiswaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            ProfilMahasiswaTheme {
                val navController = rememberNavController()
                
                // Data State Management (Hoisted)
                var mahasiswaList by rememberSaveable {
                    mutableStateOf(
                        listOf(
                            Mahasiswa(
                                "20210001",
                                "Ahmad Fauzi Rahman",
                                "Teknik Informatika",
                                "ahmad.fauzi@student.ac.id",
                                "+62 812-3456-7890",
                                "Malang, Jawa Timur"
                            )
                        )
                    )
                }

                NavHost(navController = navController, startDestination = "home") {
                    composable("home") {
                        HomeScreen(
                            mahasiswaList = mahasiswaList,
                            onMahasiswaClick = { mahasiswa ->
                                navController.navigate("detail/${mahasiswa.nim}")
                            },
                            onAddMahasiswaClick = {
                                navController.navigate("tambah")
                            }
                        )
                    }

                    composable(
                        route = "detail/{nim}",
                        arguments = listOf(navArgument("nim") { type = NavType.StringType })
                    ) { backStackEntry ->
                        val nim = backStackEntry.arguments?.getString("nim")
                        val mahasiswa = mahasiswaList.find { it.nim == nim }
                        
                        if (mahasiswa != null) {
                            ProfileScreen(
                                mahasiswa = mahasiswa,
                                onNavigateBack = { navController.popBackStack() },
                                onNavigateToEdit = { editNim ->
                                    navController.navigate("edit/$editNim")
                                },
                                onNavigateToDataNilai = { detailNim ->
                                    navController.navigate("data_nilai/$detailNim")
                                }
                            )
                        }
                    }

                    composable(
                        route = "data_nilai/{nim}",
                        arguments = listOf(navArgument("nim") { type = NavType.StringType })
                    ) { backStackEntry ->
                        val nim = backStackEntry.arguments?.getString("nim")
                        val mahasiswa = mahasiswaList.find { it.nim == nim }

                        if (mahasiswa != null) {
                            DataNilaiScreen(
                                mahasiswa = mahasiswa,
                                onNavigateBack = { navController.popBackStack() }
                            )
                        }
                    }

                    composable(
                        route = "edit/{nim}",
                        arguments = listOf(navArgument("nim") { type = NavType.StringType })
                    ) { backStackEntry ->
                        val nim = backStackEntry.arguments?.getString("nim")
                        val mahasiswa = mahasiswaList.find { it.nim == nim }
                        
                        if (mahasiswa != null) {
                            ProfileEditScreen(
                                mahasiswa = mahasiswa,
                                onNavigateBack = { navController.popBackStack() },
                                onSaveMahasiswa = { updatedMahasiswa ->
                                    mahasiswaList = mahasiswaList.map {
                                        if (it.nim == updatedMahasiswa.nim) updatedMahasiswa else it
                                    }
                                    navController.popBackStack()
                                }
                            )
                        }
                    }

                    composable("tambah") {
                        TambahMahasiswaScreen(
                            onNavigateBack = { navController.popBackStack() },
                            onSaveMahasiswa = { newMahasiswa ->
                                mahasiswaList = mahasiswaList + newMahasiswa
                                navController.popBackStack()
                            }
                        )
                    }
                }
            }
        }
    }
}
