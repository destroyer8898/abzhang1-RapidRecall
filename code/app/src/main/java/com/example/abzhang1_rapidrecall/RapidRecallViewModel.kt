package com.example.abzhang1_rapidrecall

import androidx.lifecycle.ViewModel

class RapidRecallViewModel: ViewModel() {
    /*
    * Keeps track of data that needs to be carried between different screens. It essentially wraps
    * an AttemptRepository while also keeping track of the selected sequenceLength that a
    * user may select before a game. The data contained within AttemptRepository and sequenceLength
    * are supposed to be carried through between screens, thus necessitating this class.
    *
    * The AttemptRepository is kept private in order to prevent external calls of the repository's
    * methods. Various get methods are provided so the user can still access the repository's data.
    *
    * sequenceLength is kept public for read-access by external callers, but changing its value is
    * restricted to the setSequenceLength method.
    *
    * recordAttempt is a method that stores an attempt into the repository. The timestamp associated
    * with the attempt is created at the approx. time of calling this method.
    * */
    private val repository = AttemptRepository()
    var sequenceLength: Int = 1
        private set

    fun setSequenceLength(newSequenceLength: Int) {
        sequenceLength = newSequenceLength
    }

    fun recordAttempt(
        sequenceLength: Int,
        targetSequence: String,
        userInput: String
    ) {
        val isCorrect = userInput == targetSequence
        val timestamp = System.currentTimeMillis()
        repository.addAttempt(Attempt(sequenceLength, targetSequence, userInput, isCorrect, timestamp))
    }

    fun getAttemptList(): List<Attempt> {
        return repository.getAttemptList()
    }

    fun getAttemptCount(): Int {
        return repository.getAttemptCount()
    }

    fun getCorrectAttemptCount(): Int {
        return repository.getCorrectAttemptCount()
    }

    fun getAccuracyPercentage(): Float {
        return repository.getAccuracyPercentage()
    }
}