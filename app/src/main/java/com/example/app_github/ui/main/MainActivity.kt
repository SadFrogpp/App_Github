package com.example.app_github.ui.main

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.app_github.R
import com.example.app_github.adapter.MainAdapter
import com.example.app_github.connecter.Connecter
import com.example.app_github.model.IssueModel
import com.example.app_github.model.MainModel
import com.example.app_github.ui.info.InfoActivity
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    val onClick = { it: String ->
        startActivity<InfoActivity>("url" to it)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getIssue()
    }

    fun getIssue() {
        Connecter.createApi().getIssue("open", "comments", "asc").enqueue(object : Callback<List<IssueModel>> {
            override fun onResponse(call: Call<List<IssueModel>>, response: Response<List<IssueModel>>) {
                val mainModel = arrayListOf<MainModel>()
                response.body()?.take(10)?.forEach {
                    mainModel.add(MainModel(it.title, "유저 이름: ${it.user.login}", "날짜: ${it.createdAt}", it.comments, it.url))
                }
                recycler_issue.adapter = MainAdapter(mainModel, onClick)
            }

            override fun onFailure(call: Call<List<IssueModel>>, t: Throwable) {
                toast("정보를 받아올수 없습니다.")
            }
        })
    }
}
