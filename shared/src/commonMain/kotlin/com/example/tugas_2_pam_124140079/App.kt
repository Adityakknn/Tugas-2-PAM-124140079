package com.example.tugas_2_pam_124140079

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.tugas_2_pam_124140079.viewmodel.NewsViewModel

@Composable
fun App() {

    // Gunakan nama class yang sama dengan import
    val viewModel = remember { NewsViewModel() }

    val newsList by viewModel.newsList.collectAsState()
    val readCount by viewModel.readCount.collectAsState()
    val selectedCategory by viewModel.selectedCategory.collectAsState()
    val selectedNews by viewModel.selectedNews.collectAsState()

    MaterialTheme {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFF7F3E8))
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            // HEADER

            Text(
                text = "Berita Terkini",
                style = MaterialTheme.typography.headlineMedium,
                color = Color(0xFF1E3932),
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = "Berita terbaca: $readCount",
                color = Color(0xFF6B4F3A),
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(20.dp))

            // CATEGORY

            Text(
                text = "Kategori",
                style = MaterialTheme.typography.titleMedium,
                color = Color(0xFF1E3932),
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(8.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {

                listOf(
                    "Semua",
                    "Politik",
                    "Pendidikan"
                ).forEach { category ->

                    Button(
                        onClick = {
                            viewModel.changeCategory(category)
                        },
                        modifier = Modifier.padding(horizontal = 4.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor =
                                if (selectedCategory == category) {
                                    Color(0xFF00754A)
                                } else {
                                    Color(0xFFE8E2D2)
                                }
                        )
                    ) {

                        Text(
                            text = category,
                            color =
                                if (selectedCategory == category) {
                                    Color.White
                                } else {
                                    Color(0xFF1E3932)
                                },
                            textAlign = TextAlign.Center
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // NEWS LIST

            LazyColumn(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                items(newsList) { news ->

                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 6.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = Color.White
                        )
                    ) {

                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(16.dp),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {

                            // CATEGORY

                            Text(
                                text = news.category,
                                style = MaterialTheme.typography.labelMedium,
                                color = Color(0xFF00754A),
                                textAlign = TextAlign.Center
                            )

                            Spacer(
                                modifier = Modifier.height(6.dp)
                            )

                            // JUDUL

                            Text(
                                text = news.title,
                                style = MaterialTheme.typography.titleMedium,
                                color = Color(0xFF1E3932),
                                textAlign = TextAlign.Center
                            )

                            Spacer(
                                modifier = Modifier.height(12.dp)
                            )

                            // BUTTON

                            Button(
                                onClick = {
                                    viewModel.readNews(news)
                                    viewModel.selectNews(news)
                                },
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = Color(0xFF1E3932)
                                )
                            ) {

                                Text(
                                    text = "Baca Detail",
                                    color = Color.White,
                                    textAlign = TextAlign.Center
                                )
                            }
                        }
                    }
                }
            }

            // DETAIL NEWS

            selectedNews?.let { news ->

                AlertDialog(

                    onDismissRequest = {
                        viewModel.clearSelectedNews()
                    },

                    confirmButton = {

                        Button(
                            onClick = {
                                viewModel.clearSelectedNews()
                            },
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color(0xFF00754A)
                            )
                        ) {

                            Text(
                                text = "Tutup",
                                color = Color.White,
                                textAlign = TextAlign.Center
                            )
                        }
                    },

                    title = {

                        Text(
                            text = news.title,
                            color = Color(0xFF1E3932),
                            textAlign = TextAlign.Center,
                            modifier = Modifier.fillMaxWidth()
                        )
                    },

                    text = {

                        Column(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {

                            Text(
                                text = news.category,
                                color = Color(0xFF00754A),
                                textAlign = TextAlign.Center
                            )

                            Spacer(
                                modifier = Modifier.height(8.dp)
                            )

                            Text(
                                text = news.content,
                                color = Color(0xFF37413C),
                                textAlign = TextAlign.Center
                            )
                        }
                    },

                    containerColor = Color(0xFFF7F3E8)
                )
            }
        }
    }
}

