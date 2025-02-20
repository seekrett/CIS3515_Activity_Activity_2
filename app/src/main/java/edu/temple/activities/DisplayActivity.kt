package edu.temple.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts

// KEYS
const val FONTSIZE_KEY = "font size"

class DisplayActivity : AppCompatActivity() {

    // TODO Step 1: Launch TextSizeActivity when button clicked to allow selection of text size value
    // launches another activity with the intention to receive results, processing takes place here
    val launcher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
        if (it.resultCode == RESULT_OK) {
            //     v check if data exists
            it.data?.apply {
                //                                v requesting information
                lyricsDisplayTextView.textSize = getIntExtra(FONTSIZE_KEY, 22).toFloat()
            }
        }
    }

    // TODO Step 3: Use returned value for lyricsDisplayTextView text size

    private lateinit var lyricsDisplayTextView: TextView
    private lateinit var textSizeSelectorButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display)

        lyricsDisplayTextView = findViewById(R.id.lyricsDisplayTextView)
        textSizeSelectorButton = findViewById(R.id.textSizeSelectorButton)

        // launch second activity
        textSizeSelectorButton.setOnClickListener {
            launcher.launch(Intent(this, TextSizeActivity::class.java))
        }

    }
}