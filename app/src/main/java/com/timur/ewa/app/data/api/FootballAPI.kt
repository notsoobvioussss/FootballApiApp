package com.timur.ewa.app.data.api



import com.timur.ewa.app.data.model.PlayerResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path

interface FootballApi {
    @GET("v2/topscorers/{league_id}")
    suspend fun getTopScorers(
        @Path("league_id") leagueId: Int,
        @Header("x-rapidapi-key") apiKey: String,
    ): Response<PlayerResponse>
}
