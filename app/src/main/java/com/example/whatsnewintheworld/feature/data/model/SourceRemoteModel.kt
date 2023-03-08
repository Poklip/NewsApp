package com.example.whatsnewintheworld.feature.data.model

import com.google.gson.annotations.SerializedName

data class SourceRemoteModel(
    @SerializedName("name")
    val sourceName: String
)