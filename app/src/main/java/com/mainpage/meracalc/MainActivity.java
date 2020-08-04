package com.mainpage.meracalc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
{
    EditText ed1 ;
    EditText ed2 ;

    public List<String> arr = new ArrayList<>();
    public String st = "",str = "";

    public void btn_0(View view)
    {
        st = st + "0";
        ed1.setText(st);
    }
    public void btn_1(View view)
    {
        st = st + "1";
        ed1.setText(st);
    }
    public void btn_2(View view)
    {
        st = st + "2";
        ed1.setText(st);
    }
    public void btn_3(View view)
    {
        st = st + "3";
        ed1.setText(st);
    }
    public void btn_4(View view)
    {
        st = st + "4";
        ed1.setText(st);
    }
    public void btn_5(View view)
    {
        st = st + "5";
        ed1.setText(st);
    }
    public void btn_6(View view)
    {
        st = st + "6";
        ed1.setText(st);
    }
    public void btn_7(View view)
    {
        st = st + "7";
        ed1.setText(st);
    }
    public void btn_8(View view)
    {
        st = st + "8";
        ed1.setText(st);
    }
    public void btn_9(View view)
    {
        st = st + "9";
        ed1.setText(st);
    }
    public void btn_add(View view)
    {
        st = st + "+";
        ed1.setText(st);
    }
    public void btn_sub(View view)
    {
        st = st + "-";
        ed1.setText(st);
    }
    public void btn_mult(View view)
    {
        st = st + "x";
        ed1.setText(st);
    }
    public void btn_div(View view)
    {
        st = st + "%";
        ed1.setText(st);
    }
    public void btn_per(View view)
    {
        st = st + "%";
        ed1.setText(st);
    }
    public void btn_dec(View view)
    {
        st = st + ".";
        ed1.setText(st);
    }
    public void btn_clear(View view)
    {
        ed1.setText("");
        ed2.setText("");
        st = "";
    }

    public void Result(View view)
    {
        String ques = ed1.getText().toString();
        double num1,num2;
        for(int i=0;i<ques.length();i++)
        {
            if(ques.charAt(i)=='+' || ques.charAt(i)=='-' || ques.charAt(i)=='x' ||
            ques.charAt(i)=='/' || ques.charAt(i)=='%')
            {
                arr.add(str);
                str = "";
                str = str + ques.charAt(i);
                arr.add(str);
            }
            else
            {
                str = str + ques.charAt(i);
            }
        }
        for(int i=(arr.size()-1);i>=0;i--)
        {
            if(arr.get(i).equals("/"))
            {
                num1 = Double.parseDouble(arr.get(i-1));
                num2 = Double.parseDouble(arr.get(i+1));
                Double ans = num1/num2;
                String stnum = ans.toString();
                arr.set(i-1,stnum);
                arr.remove(i);
                arr.remove(i+1);
            }
        }
        for(int i=(arr.size()-1);i>=0;i--)
        {
            if(arr.get(i).equals("x"))
            {
                num1 = Double.parseDouble(arr.get(i-1));
                num2 = Double.parseDouble(arr.get(i+1));
                Double ans = num1*num2;
                String stnum = ans.toString();
                arr.set(i-1,stnum);
                arr.remove(i);
                arr.remove(i+1);
            }
        }
        for(int i=(arr.size()-1);i>=0;i--)
        {
            if(arr.get(i).equals("+"))
            {
                num1 = Double.parseDouble(arr.get(i-1));
                num2 = Double.parseDouble(arr.get(i+1));
                Double ans = num1+num2;
                String stnum = ans.toString();
                arr.set(i-1,stnum);
                arr.remove(i);
                arr.remove(i+1);
            }
        }
        for(int i=(arr.size()-1);i>=0;i--)
        {
            if(arr.get(i).equals("-"))
            {
                num1 = Double.parseDouble(arr.get(i-1));
                num2 = Double.parseDouble(arr.get(i+1));
                Double ans = num1-num2;
                String stnum = ans.toString();
                arr.set(i-1,stnum);
                arr.remove(i);
                arr.remove(i+1);
            }
        }
        ed2.setText(arr.get(0));

     }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ed1 = findViewById(R.id.ques);
        ed2 = findViewById(R.id.ans);
        //st = ed1.getText().toString();
    }
}
