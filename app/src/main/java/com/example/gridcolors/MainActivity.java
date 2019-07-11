package com.example.gridcolors;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static android.content.ContentValues.TAG;

public class MainActivity extends Activity
{
    Button s1, s2, s3, s4, s5, s6, s7, s8, s9, s10,
            s11, s12, s13, s14, s15, s16, s17, s18, s19, s20;

    @Override
    protected void onCreate(Bundle b)
    {
        super.onCreate(b);
        setContentView(R.layout.activity_main);

        final int green = getResources().getColor(R.color.sGreen);
        final int blue = getResources().getColor(R.color.sBlue);
        final int purple = getResources().getColor(R.color.sPurple);
        final int orange = getResources().getColor(R.color.sOrange);
        final int lightGreen = getResources().getColor(R.color.sLightGreen);
        final int yellow = getResources().getColor(R.color.sYellow);
        final int pink = getResources().getColor(R.color.sPink);
        int black = getResources().getColor(R.color.sBlack);

        final int[] colors = new int[]{green, blue, purple, orange,
                lightGreen, yellow, pink};
        int[] times = new int[]{500, 700, 700};

        s1 = findViewById(R.id.square1);
        s2 = findViewById(R.id.square2);
        s3 = findViewById(R.id.square3);
        s4 = findViewById(R.id.square4);
        s5 = findViewById(R.id.square5);
        s6 = findViewById(R.id.square6);
        s7 = findViewById(R.id.square7);
        s8 = findViewById(R.id.square8);
        s9 = findViewById(R.id.square9);
        s10 = findViewById(R.id.square10);
        s11 = findViewById(R.id.square11);
        s12 = findViewById(R.id.square12);
        s13 = findViewById(R.id.square13);
        s14 = findViewById(R.id.square14);
        s15 = findViewById(R.id.square15);
        s16 = findViewById(R.id.square16);
        s17 = findViewById(R.id.square17);
        s18 = findViewById(R.id.square18);
        s19 = findViewById(R.id.square19);
        s20 = findViewById(R.id.square20);

        ChangeColors button1 = new ChangeColors(s1, colors, times);
        button1.start();
        ChangeColors button2 = new ChangeColors(s2, colors, times);
        button2.start();
        ChangeColors button3 = new ChangeColors(s3, colors, times);
        button3.start();
        ChangeColors button4 = new ChangeColors(s4, colors, times);
        button4.start();
        ChangeColors button5 = new ChangeColors(s5, colors, times);
        button5.start();
        ChangeColors button6 = new ChangeColors(s6, colors, times);
        button6.start();
        ChangeColors button7 = new ChangeColors(s7, colors, times);
        button7.start();
        ChangeColors button8 = new ChangeColors(s8, colors, times);
        button8.start();
        ChangeColors button9 = new ChangeColors(s9, colors, times);
        button9.start();
        ChangeColors button10 = new ChangeColors(s10, colors, times);
        button10.start();
        ChangeColors button11 = new ChangeColors(s11, colors, times);
        button11.start();
        ChangeColors button12 = new ChangeColors(s12, colors, times);
        button12.start();
        ChangeColors button13 = new ChangeColors(s13, colors, times);
        button13.start();
        ChangeColors button14 = new ChangeColors(s14, colors, times);
        button14.start();
        ChangeColors button15 = new ChangeColors(s15, colors, times);
        button15.start();
        ChangeColors button16 = new ChangeColors(s16, colors, times);
        button16.start();
        ChangeColors button17 = new ChangeColors(s17, colors, times);
        button17.start();
        ChangeColors button18 = new ChangeColors(s18, colors, times);
        button18.start();
        ChangeColors button19 = new ChangeColors(s19, colors, times);
        button19.start();
        ChangeColors button20 = new ChangeColors(s20, colors, times);
        button20.start();

        ArrayList<ChangeColors> threadList = new ArrayList<>();
        threadList.add(button1);
        threadList.add(button2);

        ArrayList<Button> squares = new ArrayList<>();
        squares.add(s1);



        /*for(int i = 0; i < squares.size(); i++)
        {
            squares.get(i).setOnClickListener( v -> squares.get(i).setText("hello)"));
        }*/



    }

    class ChangeColors extends Thread
    {
        int[] theColor;
        int[] theTimes;
        Button button;
        Random random = new Random();
        int count = 0;

        ChangeColors(Button b, int[] color, int[] times)
        {
            button = b;
            theColor = color;
            theTimes = times;
        }

        @Override
        public void run()
        {
            while (count >= 0)
            {
                try
                {
                    Thread.sleep(theTimes[random.nextInt(theTimes.length)]);
                    runOnUiThread(new Runnable()
                    {
                        @Override
                        public void run()
                        {
                            button.setBackgroundColor(theColor[random.nextInt(theColor.length)]);
                        }
                    });
                } catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
            }
        }
    }
}
