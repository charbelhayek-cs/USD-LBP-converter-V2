package com.charbelhayek.currency_converterv2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
   EditText USD;
   EditText LBP;
   ImageView exchange;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        USD= (EditText) findViewById(R.id.USD);
        LBP= (EditText) findViewById(R.id.LBP);
        exchange=(ImageView)findViewById(R.id.exchange);
    }

    public void convert(View v){
        String input_USD=USD.getText().toString();
        String input_LBP=LBP.getText().toString();
        exchange.animate().rotation(-360).setDuration(2000);

        if(input_USD.equals("") && input_LBP.equals("")){
            String message="Please put a number in one of the cases you did not put any!";
            exchange.animate().rotation(360).setDuration(2000);
            Toast.makeText(getApplicationContext(),message,Toast.LENGTH_LONG).show();
        }
        else if(!input_USD.equals("") && !input_LBP.equals(""))
        {
            String message="Please put a number in one of the cases so we can convert";
            exchange.animate().rotation(360).setDuration(2000);
            Toast.makeText(getApplicationContext(),message,Toast.LENGTH_LONG).show();
        }
        else if(!input_USD.equals("") && input_LBP.equals(""))
        {
            Double inp_USD = Double.parseDouble(input_USD);
            double result = inp_USD * 22000;
            exchange.animate().rotation(360).setDuration(2000);
            Toast.makeText(getApplicationContext(), "the result is: " + result + " LBP", Toast.LENGTH_LONG).show();

        }
        else{
            Double inp_LBP=Double.parseDouble(input_LBP);
            double result=inp_LBP/22000;
            exchange.animate().rotation(360).setDuration(2000);
            Toast.makeText(getApplicationContext(),"the result is: "+result+" USD",Toast.LENGTH_LONG).show();
        }

    }
}
