package com.mainpage.meracalc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity
{
    EditText ed1 ;
    EditText ed2 ;
    Utils ob;
    ShuntingYard shy;
    Button btn_cl;

    public String st = "";

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
        st = st + "/";
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
    public void btn_brr(View view)
    {
        st = st + ")";
        ed1.setText(st);
    }
    public void btn_brl(View view)
    {
        st = st + "(";
        ed1.setText(st);
    }

    View.OnClickListener Clear = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String ques = ed1.getText().toString();
            ques = ques.substring(0,ques.length()-1);
            ed1.setText(ques);
        }
    };

    View.OnLongClickListener clearLong = new View.OnLongClickListener() {
        @Override
        public boolean onLongClick(View v) {
            ed1.setText("");
            st = "";
            ed2.setText("");
            return true;
        }
    };

    public void History(View view)
    {
        Intent i = new Intent(MainActivity.this,History.class);
        i.putStringArrayListExtra("arh",ob.history);
        startActivity(i);
        //onPause();
    }

    public void Result(View view)
    {

        String ques = ed1.getText().toString();
        //Utils ob = new Utils();
        //ob.Util(ques);
        if(ob.stringCheck(ques))
        {
            String ans = Double.toString(shy.evaluate(ques));
            ob.listHistory(ques, ans);
            ed2.setText(ans);
        }
        else
            ed2.setText("Invalid expression");

    }

    @Override
    protected void onPause()
    {
        super.onPause();
    }

    @Override
    protected void onResume()
    {
        super.onResume();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ed1 = findViewById(R.id.ques);
        ed2 = findViewById(R.id.ans);
        //st = ed1.getText().toString();

        ob = new Utils();
        shy = new ShuntingYard();

        btn_cl = findViewById(R.id.btn_clear);
        btn_cl.setOnClickListener(Clear);
        btn_cl.setOnLongClickListener(clearLong);
    }
}
