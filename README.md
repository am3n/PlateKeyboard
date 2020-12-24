# Android-PlateKeyboard

## How to use

```groovy
root build.gradle:
allprojects {
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}

project build.gradle:
dependencies {
    implementation 'com.github.am3n:PlateKeyboard:Tag'
}

```

```xml
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent">

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:gravity="center"
        android:orientation="vertical"
        android:paddingBottom="300dp">

        <EditText
            android:id="@+id/numberField"
            android:layout_width="@dimen/fieldWidth"
            android:layout_height="wrap_content"
            android:layout_marginBottom="@dimen/fieldMarginBottom"
            android:hint="@string/customNumber"
            android:maxLength="20" />

        <EditText
            android:id="@+id/qwertyField"
            android:layout_width="@dimen/fieldWidth"
            android:layout_height="wrap_content"
            android:layout_marginBottom="@dimen/fieldMarginBottom"
            android:hint="@string/customQwerty"
            android:maxLength="50" />

    </LinearLayout>

    <ir.am3n.platekeyboard.keyboard.PlateKeyboardView
        android:id="@+id/keyboard"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_alignParentBottom="true" />

</RelativeLayout>
```

```kotlin
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        keyboard.registerEditText(PlateKeyboardView.KeyboardType.NUMBER, numberField)
        keyboard.registerEditText(PlateKeyboardView.KeyboardType.ALPHABET, qwertyField)

    }

    override fun onBackPressed() {
        if (keyboard.isExpanded) {
            keyboard.translateLayout()
        } else {
            super.onBackPressed()
        }
    }

}
```

## Dependencies
* [ResizableRelativeLayout](https://github.com/DonBrody/Android-ResizableRelativeLayout)
* [ExpandableView](https://github.com/DonBrody/Android-ExpandableView)

## License
This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details
