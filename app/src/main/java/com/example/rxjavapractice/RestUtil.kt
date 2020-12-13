package util

import java.util.*

/**
 * RestUtility (Dummy)
 */
object RestUtil {
    /**
     * Get WeatherInfo (Dummy)
     *
     * @param place PlaceInfo
     * @return  WeatherInfo
     */
    fun getWeather(place: Place?): Weather {
        val weather: Weather
        weather = when (place) {
            Place.TOKYO -> Weather.SUNNY
            Place.YOKOHAMA -> Weather.RAINY
            Place.NAGOYA -> Weather.WINDY
            else -> Weather.SUNNY
        }
        try {
            // Dummy Logic
            Thread.sleep(Random().nextInt(500) + 500.toLong())
        } catch (e: InterruptedException) {
            // nop
        }
        return weather
    }

    /**
     * WeatherInfo
     */
    enum class Weather {
        SUNNY, RAINY, WINDY
    }

    /**
     * PlaceInfo
     */
    enum class Place {
        TOKYO, YOKOHAMA, NAGOYA
    }
}