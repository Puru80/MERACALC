package com.mainpage.meracalc;

import java.util.ArrayList;
import java.util.List;

public class Utils
{
    public List<String> arr = new ArrayList<>();
    public String st = "";

    double num1,num2;

    public Utils(String ques)
    {
        for(int i=0;i<ques.length();i++)
        {
            if(ques.charAt(i)=='+' || ques.charAt(i)=='-' || ques.charAt(i)=='x' ||
                    ques.charAt(i)=='/' || ques.charAt(i)=='%')
            {
                arr.add(st);
                st = "";
                st = st + ques.charAt(i);
                arr.add(st);
            }
            else
            {
                st = st + ques.charAt(i);
            }
        }
    }

    public String Compute()
    {
        for(int i=(arr.size()-1);i>=0;i--)
        {
            if(arr.get(i).equals("%"))
            {
                num1 = Double.parseDouble(arr.get(i-1));
                num2 = Double.parseDouble(arr.get(i+1));
                Double ans = (num1/num2)*100;
                String stnum = ans.toString();
                arr.set(i-1,stnum);
                arr.remove(i);
                arr.remove(i+1);
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
                double ans = num1-num2;
                String stnum = Double.toString(ans);
                arr.set(i-1,stnum);
                arr.remove(i);
                arr.remove(i+1);
            }
        }

        return arr.get(0);
    }
}