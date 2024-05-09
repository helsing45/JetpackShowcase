package com.ceos.jetpackshowcase.parks.data

import app.cash.turbine.test
import ca.bdc.features.home.viewmodels.CoroutineTestRule
import com.ceos.jetpackshowcase.Factories.Companion.defaultParkDto
import com.ceos.jetpackshowcase.Factories.Companion.defaultResultDto
import com.ceos.jetpackshowcase.parks.data.local.MockParkDao
import com.ceos.jetpackshowcase.parks.data.local.entities.ParkEntity
import com.ceos.jetpackshowcase.parks.data.mappers.ParkMapper
import com.ceos.jetpackshowcase.parks.data.remote.ParksApi
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import io.mockk.spyk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.delay
import kotlinx.coroutines.test.runTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.After
import org.junit.Rule
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class ParkRepositoryImplTest {
    @get:Rule
    val coroutineTestRule: CoroutineTestRule = CoroutineTestRule()

    private val localDataSource = spyk(MockParkDao())
    private val remoteDataSource = mockk<ParksApi>()

    private val subject = ParkRepositoryImpl(
        coroutineTestRule.testDispatcherProvider,
        localDataSource = localDataSource,
        remoteDataSource = remoteDataSource,
        mapper = ParkMapper()
    )

    @After
    fun tearDown() {
        localDataSource.tearDown()
    }

    @Test
    fun `the repository should return the local parks when they are present and a updated version from the remote`() = runTest {
        val park1 = defaultParkDto(id = "ff006980-9fbd-40b6-b2b3-470a115fd821", name = "Park #1")
        val park2 = defaultParkDto(id = "e6348b18-d703-4184-b32f-cabe181a68f3", name = "Park #2")
        val inputDto = defaultResultDto(
            value = listOf(park1, park2)
        )

        coEvery { remoteDataSource.getParks() } coAnswers {
            delay(100)
            inputDto
        }
        subject.getParks().test {
            val one = awaitItem()
            val two = awaitItem()
            assertThat(one).isEmpty()
            assertThat(two).isNotNull
            assertThat(two.size).isEqualTo(inputDto.value!!.size)
            assertThat(two[0].id).isEqualTo(park1.id)
            assertThat(two[1].id).isEqualTo(park2.id)
        }

        coVerify { localDataSource.upsert(*anyVararg<ParkEntity>()) }
    }

}
