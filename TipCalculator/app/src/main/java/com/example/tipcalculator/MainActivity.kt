package com.example.tipcalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import androidx.core.widget.doOnTextChanged

class MainActivity : AppCompatActivity() {

    var billEditText: EditText? = null
    var tipPercentEditText: EditText? = null
    var tipAmountTextView: TextView? = null
    var totalAmountTextView: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        billEditText = findViewById(R.id.billEditText)
        tipPercentEditText = findViewById(R.id.tipPercentEditText)
        tipAmountTextView = findViewById(R.id.tipAmountTextView)
        totalAmountTextView = findViewById(R.id.totalAmountTextView)

        setupViews()
    }

    private fun setupViews() {
        billEditText?.apply {
            doOnTextChanged { text, _, _, _ ->
                if (text.isNullOrEmpty()) {
                    return@doOnTextChanged
                }
                val tipPercent = tipPercentEditText?.text?.toInt() ?: 15
                updateViews(text.toInt(), tipPercent)
            }
        }
        tipPercentEditText?.apply {
            doOnTextChanged { tipPercentText, _, _, _ ->
                if (tipPercentText.isNullOrEmpty()) {
                    return@doOnTextChanged
                }
                val bill = billEditText?.text?.toInt() ?: 0
                updateViews(bill, tipPercentText.toInt())
            }
        }
    }

    /**
     * Method to update Tip and Total amount [TextView]'s
     */
    private fun updateViews(bill: Int, tipPercent: Int = 15) {
        val tipAmount = (bill * tipPercent) / 100
        val totalAmount = bill + tipAmount

        tipAmountTextView?.text = tipAmount.toString()
        totalAmountTextView?.text = totalAmount.toString()
    }

    /** Utility method to convert [CharSequence] to [Integer]. */
    private fun CharSequence.toInt() = Integer.parseInt(this.toString())
}