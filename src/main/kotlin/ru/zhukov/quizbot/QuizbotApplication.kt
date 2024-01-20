package ru.zhukov.quizbot

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class QuizbotApplication

fun main(args: Array<String>) {
	runApplication<QuizbotApplication>(*args)
}
