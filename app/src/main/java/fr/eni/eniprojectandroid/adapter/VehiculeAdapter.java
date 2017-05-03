package fr.eni.eniprojectandroid.adapter;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.InputStream;
import java.net.URL;
import java.util.List;

import fr.eni.eniprojectandroid.R;
import fr.eni.eniprojectandroid.classes.Voiture;

/**
 * Created by Administrateur on 03/05/2017.
 */

public class VehiculeAdapter extends ArrayAdapter<Voiture> {

    public VehiculeAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<Voiture> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {


        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.voiture_adapter,parent, false);
        }

        VoitureHolder viewHolder = (VoitureHolder) convertView.getTag();
        if(viewHolder == null){
            viewHolder = new VoitureHolder();
            viewHolder.nomTextView = (TextView) convertView.findViewById(R.id.textViewNom);
            viewHolder.prixTextView = (TextView) convertView.findViewById(R.id.textViewPrix);
            viewHolder.disponibilité = (TextView) convertView.findViewById(R.id.textViewDispo);
            viewHolder.photoImageView = (ImageView) convertView.findViewById(R.id.imageViewVoiture);
            convertView.setTag(viewHolder);
        }

        //getItem(position) va récupérer l'item [position] de la List<Tweet> tweets
        Voiture voiture = getItem(position);
        viewHolder.nomTextView.setText(voiture.getModele());
        viewHolder.prixTextView.setText(voiture.getPrix());
        if(voiture.isLoue()){
            viewHolder.disponibilité.setText("Voiture Indisponible");
        } else {
            viewHolder.disponibilité.setText("Voiture disponible");
        }

        viewHolder.photoImageView.setImageDrawable(LoadImageFromWebOperations(voiture.getUrlPhotoPres()));

        return convertView;


    }

    public static Drawable LoadImageFromWebOperations(String url) {
        try {
            InputStream is = (InputStream) new URL(url).getContent();
            Drawable d = Drawable.createFromStream(is, "src name");
            return d;
        } catch (Exception e) {
            return null;
        }
    }
}


class VoitureHolder{

    public TextView nomTextView;
    public TextView prixTextView;
    public TextView disponibilité;
    public ImageView photoImageView;

}
