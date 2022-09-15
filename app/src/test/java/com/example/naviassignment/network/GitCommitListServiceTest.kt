package com.example.naviassignment.network

import com.example.naviassignment.BaseServiceTest
import com.example.naviassignment.api.ApiServiceInterface
import com.example.naviassignment.data.ApiGitResponse
import com.example.naviassignment.utils.Constants.Companion.COMMIT_TYPE_CLOSED
import junit.framework.TestCase
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class GitCommitListServiceTest : BaseServiceTest() {
    private var mockWebServer = MockWebServer()

    @Mock
    private lateinit var apiServiceInterface: ApiServiceInterface

    @Before
    fun createService() {
        MockitoAnnotations.openMocks(this)
    }

    @Test
    fun getClosedMergeRequests() {
        runBlocking {
            val response = Mockito.mock(ApiGitResponse::class.java)
            Mockito.`when`(
                apiServiceInterface.loadClosedGitMergeRequestList(COMMIT_TYPE_CLOSED,20,1)
            ).thenReturn(listOf(response))
            val data = apiServiceInterface.loadClosedGitMergeRequestList(COMMIT_TYPE_CLOSED,20,1)
            TestCase.assertTrue(data == listOf(response))
        }
    }

    @After
    fun tearDown() {
        mockWebServer.shutdown()
    }
}
