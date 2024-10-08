package com.blackcows.butakaeyak.data.repository.impl

import android.util.Log
import com.blackcows.butakaeyak.data.models.KakaoPlacePharmacy
import com.blackcows.butakaeyak.domain.repo.KakaoMapRepository
import com.blackcows.butakaeyak.data.source.api.KakaoMapSource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

private const val TAG = "KakaoMapRepositoryImpl"

class KakaoMapRepositoryImpl @Inject constructor(
    private val kakaoMapSource: KakaoMapSource,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO,
): KakaoMapRepository {
    override suspend fun searchCategory(x: String, y: String, date: Int): List<KakaoPlacePharmacy> {
        return runCatching {
            kakaoMapSource.searchCategoryPlace(x, y, date)
        }.getOrElse{
            Log.d(TAG, "onFailure")
            emptyList()
        }
    }

    override fun searchPlace(x: String, y: String, callback: (List<KakaoPlacePharmacy>) -> Unit) {
        // TODO("Not yet implemented")
    }
}