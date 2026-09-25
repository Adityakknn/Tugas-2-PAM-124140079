package com.example.tugas_2_pam_124140079.viewmodel

import androidx.lifecycle.ViewModel
import com.example.tugas_2_pam_124140079.model.News
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class NewsViewModel : ViewModel() {

    private val allNews = listOf(
        News( id = 1,
            category = "Pendidikan",
            title = "Pembelajaran Digital Semakin Berkembang",
            content = "Pemanfaatan teknologi digital dalam pembelajaran memberikan kemudahan bagi siswa dan mahasiswa untuk mengakses materi dari berbagai sumber." ),
        News( id = 2,
            category = "Pendidikan",
            title = "Mahasiswa Mengembangkan Inovasi Teknologi",
            content = "Sejumlah mahasiswa mengembangkan berbagai proyek teknologi sebagai bagian dari kegiatan pembelajaran dan upaya menyelesaikan permasalahan di masyarakat." ),
        News( id = 3,
            category = "Politik",
            title = "DPR Membahas Rancangan Undang-Undang Baru",
            content = "Dewan Perwakilan Rakyat membahas sejumlah rancangan undang-undang dalam agenda legislasi untuk mendapatkan masukan dan pembahasan lebih lanjut." ),
        News( id = 4,
            category = "Politik",
            title = "Partisipasi Masyarakat dalam Demokrasi",
            content = "Partisipasi masyarakat dalam proses demokrasi dapat dilakukan melalui berbagai cara, termasuk mengikuti informasi kebijakan publik dan menggunakan hak pilih dalam pemilihan umum."
        )
    )

    private val _newsList = MutableStateFlow(allNews)
    val newsList: StateFlow<List<News>> = _newsList.asStateFlow()

    private val _readCount = MutableStateFlow(0)
    val readCount: StateFlow<Int> = _readCount.asStateFlow()

    private val _selectedCategory = MutableStateFlow("Semua")
    val selectedCategory: StateFlow<String> =
        _selectedCategory.asStateFlow()

    private val _selectedNews = MutableStateFlow<News?>(null)
    val selectedNews: StateFlow<News?> =
        _selectedNews.asStateFlow()

    fun changeCategory(category: String) {
        _selectedCategory.value = category

        _newsList.value = if (category == "Semua") {
            allNews
        } else {
            allNews.filter {
                it.category == category
            }
        }
    }

    fun readNews(news: News) {
        _readCount.value++
    }

    fun selectNews(news: News) {
        _selectedNews.value = news
    }

    fun clearSelectedNews() {
        _selectedNews.value = null
    }
}