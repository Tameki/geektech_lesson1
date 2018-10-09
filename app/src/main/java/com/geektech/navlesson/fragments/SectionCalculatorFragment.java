package com.geektech.navlesson.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.geektech.navlesson.R;

import java.text.DecimalFormat;

public class SectionCalculatorFragment extends Fragment {

    private TextView mMessageView;
    private TextView infoTextView;
    private Button buttonDot;
    private Button buttonZero;
    private Button buttonOne;
    private Button buttonTwo;
    private Button buttonThree;
    private Button buttonFour;
    private Button buttonFive;
    private Button buttonSix;
    private Button buttonSeven;
    private Button buttonEight;
    private Button buttonNine;
    private Button buttonAdd;
    private Button buttonSubstract;
    private Button buttonMultiply;
    private Button buttonDivide;
    private Button buttonEqual;
    private Button buttonClear;
    private EditText editText;

    private static final char ADDITION = '+';
    private static final char SUBTRACTION = '-';
    private static final char MULTIPLICATION = '*';
    private static final char DIVISION = '/';

    private char CURRENT_ACTION;

    private double valueOne = Double.NaN;
    private double valueTwo;

    private DecimalFormat decimalFormat;

    //region Static

    private static String MESSAGE_KEY = "message_key";

    public static Fragment getInstance(String message){
        Fragment fragment = new SectionCalculatorFragment();

        fragment.setArguments(getBundle(message));

        return fragment;
    }

    public static Bundle getBundle(String message){
        Bundle args = new Bundle();
        args.putString(MESSAGE_KEY, message);
        return args;
    }

    public static String getMessage(Bundle args){
        String message = "Empty";

        try {
            message = args.getString(MESSAGE_KEY);
        } catch (Exception e){
            Log.e("ololo", e.getMessage(), e);
        }

        return message;
    }

    //endregion

    //region Lifecycle

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(
                R.layout.fragment_calculator_section,
                container,
                false
        );

        init(rootView);

        return rootView;
    }

    //endregion

    //region Private

    private void init(View rootView){

        decimalFormat = new DecimalFormat("#.##########");

        buttonDot = rootView.findViewById(R.id.buttonDot);
        buttonZero = rootView.findViewById(R.id.buttonZero);
        buttonOne = rootView.findViewById(R.id.buttonOne);
        buttonTwo = rootView.findViewById(R.id.buttonTwo);
        buttonThree = rootView.findViewById(R.id.buttonThree);
        buttonFour = rootView.findViewById(R.id.buttonFour);
        buttonFive = rootView.findViewById(R.id.buttonFive);
        buttonSix = rootView.findViewById(R.id.buttonSix);
        buttonSeven = rootView.findViewById(R.id.buttonSeven);
        buttonEight = rootView.findViewById(R.id.buttonEight);
        buttonNine = rootView.findViewById(R.id.buttonNine);
        buttonAdd = rootView.findViewById(R.id.buttonAdd);
        buttonSubstract = rootView.findViewById(R.id.buttonSubtract);
        buttonMultiply = rootView.findViewById(R.id.buttonMultiply);
        buttonDivide = rootView.findViewById(R.id.buttonDivide);
        buttonEqual = rootView.findViewById(R.id.buttonEqual);
        buttonClear = rootView.findViewById(R.id.buttonClear);
        infoTextView = rootView.findViewById(R.id.infoTextView);
        editText = rootView.findViewById(R.id.editText);

        buttonDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(editText.getText() + ".");
            }
        });

        buttonOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(editText.getText() + "1");
            }
        });

        buttonTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(editText.getText() + "2");
            }
        });

        buttonThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(editText.getText() + "3");
            }
        });

        buttonFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(editText.getText() + "4");
            }
        });

        buttonFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(editText.getText() + "5");
            }
        });

        buttonSix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(editText.getText() + "6");
            }
        });

        buttonSeven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(editText.getText() + "7");
            }
        });

        buttonEight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(editText.getText() + "8");
            }
        });

        buttonNine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(editText.getText() + "9");
            }
        });

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                computeCalculation();
                CURRENT_ACTION = ADDITION;
                infoTextView.setText(decimalFormat.format(valueOne + "+"));
                editText.setText(null);
            }
        });

        buttonSubstract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                computeCalculation();
                CURRENT_ACTION = SUBTRACTION;
                infoTextView.setText(decimalFormat.format(valueOne + "-"));
                editText.setText(null);
            }
        });

        buttonMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                computeCalculation();
                CURRENT_ACTION = MULTIPLICATION;
                infoTextView.setText(decimalFormat.format(valueOne + "*"));
                editText.setText(null);
            }
        });

        buttonDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                computeCalculation();
                CURRENT_ACTION = DIVISION;
                infoTextView.setText(decimalFormat.format(valueOne + "/"));
                editText.setText(null);
            }
        });

        buttonEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                computeCalculation();
                infoTextView.setText(infoTextView.getText().toString() +
                        decimalFormat.format(valueTwo) + " = " + decimalFormat.format(valueOne));
                valueOne = Double.NaN;
                CURRENT_ACTION = '0';
                setDataToFragment(infoTextView.getText().toString());
            }
        });

        buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(editText.getText().length() > 0) {
                    CharSequence currentText = editText.getText();
                    editText.setText(currentText.subSequence(0, currentText.length()-1));
                }
                else {
                    valueOne = Double.NaN;
                    valueTwo = Double.NaN;
                    editText.setText("");
                    infoTextView.setText("");
                }

            }
        });
    }

    private void computeCalculation() {
        if(!Double.isNaN(valueOne)) {
            valueTwo = Double.parseDouble(editText.getText().toString());
            editText.setText(null);

            if(CURRENT_ACTION == ADDITION)
                valueOne = this.valueOne + valueTwo;
            else if(CURRENT_ACTION == SUBTRACTION)
                valueOne = this.valueOne - valueTwo;
            else if(CURRENT_ACTION == MULTIPLICATION)
                valueOne = this.valueOne * valueTwo;
            else if(CURRENT_ACTION == DIVISION)
                valueOne = this.valueOne / valueTwo;
        }
        else {
            try {
                valueOne = Double.parseDouble(editText.getText().toString());
            }
            catch (Exception e){}
        }
    }

    private void setDataToFragment(String message) {
        Fragment fragB = SectionFragment.getInstance(message);
    }

    //endregion
}
