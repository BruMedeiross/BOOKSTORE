package com.brunadev.tm.teste

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.brunadev.tm.model.ResponseBody
import com.brunadev.tm.repository.Repository
import com.brunadev.tm.viewmodel.MainViewModel
import io.mockk.mockk
import io.mockk.unmockkAll
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.TestCoroutineScope
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations

@ExperimentalCoroutinesApi
class MainViewModelTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private val testDispatcher = TestCoroutineDispatcher()

    private val testScope = TestCoroutineScope(testDispatcher)

    @Mock
    private lateinit var mockRepository: Repository

    @Mock
    private lateinit var mockListStateObserver: Observer<ResponseBody?>

    private lateinit var viewModel: MainViewModel

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        Dispatchers.setMain(testDispatcher)
        viewModel = MainViewModel(mockRepository)
        viewModel.listState.observeForever(mockListStateObserver)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
        unmockkAll()
    }

    @Test
    fun `test init viewmodel then update state`() {
        runBlocking {
            //given
            val mockApiReponse = mockk<ResponseBody>()
                `when`(mockRepository.getEventsAPICoroutines()).thenReturn(mockApiReponse)

            //when
            viewModel.init()

            //then
            assert(viewModel.listState.value == mockApiReponse)
        }
    }

    @Test
    fun `test init viewModel then update null state`() {
        runBlocking {
            //given
            val mockApiResponse = null
            `when`(mockRepository.getEventsAPICoroutines()).thenReturn(mockApiResponse)

            //when
            viewModel.init()

            //then
            assert(viewModel.listState.value == null)
        }
    }

    @Test
    fun `test search event then update state`(){
        runBlocking {
            //given
            val mockApiResponse = mockk<ResponseBody>(relaxed = true)
            `when`(mockRepository.seachEventAPI("EUA")).thenReturn(mockApiResponse)

            //when
            viewModel.searchEvent("EUA")

            //then
            assert(viewModel.listState.value == mockApiResponse)
        }
    }

    @Test
    fun `test search event then update null state`(){
        runBlocking {
            //given
            val mockApiResponse = null
            `when`(mockRepository.seachEventAPI("EUA")).thenReturn(mockApiResponse)

            //when
            viewModel.searchEvent("EUA")

            //then
            assert(viewModel.listState.value == mockApiResponse)
        }
    }
}