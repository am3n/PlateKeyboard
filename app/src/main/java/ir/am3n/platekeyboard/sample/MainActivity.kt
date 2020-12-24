package ir.am3n.platekeyboard.sample

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ir.am3n.platekeyboard.keyboard.PlateKeyboardView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        keyboard.registerEditText(PlateKeyboardView.KeyboardType.NUMBER, testNumberField)
        keyboard.registerEditText(PlateKeyboardView.KeyboardType.ALPHABET, testQwertyField)

        switchActivitiesButton.setOnClickListener {
            startActivity(Intent(this@MainActivity, AdvancedActivity::class.java))
        }

    }

    override fun onBackPressed() {
        if (keyboard.isExpanded) {
            keyboard.translateLayout()
        } else {
            super.onBackPressed()
        }
    }

}