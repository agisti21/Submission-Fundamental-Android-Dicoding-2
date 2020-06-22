package com.agisti.submissionfundamental2.activity_fragment

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.agisti.submissionfundamental2.R
import com.agisti.submissionfundamental2.adapter.SectionPagerAdapter
import com.agisti.submissionfundamental2.model.UserItems
import com.agisti.submissionfundamental2.viewModel.DetailViewModel
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.activity_detail.*


class DetailActivity : AppCompatActivity() {

    private lateinit var detailViewModel: DetailViewModel

    companion object {
       const val EXTRA_USER = "extra_user"
    }

    override fun onCreate(savedInstanceState: Bundle?) { super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        supportActionBar?.let {
            it.elevation = 0f
            it.setDisplayHomeAsUpEnabled(true)
        }

        showLoading(true)

        val intent = intent.getParcelableExtra(EXTRA_USER) as UserItems
        val username = intent.username

        detailViewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())
            .get(DetailViewModel::class.java)

        detailViewModel.setUser(name = username)
        supportActionBar?.title = username


        detailView()
        configFragment()

    }

    private fun detailView(){


        detailViewModel.getUser().observe(this, Observer {
            if (it != null){
                Glide.with(this)
                    .load(it[0].avatar)
                    .apply(RequestOptions().override(500, 500))
                    .into(img_avatar_detail)
                txt_username_detail.setText(it[0].username)
                txt_company.setText(it[0].company)
                txt_location.setText(it[0].location)

                showLoading(false)

            }
        })

    }
    private fun configFragment(){
        val sectionPagerAdapter = SectionPagerAdapter(this, supportFragmentManager)
        view_pager.adapter = sectionPagerAdapter
        tabs.setupWithViewPager(view_pager)
    }

    private fun showLoading(state: Boolean){
        if(state) {
            progressBarDetail.visibility = View.VISIBLE
        }else {
            progressBarDetail.visibility = View.GONE
        }
    }

}

