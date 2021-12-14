package com.challenge.crypto.domain.use_case.get_coin

import com.challenge.crypto.common.Resource
import com.challenge.crypto.data.remote.dto.CoinDetail
import com.challenge.crypto.data.remote.dto.toCoin
import com.challenge.crypto.data.remote.dto.toCoinDetail
import com.challenge.crypto.data.repository.CoinRepository
import com.challenge.crypto.domain.model.Coin
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    operator fun invoke(coinId: String): Flow<Resource<CoinDetail>> = flow {
//        try {
//            emit(Resource.Loading())
//            val coin = repository.getCoinById(coinId).toCoinDetail()
//            emit(Resource.Success(coin))
//        } catch (e: HttpException) {
//            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occured"))
//        } catch (e: IOException) {
//            emit(Resource.Error("Couldn't reach server. Check your internet connection"))
//        }
    }
}