package com.example.mi_primer_firebase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Parte1Activity extends AppCompatActivity {

    TextView tvJugador;

    private DatabaseReference dbRef;
    private ValueEventListener valueEventListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parte1);

        tvJugador = (TextView)findViewById(R.id.tvJugador);

        dbRef = FirebaseDatabase.getInstance().getReference()
                .child("jugadores/j1/j2/j3/j4");

        valueEventListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                Jugador jug = dataSnapshot.getValue(Jugador.class);
                //Aqui podemos hacer lo que queramos con los datos de la Database.
                tvJugador.setText(
                        "Nombre: "+jug.getNombre()+ "\n" +
                        "Dorsal: " + jug.getDorsal() + "\n" +
                        "Posicion: " + jug.getPosicion() + "\n" +
                        "Sueldo: " + jug.getSueldo()
                );



            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.e("Parte1Activity", "DATABASE ERROR");
                //Cuando falla el Log nos avisa de que hay error
            }
        };
        dbRef.addValueEventListener(valueEventListener);//Base de dato en tiempo real
        //dbRef.addListenerForSingleValueEvent(valueEventListener);//Si queremos base datos solo haga una carga
        //dbRef.removeEventListener(valueEventListener);//Destruye la conexion a tiempo real
    }
}
