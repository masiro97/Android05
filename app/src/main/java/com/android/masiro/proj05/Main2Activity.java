package com.android.masiro.proj05;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;


class Dataset{

    int spa =0;
    int piz =0;
    int mem = 0;
    int to =0;

    void getData(int spaghetti, int pizza, int member, int total){

        spa = spaghetti;
        piz = pizza;
        mem = member;
        to = total;

    }
}


public class Main2Activity extends AppCompatActivity {
    int index = 1;
    String[] LIST_MENU = {"Table 1 (empty)", "Table 2 (empty)", "Table 3 (empty)", "Table 4 (empty)"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Dataset D[] = new Dataset[4];

        for(int i =0; i <D.length;i++){
            D[i] = new Dataset();
            D[i].getData(0,0,0,0);
        }

        LIST_MENU[0] = "Table 1";

        Toast.makeText(getApplicationContext(),"List = " + LIST_MENU[0],Toast.LENGTH_SHORT).show();
    }
}
