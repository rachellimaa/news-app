package com.rachellimaa.news.presentation

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.rachellimaa.news.R
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.main_fragment.*

@AndroidEntryPoint
class NewsFragment : Fragment(R.layout.main_fragment) {

    private val viewModel: NewsViewModel by viewModels()

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