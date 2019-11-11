package com.stimednp.practiceretrofitcorountines.api

import com.stimednp.practiceretrofitcorountines.data.TsdbResponse
import kotlinx.coroutines.Deferred
//import org.jetbrains.kotlin.kotlinx.coroutines.experimental.Deferred
import retrofit2.Response
import retrofit2.http.GET

/**
 * Created by rivaldy on 11/10/2019.
 */

interface TsdbApi {
    @GET("api/v1/json/1/all_leagues.php")
    fun getAllId(): Deferred<Response<TsdbResponse>>
}