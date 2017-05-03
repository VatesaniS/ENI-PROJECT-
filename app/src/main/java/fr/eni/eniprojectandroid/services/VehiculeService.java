package fr.eni.eniprojectandroid.services;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import fr.eni.eniprojectandroid.classes.Agence;
import fr.eni.eniprojectandroid.classes.Voiture;

/**
 * Created by Administrateur on 03/05/2017.
 */

public class VehiculeService {

    private static Agence _agence = new Agence("448c2d3b-dee9-4577-8013-c39d9cfcc5c8","Agence Communautaire Utopique de Larré");
    private List<Voiture> lesVoitures = new ArrayList<Voiture>();
    private static VehiculeService _instance = null;



    private VehiculeService(){}

    public static VehiculeService getVehiculeService(@Nullable Context context){

        if(_instance == null){
            _instance=new VehiculeService();
            _instance.setLesVoitures(context);
        }
        return _instance;
    }

    private void setLesVoitures(Context context){
        RequestQueue queue = Volley.newRequestQueue(context);

        StringRequest stringRequest = new StringRequest("https://locakar-96c1.restdb.io/rest/vehicules?max=20", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try{
                    JSONArray jsonVoitures = new JSONArray(response);
                    _instance.lesVoitures = jsonToVoitures(jsonVoitures);
                } catch (JSONException e){
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                //AVOIR TODO
            }
        });

        queue.add(stringRequest);
    }

    private List<Voiture> jsonToVoitures(JSONArray jsonArray) {

        List<Voiture> transformedVoitures = new ArrayList<Voiture>();

        for (int i = 0; jsonArray.length() >= i ; i++ ) {
            try{
                //recupération de toutes les voitures & transformation
                JSONObject jo = jsonArray.getJSONObject(i);
                //instanciation des voitures
                Voiture v = new Voiture(jo.getString("id"),jo.getString("model"),jo.getString("marque"),jo.getBoolean("loue"),jo.getInt("prix"),jo.getString("plaque"));
                //ajout des voitures a la liste
                transformedVoitures.add(v);
            } catch (JSONException e ){
                e.printStackTrace();
            }
        }
        return transformedVoitures;

    }

    public List<Voiture> getLesVoitures() {
        return lesVoitures;
    }

    public void setLesVoitures(List<Voiture> lesVoitures) {
        this.lesVoitures = lesVoitures;
    }

}
