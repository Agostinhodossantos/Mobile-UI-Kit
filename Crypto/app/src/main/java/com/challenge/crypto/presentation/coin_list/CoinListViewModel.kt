package com.challenge.crypto.presentation.coin_list

import androidx.lifecycle.ViewModel
import com.challenge.crypto.domain.use_case.get_coin.GetCoinUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class CoinListViewModel @Inject constructor(
    private val getCoinsUseCase: GetCoinUseCase
) : ViewModel() {

}