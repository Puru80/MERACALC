package com.mainpage.meracalc;

import java.util.*;

public class Utils
{
    public ArrayList<String> arr = new ArrayList<>();
    public String st = "";

    public ArrayList<String> history = new ArrayList<>();
//    int index=0;
    double num1, num2;

    public boolean Sign(String ques, int i)
    {
        boolean success = false;
        if (ques.charAt(i) == '+' || ques.charAt(i)=='-'
                || ques.charAt(i) == 'x' || ques.charAt(i) == '/' || ques.charAt(i) == '%')
            success = true;
        return success;
    }

    public void listCon(String ques)
    {
        for (int i = 0; i < ques.length(); i++)
        {
            if (ques.charAt(i) == '+' /*|| ques.charAt(i)=='-'*/
                    || ques.charAt(i) == 'x' || ques.charAt(i) == '/' || ques.charAt(i) == '%')
            {
                arr.add(st);
                st = "";
                st = st + ques.charAt(i);
                arr.add(st);
                st = "";
            }
            ///*
            else if (ques.charAt(i) == '-')
            {
                arr.add(st);
                arr.add("+");
                st = "-";
                //arr.add("+");
                //arr.add(st);
                //st = "";
            }
            //*/
            else
            {
                st = st + ques.charAt(i);
            }
        }

        arr.add(st);
        st = "";

    }

    //brHandler(arrm)


    /*
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
        //Compute(arrm);

    }

     */

    public String Compute()
    {
        int i=0;
        while(i<arr.size())
        {
            if(arr.get(i).equals("%"))
            {
                num1 = Double.parseDouble(arr.get(i-1));
                num2 = Double.parseDouble(arr.get(i+1));
                double ans = (num1*num2)/(double)100;
                String stnum = Double.toString(ans);
                arr.set(i-1,stnum);
                arr.remove(i);
                arr.remove(i);
                i=i-1;
            }
            i++;
        }
        i=0;

        while(i<arr.size())
        {
            if(arr.get(i).equals("/"))
            {
                num1 = Double.parseDouble(arr.get(i-1));
                num2 = Double.parseDouble(arr.get(i+1));
                double ans = num1/num2;
                String stnum = Double.toString(ans);
                arr.set(i-1,stnum);
                arr.remove(i);
                arr.remove(i);
                i=i-1;
            }
            i++;
        }
        i=0;

        while(i<arr.size())
        {
            if(arr.get(i).equals("x"))
            {
                num1 = Double.parseDouble(arr.get(i-1));
                num2 = Double.parseDouble(arr.get(i+1));
                double ans = num1*num2;
                String stnum = Double.toString(ans);
                arr.set(i-1,stnum);
                arr.remove(i);
                arr.remove(i);
                i=i-1;
            }
            i++;
        }
        i=0;
        int j=0;
        while(j<arr.size())
        {
            if(arr.get(j).equals("+"))
            {
                num1 = Double.parseDouble(arr.get(j-1));
                num2 = Double.parseDouble(arr.get(j+1));
                double ans = num1+num2;
                String stnum = Double.toString(ans);
                arr.set(j-1,stnum);
                arr.remove(j);
                arr.remove(j);
                j=j-1;
            }
            j++;
        }
        while(i<arr.size())
        {
            if(arr.get(i).equals("-"))
            {
                num1 = Double.parseDouble(arr.get(i-1));
                num2 = Double.parseDouble(arr.get(i+1));
                double ans = num1-num2;
                String stnum = Double.toString(ans);
                arr.set(i-1,stnum);
                arr.remove(i);
                arr.remove(i);
                i=i-1;
            }
            i++;
        }
        String fin_ans = arr.get(0);
        arr.clear();
        return fin_ans;
    }

    public void listHistory(String ques, String answer)
    {
        String fin = ques + " = " + answer;

        history.add(fin);
    }

    public boolean stringCheck(String s)
    {
        boolean success = true;
        for(int i=0;i<s.length();i++)
        {
            if(i==0 && ((int)s.charAt(0)<48 || (int)s.charAt(0)>57))
            {
                success = false;
                break;
            }
            else if(Sign(s, i) && Sign(s, i + 1))
            {
                success = false;
                break;
            }

        }

        Stack<Character> checkArr = new Stack<>();
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='(')
                checkArr.push(s.charAt(i));
            else if(!checkArr.isEmpty() && s.charAt(i)==')' && checkArr.peek()=='(')
                checkArr.pop();

        }
        return success && checkArr.isEmpty();
    }
}