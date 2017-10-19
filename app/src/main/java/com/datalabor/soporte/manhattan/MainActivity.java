package com.datalabor.soporte.manhattan;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import com.datalabor.soporte.manhattan.R;

public class MainActivity extends AppCompatActivity {

    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;
    }


    public void showSucursales(View view)
    {

        Intent intent = new Intent();
        intent.setClass(context, MapsActivity.class);
        //finish();
        startActivity(intent);


    }


    public void showPaletas(View view)
    {

        Intent intent = new Intent();
        intent.setClass(context, categorias.class);
        intent.putExtra("categoria",1);

        //finish();
        startActivity(intent);


    }

    public void showHelados(View view)
    {

        Intent intent = new Intent();
        intent.setClass(context, categorias.class);
        intent.putExtra("categoria",2);

        //finish();
        startActivity(intent);


    }

    public void showEspecialidades(View view)
    {

        Intent intent = new Intent();
        intent.setClass(context, paletas.class);
        intent.putExtra("categoria",20);

        //finish();
        startActivity(intent);


    }




}
