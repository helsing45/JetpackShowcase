package com.ceos.jetpackshowcase

import com.ceos.jetpackshowcase.parks.data.local.entities.ParkEntity
import com.ceos.jetpackshowcase.parks.data.remote.dtos.ParkDto
import com.ceos.jetpackshowcase.parks.data.remote.dtos.ResultDto

class Factories {
    companion object {
        fun <T> defaultResultDto(
            value: List<T>? = emptyList(),
            limit: String? = "100",
            start: String? = "0",
            total: String? = "200"
        ) = ResultDto(
            value,
            limit,
            start,
            total
        )

        fun defaultParkDto(
            id: String? = "b0fecec6-be71-4a2b-8f23-decc1a1ad9f8",
            description: String? = "For over a century people from around the world have come to rural Central Kentucky to honor the humble beginnings of our 16th president, Abraham Lincoln. His early life on Kentucky's frontier shaped his character and prepared him to lead the nation through Civil War. Visit our country's first memorial to Lincoln, built with donations from young and old, and the site of his childhood home.",
            designation: String? = "National Historical Park",
            directionsInfo: String? = "The Birthplace Unit of the park is located approximately 2 miles south of the town of Hodgenville on U.S. Highway 31E South. The Boyhood Home Unit at Knob Creek is located approximately 10 miles northeast of the Birthplace Unit of the park.",
            fullName: String? = "Abraham Lincoln Birthplace National Historical Park",
            latitude: String? = "37.5858662",
            longitude: String? = "-85.67330523",
            name: String? = "Abraham Lincoln Birthplace",
            parkCode: String? = "abli",
            states: String? = "KY",
            url: String? = "https://www.nps.gov/abli/index.htm"
        ) = ParkDto(
            id,
            description,
            designation,
            directionsInfo,
            fullName,
            latitude,
            longitude,
            name,
            parkCode,
            states,
            url
        )

        fun defaultParkEntity(
            id: String = "b0fecec6-be71-4a2b-8f23-decc1a1ad9f8",
            name: String = "Abraham Lincoln Birthplace",
            description: String? = "For over a century people from around the world have come to rural Central Kentucky to honor the humble beginnings of our 16th president, Abraham Lincoln. His early life on Kentucky's frontier shaped his character and prepared him to lead the nation through Civil War. Visit our country's first memorial to Lincoln, built with donations from young and old, and the site of his childhood home.",
            latitude: Double = 37.5858662,
            longitude: Double = -85.67330523,
        ) = ParkEntity(id, name, description, latitude, longitude)
    }
}