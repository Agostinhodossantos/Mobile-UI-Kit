package com.challenge.crypto.presentation.coin_detail

import com.challenge.crypto.data.remote.dto.CoinDetail
import com.challenge.crypto.domain.model.Coin

data class CoinDetailState(
    val isLoading: Boolean = false,
    val coin: CoinDetail? = null,
    val error: String = ""
)
