package mastermind

data class Evaluation(val positions: Int, val letters: Int)

fun evaluateGuess(secret: String, guess: String): Evaluation {

    val positions = secret.zip(guess).count() {
        pair: Pair<Char, Char> -> pair.first == pair.second
    }

    val commonLetters = "ABCDEF".sumBy { ch ->
        Math.min(secret.count {s -> s==ch}, guess.count {g -> g==ch })
    }

    return Evaluation(positions, commonLetters - positions)

//    var position = 0
//    var letter = 0
//    var secretRemain = secret
//    var guessRemain = guess
//    guess.withIndex().forEach { (index, ch) ->
//        if (secret[index] == ch) {
//            position++
//            secretRemain = secretRemain.removeOneChar(ch)
//            guessRemain = guessRemain.removeOneChar(ch)
//        }
//    }
//
//    guessRemain.forEach { ch ->
//        if (secretRemain.contains(ch)) {
//            letter++
//            secretRemain = secretRemain.removeOneChar(ch)
//        }
//    }

//    return Evaluation(position, letter)
}

fun String.removeOneChar(charToRemove: Char): String {
    val idx = this.indexOf(charToRemove)
    return if(idx >= 0) this.removeRange(idx, idx+1) else this
}

