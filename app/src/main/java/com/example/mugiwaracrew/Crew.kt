package com.example.mugiwaracrew

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Crew (
    val name: String,
    val bounty: String,
    val photo: String,
    val nickname: String,
    val description: String
    ): Parcelable