package com.ceos.jetpackshowcase.events.data.remote.dto


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class EventsDto(
    @SerialName("data")
    val events: List<EventDto?>?,
    @SerialName("dates")
    val dates: String?,
    @SerialName("pagenumber")
    val pagenumber: String?,
    @SerialName("pagesize")
    val pagesize: String?,
    @SerialName("total")
    val total: String?
) {
    @Serializable
    data class EventDto(
        @SerialName("category")
        val category: String?,
        @SerialName("categoryid")
        val categoryid: String?,
        @SerialName("contactemailaddress")
        val contactemailaddress: String?,
        @SerialName("contactname")
        val contactname: String?,
        @SerialName("contacttelephonenumber")
        val contacttelephonenumber: String?,
        @SerialName("createuser")
        val createuser: String?,
        @SerialName("date")
        val date: String?,
        @SerialName("dateend")
        val dateend: String?,
        @SerialName("dates")
        val dates: List<String?>?,
        @SerialName("datestart")
        val datestart: String?,
        @SerialName("datetimecreated")
        val datetimecreated: String?,
        @SerialName("datetimeupdated")
        val datetimeupdated: String?,
        @SerialName("description")
        val description: String?,
        @SerialName("eventid")
        val eventid: String?,
        @SerialName("feeinfo")
        val feeinfo: String?,
        @SerialName("id")
        val id: String?,
        @SerialName("imageidlist")
        val imageidlist: String?,
        @SerialName("images")
        val images: List<Image?>?,
        @SerialName("infourl")
        val infourl: String?,
        @SerialName("isallday")
        val isallday: String?,
        @SerialName("isfree")
        val isfree: String?,
        @SerialName("isrecurring")
        val isrecurring: String?,
        @SerialName("isregresrequired")
        val isregresrequired: String?,
        @SerialName("latitude")
        val latitude: String?,
        @SerialName("location")
        val location: String?,
        @SerialName("longitude")
        val longitude: String?,
        @SerialName("organizationname")
        val organizationname: String?,
        @SerialName("parkfullname")
        val parkfullname: String?,
        @SerialName("portalname")
        val portalname: String?,
        @SerialName("recurrencedateend")
        val recurrencedateend: String?,
        @SerialName("recurrencedatestart")
        val recurrencedatestart: String?,
        @SerialName("recurrencerule")
        val recurrencerule: String?,
        @SerialName("regresinfo")
        val regresinfo: String?,
        @SerialName("regresurl")
        val regresurl: String?,
        @SerialName("sitecode")
        val sitecode: String?,
        @SerialName("sitetype")
        val sitetype: String?,
        @SerialName("subjectname")
        val subjectname: String?,
        @SerialName("tags")
        val tags: List<String?>?,
        @SerialName("timeinfo")
        val timeinfo: String?,
        @SerialName("times")
        val times: List<Time?>?,
        @SerialName("title")
        val title: String?,
        @SerialName("types")
        val types: List<String?>?,
        @SerialName("updateuser")
        val updateuser: String?
    ) {
        @Serializable
        data class Image(
            @SerialName("altText")
            val altText: String?,
            @SerialName("caption")
            val caption: String?,
            @SerialName("credit")
            val credit: String?,
            @SerialName("imageId")
            val imageId: String?,
            @SerialName("ordinal")
            val ordinal: String?,
            @SerialName("path")
            val path: String?,
            @SerialName("title")
            val title: String?,
            @SerialName("url")
            val url: String?
        )

        @Serializable
        data class Time(
            @SerialName("sunrisestart")
            val sunrisestart: String?,
            @SerialName("sunsetend")
            val sunsetend: String?,
            @SerialName("timeend")
            val timeend: String?,
            @SerialName("timestart")
            val timestart: String?
        )
    }
}