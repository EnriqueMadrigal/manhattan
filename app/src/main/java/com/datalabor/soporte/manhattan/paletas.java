package com.datalabor.soporte.manhattan;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.datalabor.soporte.manhattan.adapters.IViewHolderClick;
import com.datalabor.soporte.manhattan.adapters.PaletasAdapter;
import com.datalabor.soporte.manhattan.custom.SimpleDividerItemDecoration;
import com.datalabor.soporte.manhattan.models.Product;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class paletas extends AppCompatActivity {


    Context context;
    private RecyclerView _recyclerview;
    private PaletasAdapter _adapter;
    private LinearLayoutManager _linearLayoutManager;

    private final  String TAG = "paletas";


    ArrayList<Product> _products;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paletas);
        context = this;

        Intent mIntent = getIntent();
        int categoria = mIntent.getIntExtra("categoria", 0);


        // Cargar las paletas
        String jsonProducts = Common.loadJSONFromAsset(context,"productos.json");
        JSONObject obj_products;
        JSONObject producto;


        _products = new ArrayList<Product>();
        ///////////////
        try {

            obj_products = new JSONObject(jsonProducts);
            JSONArray res = obj_products.getJSONArray("productos");

            for (int i = 0; i < res.length(); i++) {
                producto = res.getJSONObject(i).getJSONObject("producto");
                String name = producto.getString("name");
                String resname = producto.getString("resname");
                String desc = producto.getString("desc");
                String desc_completa = producto.getString("desc_completa");

                int id = producto.getInt("id");
                int subcategoryid = producto.getInt("idsubcategoria");

                Product newProduct = new Product();
                newProduct.set_name(name);
                newProduct.set_id(id);
                newProduct.set_description(desc);
                newProduct.set_desc_complete(desc_completa);

                int resid = context.getResources().getIdentifier(resname, "drawable", context.getPackageName());
                //Log.d(TAG,newProduct.get_name());

                newProduct.set_resId(resid);

                if (subcategoryid == categoria) {  // Solo Añadir las categorias seleccionadas
                    _products.add(newProduct);
                }
            }



        }

        catch (Exception e)
        {
            Log.d(TAG,"Can not read json file categories");
            //return null;

        }


        _recyclerview = (RecyclerView) findViewById(R.id.recyclerProducts);
        _adapter = new PaletasAdapter(context,_products,new IViewHolderClick() {
            @Override
            public void onClick(int position) {

           Log.d(TAG,"Clicked");

            }
        });


        /////////

        _linearLayoutManager = new LinearLayoutManager(context);

        _recyclerview.setHasFixedSize( true );
        _recyclerview.setAdapter( _adapter );
        _recyclerview.setLayoutManager( _linearLayoutManager );
        _recyclerview.addItemDecoration( new SimpleDividerItemDecoration( context) );



    }




}
