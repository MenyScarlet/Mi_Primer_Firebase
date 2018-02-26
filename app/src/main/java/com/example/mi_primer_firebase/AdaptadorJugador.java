package com.example.mi_primer_firebase;

/**
 * Created by Melania on 26/02/2018.
 */
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.ArrayList;

public class AdaptadorJugador extends ArrayAdapter<Jugador> {

    ArrayList<Jugador> Jugadores;
    Context c;
    public AdaptadorJugador(Context c, ArrayList<Jugador> Jugadores) {
        super(c, R.layout.item_jugador, Jugadores);
        this.Jugadores = Jugadores;
        this.c = c;
    }
    public View getView(int position, View view, ViewGroup
            viewGroup) {
        LayoutInflater inflater =
                LayoutInflater.from(getContext());
        View item = inflater.inflate(R.layout.item_jugador, null);

        TextView tvNombre = (TextView)
                item.findViewById(R.id.ListTvNombre);
        tvNombre.setText(Jugadores.get(position).getNombre() );

        TextView tvDorsal = (TextView)
                item.findViewById(R.id.ListTvDorsal);
        tvDorsal.setText(Jugadores.get(position).getDorsal() +"");

        TextView tvPosicion = (TextView)
                item.findViewById(R.id.ListTvPosicion);
        tvPosicion.setText(Jugadores.get(position).getPosicion() );


        return item;
    }
}
