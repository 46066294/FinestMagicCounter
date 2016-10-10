package com.example.mat.myapplication;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    static final String TAG1 = "MainActivity";
    static final String TAG2 = "ControlActivity";

    public final Integer VIDAS = 20;
    public final Integer VENOM = 0;

    public Integer lifeEnemy = VIDAS;
    public Integer lifeSelf = VIDAS;
    public Integer lifeEnemyVenom = VENOM;
    public Integer lifeSelfVenom = VENOM;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        Log.i(TAG1, "Application is running...");

        final TextView textViewEnemy = (TextView) findViewById(R.id.displayEnemy);
        final TextView textViewSelf = (TextView) findViewById(R.id.displaySelf);
        final TextView textViewEnemyVenom = (TextView) findViewById(R.id.displayEnemyVenom);
        final TextView textViewSelfVenom = (TextView) findViewById(R.id.displaySelfVenom);

        RelativeLayout layout =(RelativeLayout)findViewById(R.id.activity_main);
        layout.setBackgroundResource(R.drawable.ball);


        /*
        View view = new View(this);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            view.setBackground(getResources().getDrawable(R.drawable.frog));
        }
        else{
            view.setBackgroundDrawable(getResources().getDrawable(R.drawable.pirateofense));
        }

        view.setBackgroundResource(R.drawable.skull);
        */

        textViewEnemy.setText(lifeEnemy.toString());
        textViewSelf.setText(lifeSelf.toString());
        textViewEnemyVenom.setText(lifeEnemyVenom.toString());
        textViewSelfVenom.setText(lifeSelfVenom.toString());

        Log.i("...hd int: ", String.valueOf(R.drawable.hdhexo));//2130837582


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
                comprobarFinDePartidaVenom(lifeSelfVenom);
            }
        });

        Button btnSelfMasVenom = (Button)findViewById(R.id.btnSelfMasVenom);
        btnSelfMasVenom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG1, "Pulsado boton de sumar veneno propio");
                lifeSelfVenom++;
                textViewSelfVenom.setText(lifeSelfVenom.toString());
                comprobarFinDePartidaVenom(lifeSelfVenom);
            }
        });

        Button btnEnemyMenosVenom = (Button)findViewById(R.id.btnEnemyMenosVenom);
        btnEnemyMenosVenom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG1, "Pulsado boton de restar veneno enemigo");
                lifeEnemyVenom--;
                textViewEnemyVenom.setText(lifeEnemyVenom.toString());
                comprobarFinDePartidaVenom(lifeSelfVenom);
            }
        });

        Button btnEnemyMasVenom = (Button)findViewById(R.id.btnEnemyMasVenom);
        btnEnemyMasVenom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG1, "Pulsado boton de sumar veneno enemigo");
                lifeEnemyVenom++;
                textViewEnemyVenom.setText(lifeEnemyVenom.toString());
                comprobarFinDePartidaVenom(lifeSelfVenom);
            }
        });

        Button btnSelfAEnemy = (Button)findViewById(R.id.selfAenemy);
        btnSelfAEnemy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG1, "Pulsado boton de transferir vida propia a enemigo");
                lifeSelf--;
                lifeEnemy++;
                textViewEnemy.setText(lifeEnemy.toString());
                textViewSelf.setText(lifeSelf.toString());

                comprobarFinDePartida(lifeSelf);
            }
        });

        Button btnEnemyAself = (Button)findViewById(R.id.enemyAself);
        btnEnemyAself.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG1, "Pulsado boton de transferir vida enemiga a propia");
                lifeSelf++;
                lifeEnemy--;
                textViewEnemy.setText(lifeEnemy.toString());
                textViewSelf.setText(lifeSelf.toString());

                comprobarFinDePartida(lifeEnemy);

            }
        });

    }

    public void intentControlActivity(View v) {
        Log.i(TAG2, "Launching activity ControlActivity...");

        Intent intent = new Intent(this, ControlActivity.class);
        /*
        String message = "lololo";
        Log.i(TAG2, EXTRA_MESSAGE);
        intent.putExtra(EXTRA_MESSAGE, message);
        */

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

    private void comprobarFinDePartidaVenom(Integer venom) {
        if(venom == 10){
            Context context = getApplicationContext();
            CharSequence text = "FIN DE PARTIDA!";
            int duration = Toast.LENGTH_LONG;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }
    }


    //metodes per a posar settings
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
