package com.example.naviassignment.ui.repository

import com.example.freenow.ui.repository.BaseRepository
import com.example.naviassignment.api.ApiServiceInterface
import kotlinx.coroutines.CoroutineDispatcher

class GitRepository @Inject constructor(
    @Named("IO") private var dispatcher: CoroutineDispatcher,
    private val network: ApiServiceInterface
) : BaseRepository() {
    suspend fun fetchNearAroundTaxis(
        lat1: Double,
        long1: Double,
        lat2: Double,
        long2: Double
    ): NetworkResource<CabListDataModel> {
        return safeApiCall(dispatcher) {
            network.fetchNearAroundTaxis(lat1, long1, lat2, long2)
        }
    }
}
