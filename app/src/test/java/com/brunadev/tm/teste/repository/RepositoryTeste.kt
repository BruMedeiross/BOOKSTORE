package com.brunadev.tm.teste.repository
import com.brunadev.tm.constant.EventConstants.API_CODE
import com.brunadev.tm.constant.EventConstants.API_KEY
import com.brunadev.tm.model.ResponseBody
import com.brunadev.tm.repository.EventImpl
import com.brunadev.tm.repository.RemoteDataSource
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import com.nhaarman.mockito_kotlin.whenever
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test


class EventImplTest {

    private lateinit var eventImpl: EventImpl
    private val remoteDataSource: RemoteDataSource = mock()

    @Before
    fun setUp() {
        eventImpl = EventImpl(this.remoteDataSource)
    }

    @Test
    fun `test getEventsAPICoroutines should call remoteDataSource eventList`() = runBlocking {
        val mockResponse = mockk<ResponseBody>()
        whenever(remoteDataSource.eventList(API_KEY)).thenReturn(mockResponse)

        val resul = eventImpl.getEventsAPICoroutines()

        assert(resul == mockResponse)
    }

    @Test
    fun `test seachEventAPI should call remoteDataSource eventSearchList with search term`() = runBlocking {
        val mockResponse = mockk<ResponseBody>()
        whenever(remoteDataSource.eventSearchList("EUA", API_CODE, API_KEY)).thenReturn(mockResponse)

        val result = eventImpl.seachEventAPI("EUA")

        verify(remoteDataSource).eventSearchList("EUA", API_CODE, API_KEY)  // Verify the method is called with the correct parameters
        assert(result == mockResponse)
    }
}

