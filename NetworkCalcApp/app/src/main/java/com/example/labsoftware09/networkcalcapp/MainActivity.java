package com.example.labsoftware09.networkcalcapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;


public class MainActivity extends AppCompatActivity {
    private TextView pantalla;
    double a,b;
    String op;
    private Button igual;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pantalla=(TextView) findViewById(R.id.pantalla);
        pantalla.setText("0");
    igual=(Button) findViewById(R.id.igual);
        igual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b=Double.parseDouble( pantalla.getText().toString());
                try {
                    server_post();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

    }
    public void server_post() throws IOException {
        HttpURLConnection con = null;
        URL url = new URL("http://162.243.64.94/dm.php");


        try {
            // Construir los datos a enviar
            String data = "a=" + URLEncoder.encode(""+a,"UTF-8");

            con = (HttpURLConnection)url.openConnection();

            // Activar método POST
            con.setDoOutput(true);

            // Tamaño previamente conocido
            con.setFixedLengthStreamingMode(data.getBytes().length);

            // Establecer application/x-www-form-urlencoded debido a la simplicidad de los datos
            con.setRequestProperty("Content-Type","application/x-www-form-urlencoded");

            OutputStream out = new BufferedOutputStream(con.getOutputStream());

            out.write(data.getBytes());
            out.flush();
            out.close();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(con!=null)
                con.disconnect();
        }
    }


    public void resta(View v){
        a=Double.parseDouble( pantalla.getText().toString());
        op="res";
        pantalla.setText("0");

    }

    public void multiplicacion(View v){
        a=Double.parseDouble( pantalla.getText().toString());
        op="mul";
        pantalla.setText("0");


    }

    public void division(View v){
        a=Double.parseDouble( pantalla.getText().toString());
        op="div";
        pantalla.setText("0");


    }
    public void suma(View v){
        a=Double.parseDouble( pantalla.getText().toString());
        op="sum";
        pantalla.setText("0");

    }

    public void punto(View v){

            pantalla.setText(pantalla.getText()+".");

    }

    public void num_1(View v){
        if(pantalla.getText()=="0"){
            pantalla.setText("1");
        }else if(pantalla.getText()!="0"){
            pantalla.setText(pantalla.getText()+"1");
        }

    }

    public void num_2(View v){
        if(pantalla.getText()=="0"){
            pantalla.setText("2");
        }else if(pantalla.getText()!="0"){
            pantalla.setText(pantalla.getText()+"2");
        }

    }

    public void num_3(View v){
        if(pantalla.getText()=="0"){
            pantalla.setText("3");
        }else if(pantalla.getText()!="0"){
            pantalla.setText(pantalla.getText()+"3");
        }

    }

    public void num_4(View v){
        if(pantalla.getText()=="0"){
            pantalla.setText("4");
        }else if(pantalla.getText()!="0"){
            pantalla.setText(pantalla.getText()+"4");
        }

    }

    public void num_5(View v){
        if(pantalla.getText()=="0"){
            pantalla.setText("5");
        }else if(pantalla.getText()!="0"){
            pantalla.setText(pantalla.getText()+"5");
        }

    }

    public void num_6(View v){
        if(pantalla.getText()=="0"){
            pantalla.setText("6");
        }else if(pantalla.getText()!="0"){
            pantalla.setText(pantalla.getText()+"6");
        }

    }

    public void num_7(View v){
        if(pantalla.getText()=="0"){
            pantalla.setText("7");
        }else if(pantalla.getText()!="0"){
            pantalla.setText(pantalla.getText()+"7");
        }

    }

    public void num_8(View v){
        if(pantalla.getText()=="0"){
            pantalla.setText("8");
        }else if(pantalla.getText()!="0"){
            pantalla.setText(pantalla.getText()+"8");
        }

    }

    public void num_9(View v){
        if(pantalla.getText()=="0"){
            pantalla.setText("9");
        }else if(pantalla.getText()!="0"){
            pantalla.setText(pantalla.getText()+"9");
        }

    }

    public void num_0(View v){
        if(pantalla.getText()=="0"){
            pantalla.setText("0");
        }else if(pantalla.getText()!="0"){
            pantalla.setText(pantalla.getText()+"0");
        }

    }

}
