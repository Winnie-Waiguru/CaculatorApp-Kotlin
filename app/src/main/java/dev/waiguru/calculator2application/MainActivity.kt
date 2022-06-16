package dev.waiguru.calculator2application

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {
    lateinit var tilFirstNumber:TextInputLayout
    lateinit var etFirstNumber:TextInputEditText
    lateinit var tilSecondNumber:TextInputLayout
    lateinit var etSecondNumber:TextInputEditText
    lateinit var btnAdd:Button
    lateinit var btnSubtract: Button
    lateinit var btnModulus:Button
    lateinit var btnDivision:Button
    lateinit var tvResults:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
       tilFirstNumber=findViewById(R.id.tilFirstNumber)
       etFirstNumber=findViewById(R.id.etFirstNumber)
        tilSecondNumber=findViewById(R.id.tilSecondNumber)
        etSecondNumber=findViewById(R.id.etSecondNumber)
        btnAdd=findViewById(R.id.btnAdd)
        btnSubtract=findViewById(R.id.btnSubtract)
        btnModulus=findViewById(R.id.btnModulus)
        btnDivision=findViewById(R.id.btnDivision)
        tvResults=findViewById(R.id.tvResults)

        btnAdd.setOnClickListener {
            val inputs=obtainInputs()
            addition(inputs!!.num1, inputs!!.num2)
        }

        btnSubtract.setOnClickListener {
            val inputs= obtainInputs()
            subtraction(inputs!!.num1, inputs.num2)
        }

        btnModulus.setOnClickListener {
            val inputs=obtainInputs()
            modulation(inputs!!.num1, inputs!!.num2)
        }

        btnDivision.setOnClickListener {
            val inputs=obtainInputs()
            division(inputs!!.num1, inputs!!.num2)

        }

    }

    data class Inputs(var num1:Double,var num2:Double)
    fun obtainInputs():Inputs? {
        val num1 = etFirstNumber.text.toString()
        val num2 = etSecondNumber.text.toString()

        if (num1.isBlank()) {
            tilFirstNumber.error = "Input required"
            return null
        }
        if (num2.isBlank()) {
            tilSecondNumber.error = "Input required"
            return null
        }
     return Inputs(num1.toDouble(),num2.toDouble())
    }

    fun addition(num1: Double,num2: Double){
        var add= num1 + num2
        tvResults.text=add.toString()

    }
    fun subtraction(num1: Double,num2: Double){
        var subtract= num1- num2
        tvResults.text=subtract.toString()
    }

    fun division(num1: Double,num2: Double){
        var divide= num1 / num2
        tvResults.text=divide.toString()
    }

    fun modulation(num1: Double, num2: Double){
        var modulus= num1 % num2
        tvResults.text= modulus.toString()
    }
}