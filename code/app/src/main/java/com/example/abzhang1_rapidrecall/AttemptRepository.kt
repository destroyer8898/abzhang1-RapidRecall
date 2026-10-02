package com.example.abzhang1_rapidrecall

class AttemptRepository {
    /*
    * Keeps track of attempt-related data, such as:
    * - The list of all attempts
    * - Number of attempts & correct attempts respectively
    * - Accuracy of the user's attempts (how many correct divided by the total)
    *
    * The attempt list is kept private, in order to avoid external callers from changing the attempt
    * data in unintended ways (i.e. an external call that calls attemptList.clear() would be allowed
    * if attemptList was public).
    *
    * As such I have implemented methods that implement the intended ways to interact with attemptList
    */
    private val attemptList: MutableList<Attempt> = mutableListOf()

    fun addAttempt(attempt: Attempt) {
        attemptList.add(attempt)
    }

    fun getAttemptList(): List<Attempt> {
        return attemptList
    }

    fun getAttemptCount(): Int {
        return attemptList.count()
    }

    fun getCorrectAttemptCount(): Int {
        return attemptList.count { it.isCorrect }
    }

    fun getAccuracyPercentage(): Float {
        if (getAttemptCount() == 0) return 0f
        return (getCorrectAttemptCount().toFloat() / getAttemptCount()) * 100f
    }
}