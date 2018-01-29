package com.example.dm2.serviciosweb;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

public class MainActivity extends AppCompatActivity {

    EditText cifra,unidad, unidadAConvertir;
    TextView cifraConvertida;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cifra= (EditText) findViewById(R.id.cifra);
        unidad= (EditText) findViewById(R.id.u_cifra);
        unidadAConvertir= (EditText) findViewById(R.id.u_convertir);
        cifraConvertida= (TextView) findViewById(R.id.cifra_convertida);
    }

    public void convertir(View v){
        AsyncTask task= new AsyncPost();
        task.execute(cifra.getText().toString(),unidad.getText().toString(),unidadAConvertir.getText().toString());
    }

    //Creamos la calse asincrona
    private class AsyncPost extends AsyncTask<String,Void,Void>{

        @Override
        protected Void doInBackground(String... params) {

            HttpURLConnection conn;
            try {
                URL url= new URL("http://www.webservicex.net/length.asmx?op=ChangeLengthUnit");
                //Codificamos los parametors que vamos a manejar
                String param="LengthValue="+ URLEncoder.encode(params[0],"UTF-8") +
                        ""

            } catch (MalformedURLException e) {
                e.printStackTrace();
            }


            return null;
        }
    }
}
