package com.charbelhayek.currency_converterv2;
/**********************************************
 * MainActivity2.java
 * @author Charbel Hayek, Samer Saber
 * This class represents the second page of the application
 * where the currency conversion from dollars to lira or vice versa
 * can be applied using the rate from 'lirarate.org'.
 * Other files include: MainActivity.java
 * Last modified on Thursday, 31 of April 2022
 ***********************************************/

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONObject;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity2 extends AppCompatActivity {
   EditText usd;
   EditText lbp;
   TextView output;
   ImageView exchange;
   int lira_rate;


   public class DownloadTask extends AsyncTask<String, Void, String>
   {
   //This class will be used to run in the background
        protected String doInBackground(String... urls)
        {
        //Pre-execution of the API
            String result = "";
            URL url;
            HttpURLConnection http;

            try
            {
                url = new URL(urls[0]);
                http = (HttpURLConnection) url.openConnection();

                InputStream in = http.getInputStream();
                InputStreamReader reader = new InputStreamReader(in);

                int data = reader.read();

                while (data != -1)
                {
                    char current = (char) data;
                    result += current;
                    data = reader.read();
                }
            }catch(Exception e)
            {
                e.printStackTrace();
                return null;
            }

            return result;
        }

        protected void onPostExecute(String str)
        {
        //Post-execution of the API
            super.onPostExecute(str);

            try {
                JSONObject json = new JSONObject(str);
                //String created_at = json.getString("created_at");
                //String joke = json.getString("value");
                Toast.makeText(getApplicationContext(), "working! ", Toast.LENGTH_LONG).show();
                //String lbp = json.getString("lbp");
                //String dollar = json.getString("dollar");
                String omt = json.getString("omt");
                String rate_list[] = omt.split(",");
                String rate = rate_list[rate_list.length - 1];
                rate = rate.substring(0, 5);
                try {
                    lira_rate = Integer.parseInt(rate);
                }catch(NumberFormatException e)
                {
                    Toast.makeText(getApplicationContext(), "Could not parse rate", Toast.LENGTH_LONG).show();
                }
                Toast.makeText(getApplicationContext(), rate, Toast.LENGTH_LONG).show();
                Toast.makeText(getApplicationContext(), omt, Toast.LENGTH_LONG).show();
                //Toast.makeText(getApplicationContext(), "dollar: " + dollar, Toast.LENGTH_LONG).show();
            }catch(Exception e)
            {
                e.printStackTrace();
                return;
            }
        }
   }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        //Linking API when this page is launched
        //String url = "https://api.chucknorris.io/jokes/random";
        String url = "http://192.168.43.99/Back-End/rate.php";
        DownloadTask task = new DownloadTask();
        task.execute(url);


        usd = (EditText) findViewById(R.id.USD);
        lbp = (EditText) findViewById(R.id.LBP);
        output=(TextView) findViewById(R.id.result);
        exchange = (ImageView) findViewById(R.id.exchange);
    }
    public void back(View v)
    {
    //This function will redirect to home page / MainActivity.java
        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(intent);
    }

    public void convert(View v)
    {
    //This function converts lira value to dollar value and vice versa
        String input_usd = usd.getText().toString();
        String input_lbp = lbp.getText().toString();

        Toast.makeText(getApplicationContext(), "naya", Toast.LENGTH_LONG).show();

        exchange.animate().rotationBy(360f).setDuration(2000);
        exchange.clearAnimation();

        if(input_usd.equals("") && input_lbp.equals(""))
        {
        //If user does not input value in either fields
            String message = "Please insert a value!";
            Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();
        }
        else if(!input_usd.equals("") && !input_lbp.equals(""))
        {
        //If user inputs value in both fields
            String message = "Please insert a number only in one of the fields and not both";
//          exchange.animate().rotation(360).setDuration(2000);
//          exchange.clearAnimation();
            Toast.makeText(getApplicationContext(),message,Toast.LENGTH_LONG).show();
        }
        else if(!input_usd.equals("") && input_lbp.equals(""))
        {
        //If user inputs value in lbp field only
            double inp_usd;
            inp_usd = 0.0;

            try
            {
                inp_usd = Double.parseDouble(input_usd);
            }catch(NumberFormatException e)
            {
                Toast.makeText(getApplicationContext(), "Please input a number value!", Toast.LENGTH_LONG).show();
                return;
            }

            double result = inp_usd * lira_rate;
//            exchange.animate().rotation(360).setDuration(2000);
//            exchange.clearAnimation();
            String r = String.valueOf(result)+" LBP";
            output.setText(r);
        }
        else
        {
        //If user inputs value in dollar field only
            double inp_lbp;
            inp_lbp = 0.0;

            try
            {
                inp_lbp = Double.parseDouble(input_lbp);
            }catch(NumberFormatException e)
            {
                Toast.makeText(getApplicationContext(), "Please input a number value!", Toast.LENGTH_LONG).show();
                return;
            }

            double result = inp_lbp / lira_rate;
//            exchange.animate().rotation(360).setDuration(2000);
//            exchange.clearAnimation();
            String r = String.valueOf(result) + " $";
            output.setText(r);
        }
    }
}
