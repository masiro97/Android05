package com.android.masiro.proj05;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by haeyoung on 2017-03-30. fragment
 */



public class fragment extends Fragment {
    TextView t;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View fragview = inflater.inflate(R.layout.fragment1,container,false);
        t = (TextView)fragview.findViewById(R.id.textView4);
        t.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        return fragview;

    }
}
