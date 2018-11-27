package com.kuikadev.synthStore

import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan


@EnableAutoConfiguration
@ComponentScan
class SynthStoreApplication

fun main(args: Array<String>) {
    runApplication<SynthStoreApplication>(*args)
}
