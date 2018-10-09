package com.geektech.navlesson.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;

public class SectionWithElementsFragment extends Fragment {
    //region Static

    private static String MESSAGE_KEY = "message_key";

    public static Fragment getInstance(String message){
        Fragment fragment = new SectionFragment();

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
}
