package com.datalabor.soporte.manhattan;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.datalabor.soporte.manhattan.adapters.CategoriasAdapter;
import com.datalabor.soporte.manhattan.adapters.IViewHolderClick;
import com.datalabor.soporte.manhattan.adapters.PaletasAdapter;
import com.datalabor.soporte.manhattan.custom.SimpleDividerItemDecoration;
import com.datalabor.soporte.manhattan.models.Categoria;
import com.datalabor.soporte.manhattan.models.Product;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class categorias extends AppCompatActivity {

    Context context;
    private RecyclerView _recyclerview;
    private CategoriasAdapter _adapter;
    private LinearLayoutManager _linearLayoutManager;

    private final  String TAG = "paletas";


    ArrayList<Categoria> _categorias;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categorias);

        context = this;

        Intent mIntent = getIntent();
        int categoria = mIntent.getIntExtra("categoria", 0);


        // Cargar las categorias
        String jsonCategorias = Common.loadJSONFromAsset(context,"categorias.json");
        JSONObject obj_categorias;
        JSONObject obj_categoria;


        _categorias = new ArrayList<Categoria>();
        ///////////////
        try {

            obj_categorias = new JSONObject(jsonCategorias);
            JSONArray res = obj_categorias.getJSONArray("subcategorias");

            for (int i = 0; i < res.length(); i++) {
                obj_categoria = res.getJSONObject(i).getJSONObject("subcategoria");
                String name = obj_categoria.getString("name");
                String resname = obj_categoria.getString("resname");
                String desc =obj_categoria.getString("desc");

                int id = obj_categoria.getInt("id");
                int subcategoryid = obj_categoria.getInt("idcategoria");

                Categoria newCategoria = new Categoria();
                newCategoria.set_name(name);
                newCategoria.set_id(id);
                newCategoria.set_desc(desc);

                int resid = context.getResources().getIdentifier(resname, "drawable", context.getPackageName());
                //Log.d(TAG,newProduct.get_name());

                newCategoria.set_resId(resid);

                if (subcategoryid == categoria) {  // Solo Añadir las categorias seleccionadas
                    _categorias.add(newCategoria);
                }
            }



        }

        catch (Exception e)
        {
            Log.d(TAG,"Can not read json file categories");
            //return null;

        }


        _recyclerview = (RecyclerView) findViewById(R.id.recyclerCategorias);
        _adapter = new CategoriasAdapter(context,_categorias,new IViewHolderClick() {
            @Override
            public void onClick(int position) {

                //Log.d(TAG,"Clicked");

                Categoria curCategoria = _categorias.get(position);

                Intent intent = new Intent();
                intent.setClass(context, paletas.class);
                intent.putExtra("categoria",curCategoria.get_id());

                //finish();
                startActivity(intent);



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
