package com.stimednp.practiceretrofitcorountines.data

import com.google.gson.annotations.SerializedName

/**
 * Created by rivaldy on 11/10/2019.
 */

class TsdbResponse {
    @SerializedName("leagues")
    var leagues = ArrayList<Leagues>()
}
class Leagues {
    @SerializedName("idLeague")
    lateinit var idLeague: String
    @SerializedName("strLeague")
    lateinit var strLeague: String
}