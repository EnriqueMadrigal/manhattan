package com.datalabor.soporte.manhattan;

import android.content.Context;
import android.util.Log;

import com.datalabor.soporte.manhattan.models.Categoria;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Enrique on 19/10/2017.
 */

public class utils {

    public static ArrayList<String> getArray(String jsonFile, String jsonName,String jsonNames, String jsonKey, Context context)
    {


        /////////
        // Cargar el array de un Json
        String jsonCategorias = Common.loadJSONFromAsset(context,jsonFile);
        JSONObject obj_categorias;
        JSONObject obj_categoria;


        ArrayList<String> lista =  new ArrayList<String>();

        ///////////////
        try {

            obj_categorias = new JSONObject(jsonCategorias);
            JSONArray res = obj_categorias.getJSONArray(jsonName);

            for (int i = 0; i < res.length(); i++) {
                obj_categoria = res.getJSONObject(i).getJSONObject(jsonNames);

                String name = obj_categoria.getString(jsonKey);
                lista.add(name);

            }



        }

        catch (Exception e)
        {
            Log.d("Utils","Can not read json file categories");
            //return null;

        }

        ///////
        return lista;

    }



}
