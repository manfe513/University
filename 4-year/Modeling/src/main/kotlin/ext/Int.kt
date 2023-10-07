package ext

import kotlin.random.Random

fun Int.plusMinus(value: Int): Int = Random.nextInt(this-value, this+value)
fun Int.inRangeTo(value: Int): Int = Random.nextInt(this, value)
fun Int.orOther(value: Int): Int = if (Random.nextBoolean()) this else value