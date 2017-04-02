package com.android.masiro.proj05;

import android.content.DialogInterface;
import android.support.annotation.IntegerRes;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button b1,b2,b3,b4,b5,b6,b7,b8;
    TextView t1,t2;
    EditText e1,e2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1 = (Button)findViewById(R.id.button);
        b2 = (Button)findViewById(R.id.button2);
        b3 = (Button)findViewById(R.id.button3);
        b4 = (Button)findViewById(R.id.button4);
        b5 = (Button)findViewById(R.id.button5);
        b6 = (Button)findViewById(R.id.button6);
        b7 = (Button)findViewById(R.id.button7);
        b8 = (Button)findViewById(R.id.button8);
        t1 = (TextView)findViewById(R.id.textView);
        t2 = (TextView)findViewById(R.id.textView2);
        e1 = (EditText)findViewById(R.id.editText);
        e2 = (EditText)findViewById(R.id.editText2);


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"일반 메시지 창입니다",Toast.LENGTH_SHORT).show();
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int x = Integer.parseInt(e1.getText().toString());
                int y = Integer.parseInt(e2.getText().toString());

                Toast toastView = Toast.makeText(getApplicationContext(),"위치 지정 메시지 창입니다",Toast.LENGTH_SHORT);

                toastView.setGravity(Gravity.LEFT | Gravity.TOP,x,y);

                toastView.show();
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View view = getLayoutInflater().inflate(R.layout.toastlayout,null);

                TextView text = (TextView)view.findViewById(R.id.textView3);
                text.setText("레이아웃으로 만든 토스트 창입니다");

                Toast toast = new Toast(getApplicationContext());
                toast.setDuration(Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER,0,100);
                toast.setView(view);
                toast.show();
            }
        });

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v,"Message",Snackbar.LENGTH_INDEFINITE).setAction("확인", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                }).show();
            }
        });

        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);

                dlg.setTitle("제목").setMessage("내용")
                        .setIcon(R.mipmap.ic_launcher).
                        setPositiveButton("닫기",null)
                        .setNegativeButton("확인", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Snackbar.make(v,"Message",Snackbar.LENGTH_SHORT).setAction("확인",null)
                                        .show();
                            }
                        }).show();
               // dlg.setTitle("제목");
                //dlg.setMessage("내용");

            }
        });

        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            final String data[] = {"치킨", "피자"};
                AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                dlg.setTitle("먹고싶은 메뉴는").setSingleChoiceItems(data, 1,null)
                        .setIcon(R.mipmap.ic_launcher)
                        .setPositiveButton("닫기",null)
                        .setNegativeButton("확인", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(getApplicationContext(),"확인을 눌렀습니다",Toast.LENGTH_SHORT).show();
                            }
                        })
                        .show();
            }
        });

        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String data[] = {"내용1", "내용2","내용3","내용4"};
                final boolean checked[] = {true, false,true,true};
                AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);

                dlg.setTitle("먹고싶은 메뉴는").setMultiChoiceItems(data, checked, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                        checked[which] = isChecked;
                    }
                })
                        .setIcon(R.mipmap.ic_launcher)
                        .setPositiveButton("닫기",null)
                        .setNegativeButton("확인", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                String print = "";
                                for(int i=0;i<data.length;i++){
                                    if(checked[i]) {
                                     print = print+"," +data[i];
                                    }
                                    }

                                Toast.makeText(getApplicationContext(),print +"을 눌렀습니다",Toast.LENGTH_SHORT).show();
                            }
                        })
                        .show();
            }
        });

        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View dlgview = getLayoutInflater().inflate(R.layout.toastlayout,null);
                final EditText edit = (EditText)dlgview.findViewById(R.id.editText3);
                AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);

                dlg.setTitle("먹고싶은 메뉴는")
                        .setView(dlgview)
                        .setIcon(R.mipmap.ic_launcher)
                        .setPositiveButton("닫기",null)
                        .setNegativeButton("확인", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(getApplicationContext(),edit.getText().toString() + "을 눌렀습니다",Toast.LENGTH_SHORT).show();
                            }
                        })
                        .show();

    }
});
    }
}
