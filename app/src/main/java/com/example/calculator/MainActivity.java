package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Switch;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    String divide,sqrRoot;
    EditText mainDisplay,mDisplay;
    AppCompatButton buttonAC,buttonCE;
    AppCompatButton buttonMC,buttonMR,buttonMminus,buttonMplus,buttonMU;
    AppCompatButton buttonSqrRoot,buttonPersent,buttonNegative,buttonDivide,buttonMultiple,buttonPlus,buttonMinus,buttonEqual,buttonDecimal;
    AppCompatButton button1,button2,button3,button4,button5,button6,button7,button8,button9,button0,button00;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainDisplay = findViewById(R.id.mainDisplay);
        mDisplay = findViewById(R.id.mDisplay);
        divide = getResources().getString(R.string.divide);
        sqrRoot = getResources().getString(R.string.srqroot);

        assignId(button1,R.id.button_1);
        assignId(button2,R.id.button_2);
        assignId(button3,R.id.button_3);
        assignId(button4,R.id.button_4);
        assignId(button5,R.id.button_5);
        assignId(button6,R.id.button_6);
        assignId(button7,R.id.button_7);
        assignId(button8,R.id.button_8);
        assignId(button9,R.id.button_9);
        assignId(button0,R.id.button_zero);
        assignId(button00,R.id.button_zerozero);
        assignId(buttonCE,R.id.button_ce);
        assignId(buttonAC,R.id.button_ac);
        assignId(buttonMC,R.id.button_mc);
        assignId(buttonMR,R.id.button_MR);
        assignId(buttonMminus,R.id.button_Mminus);
        assignId(buttonMplus,R.id.button_Mplus);
        assignId(buttonMU,R.id.button_MU);
        assignId(buttonSqrRoot,R.id.button_sqrroot);
        assignId(buttonMinus,R.id.button_minus);
        assignId(buttonPlus,R.id.button_plus);
        assignId(buttonMultiple,R.id.button_multiple);
        assignId(buttonDivide,R.id.button_divide);
        assignId(buttonEqual,R.id.button_equal);
        assignId(buttonPersent,R.id.button_percent);
        assignId(buttonNegative,R.id.button_not);
        assignId(buttonDecimal,R.id.button_decimal);

    }

    void assignId(AppCompatButton btn, int id)
    {
        btn = findViewById(id);
        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        AppCompatButton btn = (AppCompatButton) view;
        String btnText = btn.getText().toString();
        String dataToCalculate = mainDisplay.getText().toString();


        switch(btnText){

            case "AC": break;
            case "CE": break;
            case "MC": break;
            case "MR": break;
            case "M+": break;
            case "M-": break;
            case "MU": break;
            case "÷" : mainDisplay.setText(btnText);
                        break;
            case "%": break;
            case "-": break;
            case "+": break;
            case "×": mainDisplay.setText(btnText); break;
            case "=": break;
            case "+/-": break;
            case "√": break;
            case ".": break;
            case "1": break;
            case "2": break;
            case "3": break;
            case "4": break;
            case "5": break;
            case "6": break;
            case "7": break;
            case "8": break;
            case "9": break;
            case "0": break;
            case "00": break;

        }

    }
}