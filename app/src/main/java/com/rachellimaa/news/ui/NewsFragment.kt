package com.rachellimaa.news.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.rachellimaa.news.R
import com.rachellimaa.news.data.repository.NewsRepository
import com.rachellimaa.news.data.repository.api.NewsFANApiDataSource
import com.rachellimaa.news.data.repository.db.NewsDbDataSource
import kotlinx.android.synthetic.main.main_fragment.*

class NewsFragment : Fragment(R.layout.main_fragment) {

    private val viewModel by viewModels<NewsViewModel> {
        object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                val newsDbDataSource = NewsDbDataSource()
                //val newsApiDataSource = NewsApiDataSource(WebApiAccess.newsApi)
                val newsApiDataSource = NewsFANApiDataSource()
                val newsRepository =
                    NewsRepository(requireContext(), newsDbDataSource, newsApiDataSource)

                return NewsViewModel(newsRepository) as T
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.articlesEvent.observe(viewLifecycleOwner, {
            with(recyclerArticles) {
                setHasFixedSize(true)
                adapter = NewsAdapter(it)
            }
        })

        viewModel.getNews()
    }

}