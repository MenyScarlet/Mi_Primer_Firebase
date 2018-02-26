package com.example.mi_primer_firebase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Parte2Activity extends AppCompatActivity {

    ListView lvJugador;

    DatabaseReference dbRef;
    ValueEventListener valueEventListener;

    ArrayList<Jugador> lista_jugador = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parte2);



        lvJugador = (ListView)findViewById(R.id.lvJugadores);

        cargarDatosFirebase();

    }

    private void cargarDatosFirebase(){

        dbRef = FirebaseDatabase.getInstance().getReference().child("jugadores");

        valueEventListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                lista_jugador.clear();//Importante para la carga de datos en TIEMPO REAL
                //Quita la antigua lista para cargar una nueva
                for (DataSnapshot jugadoresDataSnapshot: dataSnapshot.getChildren()){
                    cargarListView(jugadoresDataSnapshot);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.e("Parte2Activity","DATABASE ERROR");

            }
        };
        dbRef.addValueEventListener(valueEventListener);//Cargar datos en TIEMPO REAL
    }



    private void cargarListView (DataSnapshot dataSnapshot){

        lista_jugador.add(dataSnapshot.getValue(Jugador.class));

        AdaptadorJugador adaptador = new AdaptadorJugador(this,
                lista_jugador);

        lvJugador.setAdapter(adaptador);

        lvJugador.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Jugador jugador = ((Jugador)adapterView.getItemAtPosition(i));
                Toast.makeText(getApplicationContext(),
                        "El sueldo de" + jugador.getNombre() +
                        "es de " + jugador.getSueldo(),
                        Toast.LENGTH_SHORT).show();
            }
        });


    }

}
