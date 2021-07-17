package com.example.android.andersen2_dop_vorona

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    private var mCount = 0

    companion object {
        val COUNT_EXTRA =
            "com.example.android.andersen2_dop_vorona.MainActivity.extra.Count"
        val SAVED_COUNT =
            "com.example.android.andersen2_dop_vorona.MainActivity.extra.SavedCount"
    }

    private lateinit var mShowCount: TextView
    private lateinit var mReset: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mShowCount = findViewById(R.id.show_count)
        mReset = findViewById(R.id.button_reset)

        mShowCount.text = mCount.toString()
        mShowCount.setOnClickListener {
            val i = Intent(this@MainActivity, ShowCountActivity::class.java)
            i.putExtra(COUNT_EXTRA, mCount)
            startActivity(i)
        }

        mReset.setOnClickListener {
            mCount = 0
            mShowCount.text = mCount.toString()
        }
    }


    fun countUp(view: View) {
        ++mCount
        mShowCount.text = mCount.toString()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(SAVED_COUNT, mCount)
    }

    override fun onRestoreInstanceState(savedState: Bundle) {
        mCount = savedState.getInt(SAVED_COUNT)
        mShowCount.text = mCount.toString()
    }
}