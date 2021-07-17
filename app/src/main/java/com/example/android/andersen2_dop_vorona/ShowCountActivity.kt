package com.example.android.andersen2_dop_vorona

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class ShowCountActivity : AppCompatActivity() {
    private lateinit var mShowCount: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_count)
        mShowCount = findViewById(R.id.show_count)
        val data = intent.getIntExtra(MainActivity.COUNT_EXTRA, 0)
        mShowCount.text = data.toString()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putCharSequence(MainActivity.SAVED_COUNT, mShowCount.text)
    }

    override fun onRestoreInstanceState(savedState: Bundle) {
        val count = savedState.getCharSequence(MainActivity.SAVED_COUNT)
        mShowCount.text = count
    }
}