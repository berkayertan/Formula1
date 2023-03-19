package com.berkayertan.recycler.data

import com.google.gson.annotations.SerializedName

data class StandingModel(
    @SerializedName("position")
    val position : Int,
    @SerializedName("name")
    val name : String?,
    @SerializedName("surname")
    val surname : String?,
    @SerializedName("acronym")
    val shortname : String?,
    @SerializedName("team")
    val team : String?,
    @SerializedName("points")
    val points : Int,

)
/*
position:"1"
name:"Max"
surname:"Verstappen"
acronym:"VER"
team:"Red Bull Racing RBPT"
points:"454"  */

