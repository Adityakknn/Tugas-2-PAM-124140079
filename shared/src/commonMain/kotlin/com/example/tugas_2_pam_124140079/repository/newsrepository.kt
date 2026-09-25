package com.example.tugas_2_pam_124140079.repository

// FIX IMPORT: Arahkan ke package model
import com.example.tugas_2_pam_124140079.model.News
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map

class NewsRepository {
    private val categories = listOf("Politik", "Pendidikan")

    fun getNewsStream(): Flow<News> = flow {
        var idCounter = 1

        while (true) {
            delay(2000)

            val category = categories.random()

            val news = News(
                id = idCounter,
                title = "Breaking News $idCounter",
                category = category,
                content = "Detail berita kategori $category"
            )

            idCounter++

            emit(news)
        }
    }

    fun getFormattedNewsStream(): Flow<String> = getNewsStream().map { news ->
        "[${news.category.uppercase()}] ${news.title} -- ${news.content.take(30)}..."
    }

    suspend fun fetchDetail(news: News): String {
        delay(1000)
        return "DETAIL LENGKAP: ${news.content}"
    }
}