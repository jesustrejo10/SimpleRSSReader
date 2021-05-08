package com.jesustrejo10.simplerssreader.ui.feed

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.jesustrejo10.simplerssreader.R
import com.jesustrejo10.simplerssreader.model.data.response.RssArticle
import com.jesustrejo10.simplerssreader.ui.articledetail.ArticleDetailActivity
import com.jesustrejo10.simplerssreader.ui.base.BaseActivity
import com.jesustrejo10.simplerssreader.ui.model.OperationStatus
import com.jesustrejo10.simplerssreader.ui.model.UiResponse
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.feed_activity.*

@AndroidEntryPoint
class FeedSetupActivity : BaseActivity(), ArticleListContract {

    private lateinit var viewModel: FeedSetupViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.feed_activity)
        viewModel = ViewModelProvider(this).get(FeedSetupViewModel::class.java)
        manageViewComponents()
        manageObservers()
        viewModel.test()
    }
    override fun manageViewComponents() {
    }

    override fun manageObservers() {
        viewModel.getArticlesLiveData.observe(this, Observer {
            handleArticlesResponse(it)
        })
    }

    private fun handleArticlesResponse(it: UiResponse<List<RssArticle>?>?) {
        if(it != null) {
            when (it.status) {
                OperationStatus.SUCCESS -> {
                    dismissLoading()
                    handleSuccessFeed(it.value)
                }
                OperationStatus.ERROR -> {
                    dismissLoading()
                    Toast.makeText(this, it.message, Toast.LENGTH_LONG).show()
                }
                OperationStatus.IN_PROGRESS -> {
                    displayLoading()
                }
            }
        }
    }

    private fun handleSuccessFeed(articleList: List<RssArticle>?) {
        if(articleList.isNullOrEmpty()){
            articleListRecyclerView.visibility = View.GONE
            emptyStatus.visibility = View.VISIBLE
        }else{
            articleListRecyclerView.layoutManager = LinearLayoutManager(this)
            val adapter = FeedAdapter(articleList,this)
            articleListRecyclerView.adapter = adapter
        }
    }

    override fun onArticleClick(article: RssArticle) {
        val intent = Intent(this,ArticleDetailActivity::class.java)
        intent.putExtra("URL",article.url)
        startActivity(intent)
    }
}