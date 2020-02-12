package com.krikorherlopian.internship

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.krikorherlopian.internship.model.Feed
import com.krikorherlopian.internship.model.Results
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback


class MainActivity : AppCompatActivity(), ListListener {

    private var list: MutableList<Any> =  mutableListOf()
    private lateinit var adapter: RecyclerViewAdapter
    private val baseUrl = "https://raw.githubusercontent.com/vikrama/"
    private var retrofit: Retrofit? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fetch()
        swipeContainer.setOnRefreshListener {
            fetch()
        }
        // Configure the refreshing colors
        swipeContainer.setColorSchemeResources(R.color.colorAccent,
            R.color.colorPrimary,
            R.color.colorPrimaryDark,
            R.color.colorPrimary)
    }

    private fun getClient(): Retrofit {
        if (retrofit == null) {
            retrofit = Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
        return retrofit!!
    }

    private fun fetch(){
        swipeContainer.isRefreshing = true
        val apiService = getClient().create(ApiInterface::class.java)
        val responseBodyCall = apiService.getList()
        responseBodyCall.enqueue(object : Callback<Feed> {
            override fun onResponse(
                call: Call<Feed>,
                response: retrofit2.Response<Feed>
            ) {
                swipeContainer.isRefreshing = false
                val feed: Feed = response.body() as Feed
                list =  feed.response.results as MutableList<Any>
                adapter = RecyclerViewAdapter(
                    list, this@MainActivity,this@MainActivity
                )
                recyclerView?.layoutManager = LinearLayoutManager(this@MainActivity)
                recyclerView?.itemAnimator = DefaultItemAnimator()
                recyclerView?.adapter = adapter
                adapter.notifyDataSetChanged()
            }

            override fun onFailure(
                call: Call<Feed>,
                t: Throwable
            ) {
                swipeContainer.isRefreshing = false
            }
        })
    }

    override fun rowClicked(row: Int) {
        val result = list.elementAt(row) as Results
        when(result.type){
            "REVIEW_RESULT" -> goToDetails(result)
            "INTERVIEW_RESULT" -> Toast.makeText(this, resources.getString(R.string.interview_not_supported), Toast.LENGTH_SHORT).show()
            "SALARY_RESULT" -> goToDetails(result)
        }
    }

    private fun goToDetails(result: Results){
        val i = Intent(
            this@MainActivity,
            DetailsActivity::class.java
        )
        i.putExtra("result", result)
        startActivity(i)
    }
}
