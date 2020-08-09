package com.mainpage.meracalc;

import java.util.*;

public class Utils
{
    public ArrayList<String> arrm = new ArrayList<>();
    public String st = "";

    double num1,num2;

    public Utils(String ques)
    {
        for(int i=0;i<ques.length();i++)
        {
            if(ques.charAt(i)=='+' || ques.charAt(i)=='-' || ques.charAt(i)=='x' ||
                    ques.charAt(i)=='/' || ques.charAt(i)=='%')
            {
                arrm.add(st);
                st = "";
                st = st + ques.charAt(i);
                arrm.add(st);
            }
            else
            {
                st = st + ques.charAt(i);
            }
        }

        brHandler(arrm);
    }

    public void listMaker(int initial, int last)
    {
        ArrayList<String> arr1 = new ArrayList<>();

        if(!arrm.get(initial-1).equals("+") || !arrm.get(initial-1).equals("-") ||
                !arrm.get(initial-1).equals("x") || !arrm.get(initial-1).equals("/"))
            arrm.set(initial,"x");

        if(!arrm.get(last+1).equals("+") || !arrm.get(last+1).equals("-") ||
                !arrm.get(last+1).equals("x") || !arrm.get(last+1).equals("/"))
            arrm.set(initial,"x");

        for(int i=initial+1;i<last;i++)
        {
            arr1.add(arrm.get(i));
        }
        String comp = Compute(arr1);
        arrm.set(initial+1,comp);

        for(int i=initial+2; i<last; i++)
        {
            arrm.remove(initial+2);
        }

        brHandler(arrm);
    }

    public void brHandler(ArrayList<String> arr)
    {
        int i=0;

        while(i<arr.size())
        {
            int initial, last;
            if(arr.get(i).equals("("))
            {
                initial  = i;
                for(int j=i; j<arr.size(); j++)
                {
                    if (arr.get(j).equals("("))
                    {
                        initial = j;
                    }
                    else if(arr.get(j).equals(")"))
                    {
                        last = j;
                        listMaker(initial,last);
                    }
                }
            }
        }
        Compute(arrm);

    }

    public String Compute(ArrayList<String> arr)
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