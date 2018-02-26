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
import com.google.firebase.database.ValueEventListener;


public class Parte3Activity extends AppCompatActivity {

    TextView etNombre, etDorsal, etPosicion, etSueldo;
    Spinner spId;

    DatabaseReference dbRef;
    ValueEventListener valueEventListener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parte3);

        etNombre = (TextView)findViewById(R.id.Parte3_etNombre);
        etDorsal = (TextView)findViewById(R.id.Parte3_etDorsal);
        etPosicion = (TextView)findViewById(R.id.Parte3_etPosicion);
        etSueldo = (TextView)findViewById(R.id.Parte3_etSueldo);
        spId = (Spinner)findViewById(R.id.Parte3_spId);

        String [] idJugadores = {"Seleccionar", "j1", "j2", "j3", "j4"};
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this,android.R.
                layout.simple_expandable_list_item_1,idJugadores);

        spId.setAdapter(adaptador);

        dbRef = FirebaseDatabase.getInstance().getReference()
                .child("jugadores");

    }//FIN OnCreate

    public void clickSearch (View view){

        //String spIdJugador = spId.getSelectedItem().set

    }

    public void clickGuardar (View view){

        String nombre = etNombre.getText().toString();
        String strDorsal = etDorsal.getText().toString();
        String posicion = etPosicion.getText().toString();
        String strSueldo = etSueldo.getText().toString();

        if(nombre.equals("") || strDorsal.equals("") || posicion.equals("") || strSueldo.equals("")){

            Toast.makeText(getApplicationContext(), "Debes de completar todos los campos",
                    Toast.LENGTH_LONG).show();

        }else{

            int dorsal = Integer.parseInt(strDorsal);
            double sueldo = Double.parseDouble(strSueldo);
            Jugador nuevoJugador = new Jugador(nombre, dorsal, posicion, sueldo);
            dbRef = FirebaseDatabase.getInstance().getReference().child("jugadores");
        }
        /*String nueva_clave = dbRef().push().setvalue(nuevojugador, new DatabaseReference.
        CompletionListener(){*/
            dbRef.child("j5").setValue(nuevoJugador, new DatabaseReference.CompletionListener(){

            public void onComplete(DatabaseError error, DatabaseReference ref){

                if(error == null) {

                    Toast.makeText(getApplicationContext(), "INSERTADO CORRECTAMENTE",
                            Toast.LENGTH_LONG).show();

                    limpiarFormulario();

                }else{

                    Toast.makeText(getApplicationContext(), "NO SE PUEDE INSERTAR EL JUGADOR",
                            Toast.LENGTH_LONG).show();
                }
            }
        });


    }

    public void clickModificar (View view){


    }

    public void clickEliminar (View view){

        limpiarFormulario();


    }

    private void limpiarFormulario (){

        spId.setSelection(0);
        etNombre.setText("");
        etDorsal.setText("");
        etPosicion.setText("");
        etSueldo.setText("");
    }



}
