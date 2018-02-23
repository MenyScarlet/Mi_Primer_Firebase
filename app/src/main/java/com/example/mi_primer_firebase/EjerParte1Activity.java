package com.example.mi_primer_firebase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class EjerParte1Activity extends AppCompatActivity {

    Spinner spid;
    TextView tvDorsal, tvNombre, tvPosicion, tvSueldo;
    private DatabaseReference dbRef;
    private ValueEventListener valueEventListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejer_parte1);

        tvDorsal = (TextView)findViewById(R.id.tvDorsal);
        tvNombre = (TextView)findViewById(R.id.tvNombre);
        tvPosicion = (TextView)findViewById(R.id.tvPosicion);
        tvSueldo = (TextView)findViewById(R.id.tvSueldo);
        spid = (Spinner)findViewById(R.id.spid);

        String [] idJugadores = {"Selecciona", "J1", "J2", "J3", "J4"};

        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this,
                android.R.layout.simple_expandable_list_item_1,idJugadores);

        spid.setAdapter(adaptador);

    }//FIN onCreate

    public void clickVer (View view){

        String idSelec = spid.getSelectedItem().toString();
        if (idSelec.equals("Selecciona")){
            Toast.makeText(getApplicationContext(),
                    "Debes de seleccionar una ID",
                    Toast.LENGTH_LONG).show();
        }else{

            dbRef = FirebaseDatabase.getInstance().getReference()
                    .child(idSelec);

            valueEventListener = new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {

                    Jugador jug = dataSnapshot.getValue(Jugador.class);
                    tvDorsal.setText("Dorsal: " + jug.getDorsal());
                    tvNombre.setText("Nombre: " + jug.getDorsal());
                    tvPosicion.setText("Posicion: " + jug.getDorsal());
                    tvSueldo.setText("Sueldo: " + jug.getDorsal());

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
}
