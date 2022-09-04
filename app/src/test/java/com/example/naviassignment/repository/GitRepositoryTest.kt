package com.example.naviassignment.repository

import androidx.lifecycle.Observer
import com.example.naviassignment.BaseServiceTest
import com.example.naviassignment.data.GitResponse
import com.example.naviassignment.ui.repository.GitRepository
import com.example.naviassignment.ui.viewModel.GitViewModel
import com.example.naviassignment.utils.Constants.Companion.COMMIT_TYPE_CLOSED
import com.example.naviassignment.utils.NetworkResource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runBlockingTest
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

@ExperimentalCoroutinesApi
@RunWith(JUnit4::class)
class GitRepositoryTest : BaseServiceTest() {

    private val gitRepository = Mockito.mock(GitRepository::class.java)

    private lateinit var viewModel: GitViewModel

    @Mock
    lateinit var observerClosedPullRequestsLiveData: Observer<NetworkResource<List<GitResponse>>>

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        viewModel = GitViewModel(
            gitRepository
        )
        viewModel.getClosedGitMergeRequestLiveData()
            .observeForever(observerClosedPullRequestsLiveData)
        Dispatchers.setMain(Dispatchers.IO)
    }

    @After
    fun tearDown() {
        viewModel.getClosedGitMergeRequestLiveData()
            .removeObserver(observerClosedPullRequestsLiveData)
        Dispatchers.resetMain()
    }

    @Test
    fun loadClosedGitMergeRequestLiveData() {
        runBlocking {
            val gitClosedMergeRequestList = viewModel.getClosedGitMergeRequestLiveData()
            Assert.assertNotNull(gitClosedMergeRequestList)
        }
    }

    @Test
    fun testViewModelNotNull() = runTest {
        Assert.assertNotNull(viewModel)
    }

    @Test
    fun testLoadAllClosedGitPullRequestsFromServerResponseOnSuccess() {
        val viewModelResponse = Mockito.mock(GitResponse::class.java)
        runTest {
            Mockito.`when`(
                gitRepository.loadClosedGitMergeRequestList(COMMIT_TYPE_CLOSED)
            ).thenReturn(NetworkResource.success(listOf(viewModelResponse)))
            viewModel.loadClosedGitMergeRequestList()
            Mockito.verify(observerClosedPullRequestsLiveData)
                .onChanged(NetworkResource.loading(null))
        }
    }
}