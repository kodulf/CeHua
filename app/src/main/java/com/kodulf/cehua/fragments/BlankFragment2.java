package com.kodulf.cehua.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.kodulf.cehua.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment2 extends Fragment {

    public BlankFragment2() {
        // Required empty public constructor
    }

    public static BlankFragment2 newInstance(String text){
        Bundle args = new Bundle();
        BlankFragment2 blankFragment2 = new BlankFragment2();
        args.putString("text", text);
        blankFragment2.setArguments(args);
        Log.d("151228MY", "BlankFragment postion" + text);
        return  blankFragment2;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_blank_fragment2, container, false);

    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView text =(TextView)view.findViewById(R.id.fragment2_textView);
        String s = getArguments().getString("text");
        text.setText("HELLO"+s);
    }
}
