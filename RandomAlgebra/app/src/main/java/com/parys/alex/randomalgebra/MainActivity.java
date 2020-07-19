package com.parys.alex.randomalgebra;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Random;


public class MainActivity extends AppCompatActivity {
    randomNumberGen num = new randomNumberGen();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.algebra);

    }

    public void RandomNumber(View view){
        num.setRandom1(getRandomNumber(10));
        num.setRandom2(getRandomNumber(10));
        String Random1 = Integer.toString(num.getRandom1());
        TextView randomOne = (TextView) findViewById(R.id.textView);
        randomOne.setText(Random1);

        String Random2 = Integer.toString(num.getRandom2());
        TextView randomTwo = findViewById(R.id.textView2);
        randomTwo.setText(Random2);
    }

    public static int getRandomNumber(int maxNum)
    {
        Random ran = new Random();
        //This will get a number between 0 and maxNum minus 1 (i.e. if maxNum is 3 the results could be 0,1,2)
        //We can add one to answer to return a more readable number
        return ran.nextInt(maxNum) + 1;
    }

    public void addUp(View view){
        int random1 = num.getRandom1();
        int random2 = num.getRandom2();
        int finalAnswer = random1 + random2;
        String finalAnswerString = Integer.toString(finalAnswer);
        TextView answerBox = findViewById(R.id.textView4);
        answerBox.setText(finalAnswerString);
    }

}
