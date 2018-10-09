package com.geektech.navlesson.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.geektech.navlesson.R;

public class SectionCalculatorFragment extends Fragment {

    private TextView mMessageView;

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

    }

    //endregion
}