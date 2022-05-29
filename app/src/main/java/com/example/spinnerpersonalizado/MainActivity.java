package com.example.spinnerpersonalizado;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Button btnFinalizar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Spinner sp;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArrayList<ItemData> list = new ArrayList<>();
        list.add(new ItemData(getString(R.string.itemFrappses),getString(R.string.msgFrapsses)
                ,R.drawable.categorias));
        list.add
                (new ItemData(getString(R.string.itemAgradecimiento),getString(R.string.msgAgradecimiento),R.drawable.agradecimiento));
        list.add
                (new ItemData(getString(R.string.itemAmor),getString(R.string.msgAmor),R.drawable.corazon));
        list.add
                (new ItemData(getString(R.string.itemNewyear),getString(R.string.msgNewYear), R.drawable.nuevo));
        list.add
                (new ItemData(getString(R.string.itemCanciones),getString(R.string.msgCanciones),R.drawable.canciones));
        sp =(Spinner) findViewById(R.id.spinner1);
        btnFinalizar = (Button) findViewById(R.id.btnFinalizar);

            btnFinalizar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AlertDialog.Builder confirmar = new AlertDialog.Builder(MainActivity.this);
                  confirmar.setTitle("¿Cerrar App?");
    confirmar.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
    finish();
        }
    });
    confirmar.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {

        }
    });
    confirmar.show();
                }
            });
        SpinnerAdapter adapter = new
                SpinnerAdapter(this,R.layout.spinner_layout,R.id.lblCategorias,list);
        sp.setAdapter(adapter);
        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {Toast.makeText(adapterView.getContext(),
                    getString(R.string.msgSeleccionado).toString() +" "+((ItemData) adapterView.getItemAtPosition(i)).getTextCategoria(),
                    Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
    }
}