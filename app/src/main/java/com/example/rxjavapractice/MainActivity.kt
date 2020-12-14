package com.example.rxjavapractice

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.CompletableEmitter
import io.reactivex.rxjava3.core.Flowable
import util.RestUtil
import util.RestUtil.getWeather


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Flowable.just("Hello RxJava").subscribe(System.out::println)

        System.out.println("=============== main start ===============")

        Completable.create { emitter: CompletableEmitter ->

            val tokyoWeather = getWeather(RestUtil.Place.TOKYO)
            val yokohamaWeather = getWeather(RestUtil.Place.YOKOHAMA)
            val nagoyaWeather = getWeather(RestUtil.Place.NAGOYA)

            println(tokyoWeather)
            println(yokohamaWeather)
            println(nagoyaWeather)

            emitter.onComplete()
        }.subscribe({
            println("Complete!!")
        }) { throwable: Throwable ->
            println("Error!!")
            throwable.printStackTrace()
        }

        System.out.println("=============== main end ===============")
    }
}