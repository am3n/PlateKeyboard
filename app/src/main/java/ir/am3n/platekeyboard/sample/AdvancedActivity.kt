package ir.am3n.platekeyboard.sample

import android.content.Intent
import android.os.Bundle
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import ir.am3n.platekeyboard.keyboard.PlateKeyboardView
import ir.am3n.platekeyboard.textFields.CustomTextField
import ir.am3n.platekeyboard.utilities.ComponentUtils
import kotlinx.android.synthetic.main.activity_advanced_features.*

class AdvancedActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_advanced_features)

        customFieldWrapper.addView(
            createCustomTextField("Custom Number Keyboard", PlateKeyboardView.KeyboardType.NUMBER)
        )
        customFieldWrapper.addView(
            createCustomTextField("Custom Alphabet Keyboard", PlateKeyboardView.KeyboardType.ALPHABET)
        )

        keyboard.autoRegisterEditTexts(customFieldWrapper)

        switchActivitiesButton.setOnClickListener {
            startActivity(Intent(this@AdvancedActivity, MainActivity::class.java))
        }

    }

    private fun createCustomTextField(hint: String, keyboardType: PlateKeyboardView.KeyboardType): CustomTextField {
        val field = CustomTextField(applicationContext)
        val lp = LinearLayout.LayoutParams(
            ComponentUtils.dpToPx(applicationContext, 400),
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        val marginBottom = applicationContext.resources.getDimension(R.dimen.fieldMarginBottom).toInt()
        lp.setMargins(0, 0, 0, marginBottom)
        field.layoutParams = lp

        field.hint = hint
        field.keyboardType = keyboardType

        return field
    }

    override fun onBackPressed() {
        if (keyboard.isExpanded) {
            keyboard.translateLayout()
        } else {
            super.onBackPressed()
        }
    }

}