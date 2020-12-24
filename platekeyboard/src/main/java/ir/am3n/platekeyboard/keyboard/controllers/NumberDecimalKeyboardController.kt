package ir.am3n.platekeyboard.keyboard.controllers

import android.view.inputmethod.InputConnection

class NumberDecimalKeyboardController(inputConnection: InputConnection) : DefaultKeyboardController(inputConnection) {

    override fun handleKeyStroke(c: Char) {
        if (c == '.') {
            // decimal numbers can only have one decimal point
            if (!inputText().contains('.')) {
                addCharacter(c)
            }
        } else {
            addCharacter(c)
        }
    }
}