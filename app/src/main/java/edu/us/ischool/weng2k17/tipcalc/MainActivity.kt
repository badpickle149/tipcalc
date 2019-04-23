package edu.us.ischool.weng2k17.tipcalc

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.text.NumberFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    public inline fun String.toDouble(): Double = java.lang.Double.parseDouble(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var button = findViewById<Button>(R.id.button)

        button.isClickable = false

        var textEdit = findViewById<EditText>(R.id.editText)

        button.setOnClickListener {
            val num = textEdit.text.substring(1, textEdit.text.length).replace(",","").toDouble()
            val amount = "%.2f".format(1.15 * num)
            Toast.makeText(this, "$" + amount, Toast.LENGTH_LONG).show()
        }

        textEdit.setOnEditorActionListener { v, actionId, event ->
            if(actionId == EditorInfo.IME_ACTION_SEARCH) {
                val textEditLength = textEdit.text.length
                if (textEditLength > 0) {
                    button.isClickable = true
                    val text = textEdit.text.toString().toDouble()
                    val format = NumberFormat.getCurrencyInstance(Locale.US)
                    textEdit.setText(format.format(text))
                    true
                } else {
                    button.isClickable = false
                }
            }
            false
        }
        /*
        textEdit.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable) {

            }

            override fun beforeTextChanged(s: CharSequence, start: Int,
                                           count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence, start: Int,
                                       before: Int, count: Int) {
                if (getCurrentFocus() == textEdit) {
                    // is only executed if the EditText was directly changed by the user
                    if(s.toString().trim().length == 0){
                        button.isClickable = false
                    } else {
                        button.isClickable = true
                        textEdit.clearFocus()
                        editText.setText("$" + s)
                    }
                }

            }
        })
        */
    }
}
