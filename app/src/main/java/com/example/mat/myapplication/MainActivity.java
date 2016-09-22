package com.example.mat.myapplication;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    static final String TAG = "MainActivity";
    public final Integer VIDAS = 20;


    public Integer lifeEnemy = VIDAS;
    public Integer lifeSelf = VIDAS;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.i(TAG, "Application is running...");

        final TextView textViewEnemy = (TextView) findViewById(R.id.displayEnemy);
        final TextView textViewSelf = (TextView) findViewById(R.id.displaySelf);

        textViewEnemy.setText(lifeEnemy.toString());
        textViewSelf.setText(lifeSelf.toString());

        Button btnSelf = (Button)findViewById(R.id.buttonSelf);
        btnSelf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "Pulsado boton de restar vidas propias");
                lifeSelf--;
                textViewSelf.setText(lifeSelf.toString());
                comprobarFinDePartida(lifeSelf);
            }
        });

        Button btnEnemy = (Button)findViewById(R.id.buttonEnemy);
        btnEnemy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "Pulsado boton de restar vidas enemigas");
                lifeEnemy--;
                textViewEnemy.setText(lifeEnemy.toString());
                comprobarFinDePartida(lifeEnemy);
            }
        });
    }

    private void comprobarFinDePartida(Integer life) {
        if(life == 0){
            Context context = getApplicationContext();
            CharSequence text = "FIN DE PARTIDA!";
            int duration = Toast.LENGTH_LONG;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }
    }


}
