package com.claudeprueba.contador;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends Activity {

    private static final String PREFS = "contador";
    private static final String KEY = "valor";

    private SharedPreferences prefs;
    private TextView etiqueta;
    private int valor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        prefs = getSharedPreferences(PREFS, MODE_PRIVATE);
        valor = prefs.getInt(KEY, 0);

        LinearLayout raiz = new LinearLayout(this);
        raiz.setOrientation(LinearLayout.VERTICAL);
        raiz.setGravity(Gravity.CENTER);
        int margen = dp(24);
        raiz.setPadding(margen, dp(64), margen, margen);

        TextView titulo = new TextView(this);
        titulo.setText("Contador");
        titulo.setTextSize(24);
        titulo.setGravity(Gravity.CENTER);
        raiz.addView(titulo);

        etiqueta = new TextView(this);
        etiqueta.setTextSize(96);
        etiqueta.setGravity(Gravity.CENTER);
        etiqueta.setPadding(0, dp(24), 0, dp(24));
        raiz.addView(etiqueta);

        raiz.addView(crearBoton("+1", v -> cambiar(1)));
        raiz.addView(crearBoton("-1", v -> cambiar(-1)));
        raiz.addView(crearBoton("Reiniciar", v -> {
            valor = 0;
            actualizar();
        }));

        setContentView(raiz);
        actualizar();
    }

    private Button crearBoton(String texto, View.OnClickListener accion) {
        Button boton = new Button(this);
        boton.setText(texto);
        boton.setOnClickListener(accion);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        params.setMargins(0, dp(8), 0, dp(8));
        boton.setLayoutParams(params);
        return boton;
    }

    private void cambiar(int delta) {
        valor += delta;
        actualizar();
    }

    private void actualizar() {
        etiqueta.setText(String.valueOf(valor));
        prefs.edit().putInt(KEY, valor).apply();
    }

    private int dp(int valorDp) {
        float densidad = getResources().getDisplayMetrics().density;
        return Math.round(valorDp * densidad);
    }
}
