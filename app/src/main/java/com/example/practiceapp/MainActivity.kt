package com.example.practiceapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.TextView
import android.widget.Button

class MainActivity : AppCompatActivity() {

    // ============ VARIABLES ==============
    private var userInputNumber = ""
    private var userOperation = ""
    private var userFirstInput: Int? = null
    private var userSecondInput: Int? = null
    private var savedAnswer: Int? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        setTheme(R.style.AppTheme)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.mainRootActivity)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        // ============== SETTING EACH BUTTON FUNCTION ON CLICK ======================
        val textView = findViewById<TextView>(R.id.lblDisplay)
        findViewById<Button>(R.id.btnOne).setOnClickListener(){
            userInputNumber += "1"
            textView.text = userInputNumber
        }
        findViewById<Button>(R.id.btnTwo).setOnClickListener(){
            userInputNumber += "2"
            textView.text = userInputNumber
        }
        findViewById<Button>(R.id.btnThree).setOnClickListener(){
            userInputNumber += "3"
            textView.text = userInputNumber
        }
        findViewById<Button>(R.id.btnFour).setOnClickListener(){
            userInputNumber += "4"
            textView.text = userInputNumber
        }
        findViewById<Button>(R.id.btnFive).setOnClickListener(){
            userInputNumber += "5"
            textView.text = userInputNumber
        }
        findViewById<Button>(R.id.btnSix).setOnClickListener(){
            userInputNumber += "6"
            textView.text = userInputNumber
        }
        findViewById<Button>(R.id.btnSeven).setOnClickListener(){
            userInputNumber += "7"
            textView.text = userInputNumber
        }
        findViewById<Button>(R.id.btnEight).setOnClickListener(){
            userInputNumber += "8"
            textView.text = userInputNumber
        }
        findViewById<Button>(R.id.btnNine).setOnClickListener(){
            userInputNumber += "9"
            textView.text = userInputNumber
        }
        findViewById<Button>(R.id.btnZero).setOnClickListener(){
            userInputNumber += "0"
            textView.text = userInputNumber
        }
        findViewById<Button>(R.id.btnDelete).setOnClickListener(){
            textView.text = ""
            userInputNumber = ""
            userSecondInput = null
            userFirstInput = null
            savedAnswer = null
        }
        findViewById<Button>(R.id.btnDecimal).setOnClickListener(){
            if(!userInputNumber.contains('.')) {
                userInputNumber += "."
                textView.text = userInputNumber
            }
        }

        // ============== SETTING ADD BUTTON FUNCTION ON CLICK ======================
        findViewById<Button>(R.id.btnAdd).setOnClickListener(){
            if (userInputNumber.isNotEmpty()) {
                if (userFirstInput == null) {
                    userFirstInput = userInputNumber.toInt()
                } else {
                    userSecondInput = userInputNumber.toInt()
                    savedAnswer = userFirstInput?.plus(userSecondInput!!)
                    userFirstInput = savedAnswer
                }
            }


            if (savedAnswer != null) {
                textView.text = savedAnswer.toString()
            }

            userInputNumber = ""
            userOperation = "+"
        }
        // ============== SETTING SUBTRACT BUTTON FUNCTION ON CLICK ======================
        findViewById<Button>(R.id.btnSub).setOnClickListener(){
            if (userInputNumber.isNotEmpty()) {
                if (userFirstInput == null) {
                    userFirstInput = userInputNumber.toInt()
                } else {
                    userSecondInput = userInputNumber.toInt()
                    savedAnswer = userFirstInput?.minus(userSecondInput!!)
                    userFirstInput = savedAnswer
                }
            }


            if (savedAnswer != null) {
                textView.text = savedAnswer.toString()
            }

            userInputNumber = ""
            userOperation = "-"
        }
        // ============== SETTING MULTIPLY BUTTON FUNCTION ON CLICK ======================
        findViewById<Button>(R.id.btnMult).setOnClickListener(){
            if (userInputNumber.isNotEmpty()) {
                if (userFirstInput == null) {
                    userFirstInput = userInputNumber.toInt()
                } else {
                    userSecondInput = userInputNumber.toInt()
                    savedAnswer = userFirstInput?.times(userSecondInput!!)
                    userFirstInput = savedAnswer
                }
            }


            if (savedAnswer != null) {
                textView.text = savedAnswer.toString()
            }

            userInputNumber = ""
            userOperation = "*"
        }
        // ============== SETTING DIVIDE BUTTON FUNCTION ON CLICK ======================
        findViewById<Button>(R.id.btnDiv).setOnClickListener(){
            if (userInputNumber.isNotEmpty()) {
                if (userFirstInput == null) {
                    userFirstInput = userInputNumber.toInt()
                } else {
                    userSecondInput = userInputNumber.toInt()
                    if (userSecondInput != 0) savedAnswer = userFirstInput?.div(userSecondInput!!)
                    userFirstInput = savedAnswer
                }
            }


            if (savedAnswer != null) {
                textView.text = savedAnswer.toString()
            }

            userInputNumber = ""
            userOperation = "/"
        }
        // ============== SETTING EQUALS BUTTON FUNCTION ON CLICK ======================
        findViewById<Button>(R.id.btnEquals).setOnClickListener(){

            // ============== EQUAL FUNCTION FOR IF USER PRESSED PLUS ======================
            if (userOperation == "+" && userInputNumber.isNotEmpty()) {
                userSecondInput = userInputNumber.toInt()
                if (savedAnswer == null) {
                    savedAnswer = userFirstInput?.plus(userSecondInput!!)
                } else {
                    savedAnswer = savedAnswer?.plus(userSecondInput!!)
                }
                userFirstInput = savedAnswer
                userInputNumber = ""
                textView.text = savedAnswer.toString()

                // ============== EQUAL FUNCTION FOR IF USER PRESSED MINUS ======================
            }else if (userOperation == "-" && userInputNumber.isNotEmpty()) {
                userSecondInput = userInputNumber.toInt()
                if (savedAnswer == null) {
                    savedAnswer = userFirstInput?.minus(userSecondInput!!)
                } else {
                    savedAnswer = savedAnswer?.minus(userSecondInput!!)
                }
                userFirstInput = savedAnswer
                userInputNumber = ""
                textView.text = savedAnswer.toString()

                // ============== EQUAL FUNCTION FOR IF USER PRESSED MULTIPLY ======================
            }else if (userOperation == "*" && userInputNumber.isNotEmpty()) {
                userSecondInput = userInputNumber.toInt()
                if (savedAnswer == null) {
                    savedAnswer = userFirstInput?.times(userSecondInput!!)
                } else {
                    savedAnswer = savedAnswer?.times(userSecondInput!!)
                }
                userFirstInput = savedAnswer
                userInputNumber = ""
                textView.text = savedAnswer.toString()

                // ============== EQUAL FUNCTION FOR IF USER PRESSED DIVIDE ======================
            }else if (userOperation == "/" && userInputNumber.isNotEmpty()) {
                userSecondInput = userInputNumber.toInt()
                if (savedAnswer == null) {
                    if (userSecondInput != 0) savedAnswer = userFirstInput?.div(userSecondInput!!)
                } else {
                    if (userSecondInput != 0) savedAnswer = userFirstInput?.div(userSecondInput!!)
                }
                userFirstInput = savedAnswer
                userInputNumber = ""
                textView.text = savedAnswer.toString()
            }
        }



    }
}
