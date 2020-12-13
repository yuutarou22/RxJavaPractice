package com.example.rxjavapractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import io.reactivex.rxjava3.core.Flowable
import util.RestUtil

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Flowable.just("Hello RxJava").subscribe(System.out::println)

        System.out.println("=============== main start ===============")
        var tokyoWeather = RestUtil.getWeather(RestUtil.Place.TOKYO)
        var yokohamaWeather = RestUtil.getWeather(RestUtil.Place.YOKOHAMA)
        var nagoyaWeather = RestUtil.getWeather(RestUtil.Place.NAGOYA)

        System.out.println(tokyoWeather)
        System.out.println(yokohamaWeather)
        System.out.println(nagoyaWeather)

        System.out.println("=============== main end ===============")
    }
}