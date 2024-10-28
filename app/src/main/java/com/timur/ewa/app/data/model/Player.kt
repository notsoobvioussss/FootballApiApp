package com.timur.ewa.app.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.parcelize.RawValue

data class PlayerResponse(
    val api: ApiData
)

data class ApiData(
    val results: Int,
    val topscorers: List<TopScorer>
)

@Parcelize
data class TopScorer(
    val player_id: Int,
    val player_name: String,
    val firstname: String,
    val lastname: String,
    val position: String,
    val nationality: String,
    val team_id: Int,
    val team_name: String,
    val games: @RawValue Games,
    val goals: @RawValue Goals,
    val shots: @RawValue Shots,
    val penalty: @RawValue Penalty,
    val cards: @RawValue Cards
) : Parcelable

data class Games(
    val appearences: Int,
    val minutes_played: Int
)

data class Goals(
    val total: Int,
    val assists: Int,
    val conceded: Int?,
    val saves: Int
)

data class Shots(
    val total: Int,
    val on: Int
)

data class Penalty(
    val won: Int,
    val commited: Int?,
    val success: Int,
    val missed: Int,
    val saved: Int?
)

data class Cards(
    val yellow: Int,
    val second_yellow: Int,
    val red: Int
)