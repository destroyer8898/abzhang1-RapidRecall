package com.example.abzhang1_rapidrecall

class Attempt(
    /*
    * Represents the data of an individual attempt at the game, keeping track of:
    * - The target sequence & its length
    * - The user's guess sequence
    * - Whether the attempt was correct
    * - The timestamp of the attempt.
    *
    * - timestamp is a long; this is somewhat outdated but the new version (java.time.Instant)
    * would restrict the program to only work with somewhat newer versions of Android.
    */
    val sequenceLength: Int,
    val targetSequence: String,
    val userInput: String,
    val isCorrect: Boolean,
    val timestamp: Long
)