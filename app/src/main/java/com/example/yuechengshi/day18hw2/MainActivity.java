package com.example.yuechengshi.day18hw2;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    String display= "";
    String answer= "";
    int val1,val2;
    int input, solution;
    int count_total=0;
    int count_correct=0;
    double percent;







    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        val1 = generateNum();
        val2 = generateNum();
        display = val1 + "+" + val2 + "=";
        TextView txv10 = (TextView) findViewById(R.id.textView10);
        txv10.setText(display);

        //TextView txv11 = (TextView) findViewById(R.id.textView11);
        //txv11.setText(solution);



        new CountDownTimer(10000, 1000) {//for 10s, every 1s do something
            @Override
            public void onTick(long millisUntilFinished) {
                //Log.i("Testing CountDownTimer", "millisUnti");
                TextView txv2 = (TextView) findViewById(R.id.textView2);
                txv2.setText("seconds remaining: " + millisUntilFinished / 1000);
            }
            @Override
            public void onFinish() {
                //Log.i("Testing CountDownTimer", "Done");
                Toast.makeText(MainActivity.this, "Gameover", Toast.LENGTH_LONG).show();


            }
        }.start();




    }
    public void btnClick(View view) {
        TextView txv11 = (TextView) findViewById(R.id.textView11);

        String btnID = view.getResources().getResourceEntryName(view.getId());
        if (btnID.equals("zero")) {
            answer = answer + 0;
        }
        if (btnID.equals("one")) {
            answer = answer + 1;
        }
        if (btnID.equals("two")) {
            answer = answer + 2;
        }
        if (btnID.equals("three")) {
            answer = answer + 3;
        }
        if (btnID.equals("four")) {
            answer = answer + 4;
        }
        if (btnID.equals("five")) {
            answer = answer + 5;
        }
        if (btnID.equals("six")) {
            answer = answer + 6;
        }
        if (btnID.equals("seven")) {
            answer = answer + 7;
        }
        if (btnID.equals("eight")) {
            answer = answer + 8;
        }
        if (btnID.equals("nine")) {
            answer = answer + 9;
        }
        if (btnID.equals("back")) {
            answer = " ";
        }

        txv11.setText(answer);

        if (btnID.equals("enter")) {
            input = Integer.parseInt(answer);
            solution = val1+val2;



            if (input==solution) {
                Toast.makeText(MainActivity.this, "correct", Toast.LENGTH_LONG).show();
                count_total++;
                val1 = generateNum();
                val2 = generateNum();
                //return true;

            } else {
                Toast.makeText(MainActivity.this, "wrong", Toast.LENGTH_LONG).show();
                count_total++;
                //return false;
            }

        }


    }


    public int generateNum() {
        Random r = new Random();
        int num = r.nextInt((20 - 1) + 1) + 1;
        return num;
    }



}
