package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;

import java.text.DecimalFormat;
import java.util.Stack;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    String divide, sqrRoot;
    EditText mainDisplay, mDisplay;

    Stack opration = new Stack();
    String num1 = "", num2 = "", num3 = "";
    TextView oprations;
    AppCompatButton buttonAC, buttonCE;
    AppCompatButton buttonMC, buttonMR, buttonMminus, buttonMplus, buttonMU;
    AppCompatButton buttonSqrRoot, buttonPersent, buttonNegative, buttonDivide, buttonMultiple, buttonPlus, buttonMinus,
            buttonEqual, buttonDecimal;
    AppCompatButton button1, button2, button3, button4, button5, button6, button7, button8, button9, button0, button00;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DecimalFormat decimalFormat = new DecimalFormat("#.###");
        mainDisplay = findViewById(R.id.mainDisplay);
        mDisplay = findViewById(R.id.mDisplay);
        divide = getResources().getString(R.string.divide);
        sqrRoot = getResources().getString(R.string.srqroot);
        oprations = findViewById(R.id.opration);
        oprations.setVisibility(View.INVISIBLE);
        mDisplay.setText("00");
        clearScreen();
        assignId(button1, R.id.button_1);
        assignId(button2, R.id.button_2);
        assignId(button3, R.id.button_3);
        assignId(button4, R.id.button_4);
        assignId(button5, R.id.button_5);
        assignId(button6, R.id.button_6);
        assignId(button7, R.id.button_7);
        assignId(button8, R.id.button_8);
        assignId(button9, R.id.button_9);
        assignId(button0, R.id.button_zero);
        assignId(button00, R.id.button_zerozero);
        assignId(buttonCE, R.id.button_ce);
        assignId(buttonAC, R.id.button_ac);
        assignId(buttonMC, R.id.button_mc);
        assignId(buttonMR, R.id.button_MR);
        assignId(buttonMminus, R.id.button_Mminus);
        assignId(buttonMplus, R.id.button_Mplus);
        assignId(buttonMU, R.id.button_MU);
        assignId(buttonSqrRoot, R.id.button_sqrroot);
        assignId(buttonMinus, R.id.button_minus);
        assignId(buttonPlus, R.id.button_plus);
        assignId(buttonMultiple, R.id.button_multiple);
        assignId(buttonDivide, R.id.button_divide);
        assignId(buttonEqual, R.id.button_equal);
        assignId(buttonPersent, R.id.button_percent);
        assignId(buttonNegative, R.id.button_not);
        assignId(buttonDecimal, R.id.button_decimal);

    }

    void assignId(AppCompatButton btn, int id) {
        btn = findViewById(id);
        btn.setOnClickListener(this);
    }

    void clearScreen() {
        mainDisplay.setText("");
    }

    String evaluate(String data) {
        try {

            Context context = Context.enter();
            context.setOptimizationLevel(-1);
            Scriptable scriptable = context.initSafeStandardObjects();
            String finalResult = context.evaluateString(scriptable, data, "Javascript", 1, null).toString();
            return finalResult;
        } catch (Exception e) {
            return "Err";
        }

    }

    boolean calculate() {
        oprations.setVisibility(View.VISIBLE);
        if (opration.empty()) {
            this.num1 = mainDisplay.getText().toString();
            clearScreen();
            return true;
        } else {
            this.num2 = mainDisplay.getText().toString();
            num1 = num1 + opration.pop() + num2;
            num1 = evaluate(num1);
            Double d = Double.parseDouble(num1);
            if (d % 1 == 0) {
                mainDisplay.setText(String.format("%.0f", d));
            } else {
                mainDisplay.setText(String.format("%.4f", d));
            }

            return false;
        }
    }

    @Override
    public void onClick(View view) {
        AppCompatButton btn = (AppCompatButton) view;
        String btnText = btn.getText().toString();
        String dataToCalculate = mainDisplay.getText().toString();
        try {

            switch (btnText) {

                case "AC":
                    clearScreen();
                    num1 = "";
                    num2 = "";
                    num3="";
                    oprations.setText("");
                    opration.clear();
                    break;
                case "CE":
                    if (dataToCalculate.length() > 0)
                        mainDisplay.setText(dataToCalculate.substring(0, dataToCalculate.length() - 1));
                    break;
                case "MC":
                    num3="";
                    mDisplay.setText("");
                    break;
                case "MR":
                    mainDisplay.setText(mDisplay.getText().toString());
                    break;
                case "M+":
                    if (num3=="")
                    {num3= String.valueOf(0);}
                    num3 = "("+num3 + ")+(" + mainDisplay.getText().toString()+")";
                    mDisplay.setText(evaluate(num3));
                    break;
                case "M-":
                    if (num3=="")
                    {num3= String.valueOf(0);}
                    num3 = "("+num3 + ")-(" + mainDisplay.getText().toString()+")";
                    mDisplay.setText(evaluate(num3));
                    break;
                case "MS":
                    mDisplay.setText(mainDisplay.getText().toString());
                    break;
                case "÷":
                    if (calculate()) {
                        oprations.setText(btnText);
                        opration.push("/");
                    }
                    break;
                case "%":
                    if (calculate()) {

                        oprations.setText(btnText);
                        opration.push("/100*");
                    }
                    break;
                case "-":
                case "+":
                    if (calculate()) {

                        oprations.setText(btnText);
                        opration.push(btnText);
                    }
                    break;
                case "×":
                    if (calculate()) {
                        oprations.setText(btnText);
                        opration.push("*");
                    }
                    break;
                case "=":
                    // oprations.setVisibility(View.VISIBLE);
                    // if (opration.empty()) {
                    //     this.num1 = mainDisplay.getText().toString();
                    //     clearScreen();
                    //     oprations.setText(btnText);

                    // } else {
                    //     this.num2 = mainDisplay.getText().toString();
                    //     num2 = num1 + opration.peek() + num2;
                    //     num2 = evaluate(num2);
                    //     Double d = Double.parseDouble(num2);
                    //     if (d % 1 == 0) {
                    //         mainDisplay.setText(String.format("%.0f", d));
                    //     } else {
                    //         mainDisplay.setText(String.format("%.4f", d));
                    //     }

                    //     return;
                    // }
                    if (calculate()) {
                        oprations.setText(btnText);
                        opration.push(" ");
                    }
                    break;
                case "+/-": {
                    Double n = Double.parseDouble(dataToCalculate);
                    n = n * -1;
                    mainDisplay.setText(String.valueOf(n));
                }
                    break;
                case "√":
                    Double n = Double.valueOf(dataToCalculate);
                    n = Math.sqrt(n);
                    if (n % 1 == 0) {
                        mainDisplay.setText(String.format("%.0f", n));
                    } else {
                        mainDisplay.setText(String.format("%.4f", n));
                    }
                    break;
                case ".":
                case "00":
                case "1":
                case "2":
                case "3":
                case "4":
                case "5":
                case "6":
                case "7":
                case "8":
                case "9":
                case "0":
                    mainDisplay.setText(dataToCalculate + btnText);
                    break;

            }
        } catch (Exception e) {

        }
    }
}