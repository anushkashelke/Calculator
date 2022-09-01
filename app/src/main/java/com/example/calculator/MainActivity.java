package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    boolean isnewoper=true;
    EditText e1;
    String number;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e1=findViewById(R.id.editTextTextPersonName);
    }

    public void numberEvent(View view) {
        if(isnewoper){
            e1.setText("");
        }
        isnewoper=false;
        number=e1.getText().toString();
       switch(view.getId()){
           case R.id.button1:
               number+="1";
               break;
           case R.id.button2:
               number+="2";
               break;
           case R.id.button3:
               number+="3";
               break;
           case R.id.button4:
               number+="4";
               break;
           case R.id.button5:
               number+="5";
               break;
           case R.id.button6:
               number+="6";
               break;
           case R.id.button7:
               number+="7";
               break;
           case R.id.button8:
               number+="8";
               break;
           case R.id.button9:
               number+="9";
               break;
           case R.id.add_button:
               number+="+";
               break;
           case R.id.sub_button:
               number+="-";
               break;
           case R.id.mul_button:
               number+="*";
               break;
           case R.id.div_button:
               number+="/";
               break;
         }
         e1.setText(number);
    }
    public String nextNum(String num,int index){
        int len=num.length();
        String res="";
        while(index<len){
             try{
                 Double.parseDouble(String.valueOf(num.charAt(index)));
                 res+=num.charAt(index);
             }
             catch(NumberFormatException e){
                 break;
             }
             index++;
        }
        return res;
    }
    public void calculateEvent(View view){
        isnewoper=true;
        String prev="";
        double ans=0;
        int length=number.length();
        int i=0;
        while(i<length){
            if(number.charAt(i)=='+'){
                 //String r=nextNum(number,i+1);
                String res="";
                i=i+1;
                while(i<length){
                    try{
                        Double.parseDouble(String.valueOf(number.charAt(i)));
                        res+=number.charAt(i);
                    }
                    catch(NumberFormatException e){
                        break;
                    }
                    i++;
                }
                 if(res!=""){
                     double num1=Double.parseDouble(prev);
                     double num2=Double.parseDouble(res);
                     ans=num1+num2;
                     prev=ans+"";
                 }
            }
            else if(number.charAt(i)=='-'){
                /*String r=nextNum(number,i+1);
                if(r!=""){
                    double num1=Double.parseDouble(prev);
                    double num2=Double.parseDouble(r);
                    ans=num1-num2;
                    prev=ans+"";
                }  */
                String res="";
                i=i+1;
                while(i<length){
                    try{
                        Double.parseDouble(String.valueOf(number.charAt(i)));
                        res+=number.charAt(i);
                    }
                    catch(NumberFormatException e){
                        break;
                    }
                    i++;
                }
                if(res!=""){
                    double num1=Double.parseDouble(prev);
                    double num2=Double.parseDouble(res);
                    ans=num1-num2;
                    prev=ans+"";
                }
            }
            else if(number.charAt(i)=='*'){
                /*String r=nextNum(number,i+1);
                if(r!=""){
                    double num1=Double.parseDouble(prev);
                    double num2=Double.parseDouble(r);
                    ans=num1*num2;
                    prev=ans+"";
                } */
                String res="";
                i=i+1;
                while(i<length){
                    try{
                        Double.parseDouble(String.valueOf(number.charAt(i)));
                        res+=number.charAt(i);
                    }
                    catch(NumberFormatException e){
                        break;
                    }
                    i++;
                }
                if(res!=""){
                    double num1=Double.parseDouble(prev);
                    double num2=Double.parseDouble(res);
                    ans=num1*num2;
                    prev=ans+"";
                }
            }
            else if(number.charAt(i)=='/'){
                /*String r=nextNum(number,i+1);
                if(r!=""){
                    double num1=Double.parseDouble(prev);
                    double num2=Double.parseDouble(r);
                    ans=num1/num2;
                    prev=ans+"";
                } */
                String res="";
                i=i+1;
                while(i<length){
                    try{
                        Double.parseDouble(String.valueOf(number.charAt(i)));
                        res+=number.charAt(i);
                    }
                    catch(NumberFormatException e){
                        break;
                    }
                    i++;
                }
                if(res!=""){
                    double num1=Double.parseDouble(prev);
                    double num2=Double.parseDouble(res);
                    ans=num1/num2;
                    prev=ans+"";
                }
            }
            else{
                prev+=number.charAt(i);
                i++;
            }
        }
        System.out.println("Answer is "+ans);
        e1.setText(ans+"");
    }
    public void clearAll(View view){
        System.out.println("Entered");
        isnewoper=true;
        e1.setText("0");
    }
}