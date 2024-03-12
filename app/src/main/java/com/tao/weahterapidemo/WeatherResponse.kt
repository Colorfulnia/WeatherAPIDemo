package com.tao.weahterapidemo

data class WeatherResponse(
    val coord: Coord,
    val main: Main
)

data class Coord(
    val lon: Double,
    val lat: Double
)

data class Main(
    val temp: Double
)
