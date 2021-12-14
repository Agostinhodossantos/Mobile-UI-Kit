package com.challenge.crypto.data.repository

import com.challenge.crypto.data.remote.CoinPaprikaApi
import com.challenge.crypto.data.remote.dto.CoinDetailDto
import com.challenge.crypto.data.remote.dto.CoinDto
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val api: CoinPaprikaApi
): CoinRepository {
    override suspend fun getCoins(): List<CoinDto> {
        return api.getCoins()
    }

    override suspend fun getCoinById(coinId: String): CoinDetailDto {
        return api.getCoinById(coinId)
    }
}