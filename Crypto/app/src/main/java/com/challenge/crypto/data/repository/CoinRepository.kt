package com.challenge.crypto.data.repository

import com.challenge.crypto.data.remote.dto.CoinDetailDto
import com.challenge.crypto.data.remote.dto.CoinDto

interface CoinRepository {

    suspend fun getCoins(): List<CoinDto>

    suspend fun getCoinById(coinId: String): CoinDetailDto
}