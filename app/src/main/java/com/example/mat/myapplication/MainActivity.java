package com.example.mat.myapplication;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    static final String TAG1 = "MainActivity";
    static final String TAG2 = "ControlActivity";

    public final Integer VIDAS = 20;
    public final Integer VENOM = 10;

    public Integer lifeEnemy = VIDAS;
    public Integer lifeSelf = VIDAS;
    public Integer lifeEnemyVenom = VENOM;
    public Integer lifeSelfVenom = VENOM;

    public final static String EXTRA_MESSAGE = "extraMessage";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.i(TAG1, "Application is running...");

        final TextView textViewEnemy = (TextView) findViewById(R.id.displayEnemy);
        final TextView textViewSelf = (TextView) findViewById(R.id.displaySelf);
        final TextView textViewEnemyVenom = (TextView) findViewById(R.id.displayEnemyVenom);
        final TextView textViewSelfVenom = (TextView) findViewById(R.id.displaySelfVenom);

        textViewEnemy.setText(lifeEnemy.toString());
        textViewSelf.setText(lifeSelf.toString());
        textViewEnemyVenom.setText(lifeEnemyVenom.toString());
        textViewSelfVenom.setText(lifeSelfVenom.toString());

        Button btnSelfMenosVida = (Button)findViewById(R.id.buttonSelfMenos);
        btnSelfMenosVida.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG1, "Pulsado boton de restar vidas propias");
                lifeSelf--;
                textViewSelf.setText(lifeSelf.toString());
                comprobarFinDePartida(lifeSelf);
            }
        });

        Button btnSelfMasVida = (Button)findViewById(R.id.buttonSelfMas);
        btnSelfMasVida.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG1, "Pulsado boton de sumar vidas propias");
                lifeSelf++;
                textViewSelf.setText(lifeSelf.toString());
                comprobarFinDePartida(lifeSelf);
            }
        });

        Button btnEnemyMenosVida = (Button)findViewById(R.id.buttonEnemyMenos);
        btnEnemyMenosVida.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG1, "Pulsado boton de restar vidas enemigas");
                lifeEnemy--;
                textViewEnemy.setText(lifeEnemy.toString());
                comprobarFinDePartida(lifeEnemy);
            }
        });

        Button btnEnemyMasVida = (Button)findViewById(R.id.buttonEnemyMas);
        btnEnemyMasVida.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG1, "Pulsado boton de sumar vidas enemigas");
                lifeEnemy++;
                textViewEnemy.setText(lifeEnemy.toString());
                comprobarFinDePartida(lifeEnemy);
            }
        });

        Button btnControl = (Button)findViewById(R.id.buttonControl);

        /*btnControl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(this, ControlActivity.class);
                //EditText editText = (EditText) findViewById(R.id.edit_message);
                String message = "lololo";
                intent.putExtra(EXTRA_MESSAGE, message);
                startActivity(intent);
            }
        });*/


        Button btnSelfMenosVenom = (Button)findViewById(R.id.btnSelfMenosVenom);
        btnSelfMenosVenom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG1, "Pulsado boton de restar veneno propio");
                lifeSelfVenom--;
                textViewSelfVenom.setText(lifeSelfVenom.toString());
            }
        });

        Button btnSelfMasVenom = (Button)findViewById(R.id.btnSelfMasVenom);
        btnSelfMasVenom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG1, "Pulsado boton de sumar veneno propio");
                lifeSelfVenom++;
                textViewSelfVenom.setText(lifeSelfVenom.toString());
            }
        });

        Button btnEnemyMenosVenom = (Button)findViewById(R.id.btnEnemyMenosVenom);
        btnEnemyMenosVenom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG1, "Pulsado boton de restar veneno enemigo");
                lifeEnemyVenom--;
                textViewEnemyVenom.setText(lifeEnemyVenom.toString());
            }
        });

        Button btnEnemyMasVenom = (Button)findViewById(R.id.btnEnemyMasVenom);
        btnEnemyMasVenom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG1, "Pulsado boton de sumar veneno enemigo");
                lifeEnemyVenom++;
                textViewEnemyVenom.setText(lifeEnemyVenom.toString());
            }
        });

    }

    public void intentControlActivity(View v) {
        Log.i(TAG2, "Launching activity ControlActivity...");

        Intent intent = new Intent(this, ControlActivity.class);
        String message = "lololo";
        Log.i(TAG2, EXTRA_MESSAGE);
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
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
