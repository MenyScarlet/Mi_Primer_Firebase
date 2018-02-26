package com.example.mi_primer_firebase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class Parte3Activity extends AppCompatActivity {

    TextView tvNombre, tvDorsal, tvPosicion, tvSueldo;
    Spinner spId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parte3);

        tvNombre = (TextView)findViewById(R.id.Parte3_tvNombre);
        tvDorsal = (TextView)findViewById(R.id.Parte3_tvDorsal);
        tvPosicion = (TextView)findViewById(R.id.Parte3_tvPosicion);
        tvSueldo = (TextView)findViewById(R.id.Parte3_tvSueldo);
        spId = (Spinner)findViewById(R.id.Parte3_spId);

        String [] idJugadores = {"Seleccionar", "j1", "j2", "j3", "j4"};
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this,android.R.
                layout.simple_expandable_list_item_1,idJugadores);

        spId.setAdapter(adaptador);

    }//FIN OnCreate

    public void clickSearch (View view){

        String spIdJugador = spId.getSelectedItem().set

    }

    public void clickGuardar (View view){

        String nombre = tvNombre
        if(){

        }else{
            dbRef = FirebaseDatabase.getInstance().getReference().child("jugadores");
        }
        //String nueva clave = dbRef().setValue
        dbRef.child("j4").setValue(nuevoJugador, (new DatabaseReference.CompletionListener)){
            public void onComplete(DatabaseError error, DatabaseReference ref){
                if(error == null) {
                    Toast.makeText(getApplicationContext(), "Rellena todos los campos",
                            Toast.LENGTH_LONG).show();

                    limpiarFormulario();
                }else{
                    Toast.makeText(getApplicationContext(), "NO SE PUEDE INSERTAR EL JUGADOR",
                            Toast.LENGTH_LONG).show();
                }
            }
        }


    }

    public void clickModificar (View view){


    }

    public void clickEliminar (View view){

        spId.getSelectedItemPosition(0);
        tvNombre.setText("");
        tvDorsal.setText("");
        tvPosicion.setText("");
        tvSueldo.setText("");


    }



}
