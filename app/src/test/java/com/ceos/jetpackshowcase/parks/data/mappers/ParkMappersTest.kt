package com.ceos.jetpackshowcase.parks.data.mappers

import com.ceos.jetpackshowcase.Factories
import com.ceos.jetpackshowcase.error_handling.UnexpectedNullWhileMappingError
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class ParkMappersTest {
    @Test(expected = UnexpectedNullWhileMappingError::class)
    fun `when remote dto has a null id then unexpected null error is thrown`() {
        val remoteDto = Factories.defaultParkDto(
            id = null
        )

        remoteDto.toEntity()
    }

    @Test(expected = UnexpectedNullWhileMappingError::class)
    fun `when remote dto has a null name then unexpected null error is thrown`() {
        val remoteDto = Factories.defaultParkDto(
            name = null
        )

        remoteDto.toEntity()
    }

    @Test
    fun `when remote dto has a null description then is mapped has null`() {
        val remoteDto = Factories.defaultParkDto(
            description = null
        )

        val entity = remoteDto.toEntity()

        assertThat(entity.description).isNull()
    }

    @Test
    fun `when remote dto has a null lat then is mapped has NaN`() {
        val remoteDto = Factories.defaultParkDto(
            latitude = null
        )

        val entity = remoteDto.toEntity()

        assertThat(entity.lat.isNaN()).isTrue()
    }

    @Test
    fun `when remote dto has a null lng then is mapped as NaN`() {
        val remoteDto = Factories.defaultParkDto(
            longitude = null
        )

        val entity = remoteDto.toEntity()

        assertThat(entity.lng.isNaN()).isTrue()
    }

    @Test
    fun `when remote is well formatted, then entity is well mapped`() {
        val latitude = 37.5858662
        val longitude = -85.67330523
        val remoteDto = Factories.defaultParkDto(
            latitude = latitude.toString(),
            longitude = longitude.toString()
        )

        val entity = remoteDto.toEntity()

        assertThat(entity.id).isEqualTo(remoteDto.id)
        assertThat(entity.name).isEqualTo(remoteDto.name)
        assertThat(entity.description).isEqualTo(remoteDto.description)
        assertThat(entity.lat).isEqualTo(latitude)
        assertThat(entity.lng).isEqualTo(longitude)
    }


    @Test
    fun `entity fields are mapped correctly to domain fields`() {
        val entity = Factories.defaultParkEntity()

        val domain = entity.toDomain()

        assertThat(domain.id).isEqualTo(entity.id)
        assertThat(domain.name).isEqualTo(entity.name)
        assertThat(domain.description).isEqualTo(entity.description)
        assertThat(domain.lat).isEqualTo(entity.lat)
        assertThat(domain.lng).isEqualTo(entity.lng)
    }
}