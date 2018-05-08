package net.noahglaser.timetablekotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.SeekBar
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sb_multiple_by.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                setTimesTable(progress + 1)
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {

            }
        })
        setTimesTable(1)
    }

    /**
     * Sets the times table list view
     */
    private fun setTimesTable(multipleBy: Int) {
        val timesTable = (1..20).map { it * multipleBy }.map { it.toString() }
        lv_timestable.adapter = ArrayAdapter(
                applicationContext,
                android.R.layout.simple_list_item_1,
                timesTable
        )
    }
}
