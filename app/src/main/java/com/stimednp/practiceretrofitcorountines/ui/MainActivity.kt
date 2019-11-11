package com.stimednp.practiceretrofitcorountines.ui

import android.os.Bundle
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.stimednp.practiceretrofitcorountines.R
import com.stimednp.practiceretrofitcorountines.api.*
import com.stimednp.practiceretrofitcorountines.data.Leagues
import com.stimednp.practiceretrofitcorountines.invisible
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.jetbrains.anko.*

class MainActivity : AppCompatActivity() {
    var dataList = ArrayList<Leagues>()
    lateinit var rv_main: RecyclerView
    lateinit var progress: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MainUI(dataList).setContentView(this)

        rv_main = find(R.id.rv_mainui)
        progress = find(R.id.progress_main)
        getAllDataId()
    }
    private fun getAllDataId() {
        val tsdbService = ApiFactory.tsdbApi
        GlobalScope.launch(Dispatchers.Main) {
            val allIdRequests = tsdbService.getAllId()
            try {
                val response = allIdRequests.await()
                val tsdbResponse = response.body()
                getHasil(tsdbResponse?.leagues!!)
            } catch (e: Exception) {
                toast("ERRORR --> $e")
                progress.invisible()
            }
        }
    }

    fun getHasil(response: ArrayList<Leagues>) {
        dataList.addAll(response)
        rv_main.adapter?.notifyDataSetChanged()
        progress.invisible()
    }
}
