package com.datalabor.soporte.manhattan;

import android.Manifest;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;

import com.datalabor.soporte.manhattan.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private Context context;

    private Date curDate;
    private SimpleDateFormat dateFormatter;
    private SimpleDateFormat dateFormatter2;

    private static final int REQUEST_CALL_PERMISSION = 100;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;
        curDate = new Date();
        dateFormatter = new SimpleDateFormat("dd-MM-yyyy", Locale.US);
        dateFormatter2 = new SimpleDateFormat("HH:mm aa", Locale.US);



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

    public void showPerfil(View view)
    {
        final Dialog alertDialog = new Dialog(this);
        alertDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);

        LayoutInflater factory = LayoutInflater.from(context);
        final View view2 = factory.inflate(R.layout.perfil_layout, null);

        final Button perfilAceptar = (Button) view2.findViewById(R.id.perfilAceptar);
        final Button perfilCancelar = (Button) view2.findViewById(R.id.perfilCancelar);
        final Spinner perfilEstado = (Spinner) view2.findViewById(R.id.perfilEstado);
        final Spinner perfilCiudad = (Spinner) view2.findViewById(R.id.perfilCiudad);
        final TextView FechaNac = (TextView) view2.findViewById(R.id.perfilFechaNac);

        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int width = size.x;
        int height = size.y;

        double Resizex = width * 0.80;
        double Resizey = height * 0.80;
        int newx = (int) Resizex;
        int newy = (int) Resizey;


        // Pon las fechas

        String Date1 = dateFormatter.format(curDate);
        //String Date2 = dateFormatter2.format(curDate);

        FechaNac.setText(Date1);


        /// Llenar el spiner de Estados

        ArrayList<String> estados = utils.getArray("estados.json","estados","estado","state",context);
        ArrayAdapter<String> dataAdapter2 = new ArrayAdapter<String>(this, R.layout.spinner_item, estados);
        dataAdapter2.setDropDownViewResource(R.layout.spinner_item);
        perfilEstado.setAdapter(dataAdapter2);

        /// Llenar el spiner de Ciudades

        ArrayList<String> ciudades = utils.getArray("ciudades.json","ciudades","ciudad","city",context);
        ArrayAdapter<String> dataAdapter3 = new ArrayAdapter<String>(this, R.layout.spinner_item, ciudades);
        dataAdapter3.setDropDownViewResource(R.layout.spinner_item);
        perfilCiudad.setAdapter(dataAdapter3);


        // Fecha de nacimiento
        Calendar newCalendar = Calendar.getInstance();
        final DatePickerDialog datePicker1 = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {

            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                Calendar newDate = Calendar.getInstance();
                newDate.set(year, monthOfYear, dayOfMonth);
                String curdate = dateFormatter.format(newDate.getTime()).toString();
                FechaNac.setText(curdate);
                //   Dia = dayOfMonth;
                //   Mes = monthOfYear;
                //   Ano = year;
            }

        }, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));


        alertDialog.setContentView(view2);
        alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        alertDialog.show();


        FechaNac.setOnClickListener(new View.OnClickListener() {
            //@Override
            public void onClick(View v) {
                datePicker1.show();
            }
        });

        perfilAceptar.setOnClickListener(new View.OnClickListener() {
            //@Override
            public void onClick(View v) {

                alertDialog.dismiss();
            }
        });


        perfilCancelar.setOnClickListener(new View.OnClickListener() {
            //@Override
            public void onClick(View v) {

                alertDialog.dismiss();
            }
        });





    }


public void showCompras(View view)
{
    final Dialog alertDialog = new Dialog(this);
    alertDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);

    LayoutInflater factory = LayoutInflater.from(context);
    final View view2 = factory.inflate(R.layout.compras_layout, null);

    final Button comprasAceptar = (Button) view2.findViewById(R.id.comprasAceptar);
    final Button comprasCancelar = (Button) view2.findViewById(R.id.comprasCancelar);

    alertDialog.setContentView(view2);
    alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

    alertDialog.show();

    comprasAceptar.setOnClickListener(new View.OnClickListener() {
        //@Override
        public void onClick(View v) {

            alertDialog.dismiss();
        }
    });


    comprasCancelar.setOnClickListener(new View.OnClickListener() {
        //@Override
        public void onClick(View v) {

            alertDialog.dismiss();
        }
    });


}


public void showPuntos(View view)
{

    final Dialog alertDialog = new Dialog(this);
    alertDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);

    LayoutInflater factory = LayoutInflater.from(context);
    final View view2 = factory.inflate(R.layout.puntos_layout, null);

    final Button puntosAceptar = (Button) view2.findViewById(R.id.puntosAceptar);


    alertDialog.setContentView(view2);
    alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

    alertDialog.show();

    puntosAceptar.setOnClickListener(new View.OnClickListener() {
        //@Override
        public void onClick(View v) {

            alertDialog.dismiss();
        }
    });

}

public void showFacebookPage(View view)
{
    Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/PaletasManhattanOficial/"));
    startActivity(browserIntent);

}


public void callManhattan(View view)
{
    String uri = "tel:3336563637";
    Intent intent = new Intent(Intent.ACTION_CALL);
    intent.setData(Uri.parse(uri));

    if (ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED)
    {
        ActivityCompat.requestPermissions(this,
                new String[]{Manifest.permission.CALL_PHONE}, REQUEST_CALL_PERMISSION);
    }

else {
        startActivity(intent);
    }
}

}

