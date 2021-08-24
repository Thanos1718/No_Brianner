package com.example.nobrianner;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.gridlayout.widget.GridLayout;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Button goButton;
    Button a;
    Button b;
    int count;
    int maxCount;
    Button c;
    Button d;
    TextView textView;
    TextView textView2;
    TextView textview5;
    TextView textView4;
    CountDownTimer countDownTimer;
    GridLayout gridLayout;
    public void Go(View view)
    {
        textView=findViewById(R.id.textView);
        textView2=findViewById(R.id.textView2);
     goButton.setVisibility(View.INVISIBLE);
     gridLayout.setVisibility(View.VISIBLE);
        textView4.setVisibility(View.VISIBLE);
        textview5.setVisibility(View.VISIBLE);
     countDownTimer=new CountDownTimer(100000,1000) {
         @Override
       public void onTick(long millisUntilFinished) {
             NumberFormat f = new DecimalFormat("00");
            textView.setText(f.format(millisUntilFinished/1000));
         }

         @SuppressLint("SetTextI18n")
         @Override
         public void onFinish() {
             textView.setText(R.string.name_1);
            gridLayout.setVisibility(View.INVISIBLE);
            goButton.setVisibility(View.VISIBLE);
            textView2.setText("0/0");
            textView4.setVisibility(View.INVISIBLE);
            textview5.setText("Score:"+ count +"/"+ maxCount);
             count=0;
             maxCount=0;

         }
     }.start();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        goButton=findViewById(R.id.button);
        gridLayout= findViewById(R.id.gridLayout);
        gridLayout.setVisibility(View.INVISIBLE);
        textview5=findViewById(R.id.textView5);
        textView4=findViewById(R.id.textView4);
        textView4.setVisibility(View.INVISIBLE);
        textview5.setVisibility(View.INVISIBLE);
        maxCount=0;
        count=0;
    }

    @SuppressLint("SetTextI18n")
    public void setText(View view) {
        String t;
        a=findViewById(R.id.button11);
        b=findViewById(R.id.button12);
        c=findViewById(R.id.button16);
        d=findViewById(R.id.button15);
        textView2=findViewById(R.id.textView2);
        String ans=textView4.getText().toString();
        String first="";
        String second="";
        int i=0;
        while(ans.charAt(i)!='+')
        {
            first=first.concat(String.valueOf(ans.charAt(i)));
            i++;
        }
        i++;
        while(i<ans.length())
        {
            second=second.concat(String.valueOf(ans.charAt(i)));
            i++;
        }
        int ans1=Integer.parseInt(first)+Integer.parseInt(second);
        String tag2=view.getTag().toString();
        maxCount++;
        switch(tag2)
        {
            case "A":
                t=a.getText().toString();
                if(t.equals(Integer.toString(ans1))) {
                    textview5.setText("Congrats");
                    count++;
                    textView2.setText(count +"/"+ maxCount);
                }
                else {
                    textView2.setText(count + "/" + maxCount);
                    textview5.setText("Wrong Answer");
                }
                break;
            case "B":
                t=b.getText().toString();
                if(t.equals(Integer.toString(ans1))) {

                    textview5.setText("Congrats");
                    count++;
                    textView2.setText(count +"/"+ maxCount);
                }
                else {
                    textView2.setText(count + "/" + maxCount);
                    textview5.setText("Wrong Answer");
                }
                break;
            case "C":
                t=c.getText().toString();
                if(t.equals(Integer.toString(ans1))) {
                    textview5.setText("Congrats");
                    count++;
                    textView2.setText(count +"/"+ maxCount);
                }
                else {
                    textView2.setText(count + "/" + maxCount);
                    textview5.setText("Wrong Answer");
                }
                break;
            case "D":
                t=d.getText().toString();
                if(t.equals(Integer.toString(ans1))) {
                    textview5.setText("Congrats");
                    count++;
                    textView2.setText(count +"/"+ maxCount);
                }
                else {
                    textView2.setText(count + "/" + maxCount);
                    textview5.setText("Wrong Answer");
                }
                break;
        }

        Random random=new Random();
        int num1=random.nextInt(125);
        int num2=random.nextInt(112);
        textView4.setText(num1 +"+"+ num2);
        int x=num1+num2;
        int r=(num1)%10+num2%5;
        int select=random.nextInt(4);
        String ab = Integer.toString(x + r + x % 3 - r % 2 + r %2 );
        switch (select)
        {
            case 0:
                a.setText(Integer.toString(x));
                b.setText(Integer.toString(x+r));
                c.setText(ab);
                d.setText(Integer.toString(x-r));
                break;
            case 1:
                b.setText(Integer.toString(x));
                a.setText(Integer.toString(x+r));
                c.setText(ab);
                d.setText(Integer.toString(x-r));
                break;
            case 2:
                c.setText(Integer.toString(x));
                a.setText(Integer.toString(x+r));
                b.setText(ab);
                d.setText(Integer.toString(x-r));
                break;
            case 3:
                d.setText(Integer.toString(x));
                c.setText(Integer.toString(x+r));
                b.setText(ab);
                a.setText(Integer.toString(x-r));
                break;
        }


    }
}