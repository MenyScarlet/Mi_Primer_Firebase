package com.example.mi_primer_firebase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class Parte2Activity extends AppCompatActivity {

    ListView lvJugador;
    ArrayList<Jugador> lista_jugador = new ArrayList<Jugador>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parte2);

        cargarDatos();

        lvJugador = (ListView)findViewById(R.id.lvJugadores);
        AdaptadorJugador adaptador = new AdaptadorJugador(this,
                lista_jugador);

        lvJugador.setAdapter(adaptador);
    }

    private void cargarDatos(){
        lista_jugador.add(new Jugador("", 1, "",1200));
        lista_jugador.add(new Jugador("", 1, "",1200));
        lista_jugador.add(new Jugador("", 1, "",1200));
    }

}
