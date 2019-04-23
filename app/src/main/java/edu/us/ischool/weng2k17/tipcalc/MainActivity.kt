package edu.us.ischool.weng2k17.tipcalc

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button.isClickable = false

        button.setOnClickListener {
            val amount = "%.2f".format(1.15 * editText.text.toString().toDouble())
            Toast.makeText(this, "$" + amount, Toast.LENGTH_LONG).show()
        }

        editText.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable) {
                if(s.toString().trim().length == 0){
                    button.isClickable = false
                } else {
                    button.isClickable = true
                    textView.setText("$" + s)
                }

            }

            override fun beforeTextChanged(s: CharSequence, start: Int,
                                           count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence, start: Int,
                                       before: Int, count: Int) {

            }
        })
    }
}
