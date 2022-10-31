package com.example.nomina_trabajador;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText jethoras_trabajadas,jetbasico_hora,jetaños_trabajo,jetdeduccion_mensual;
    TextView jtvbruto_mes,jtvbonificacion_mes,jtvdeduccion_mes,jtvneto_mes;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Ocultar la barra de titulos por defecto
        getSupportActionBar().hide();

        //Asociar los objetos Java con los objetos Xml
        jethoras_trabajadas=findViewById(R.id.ethoras_trabajadas);
        jetbasico_hora=findViewById(R.id.etbasico_hora);
        jetdeduccion_mensual=findViewById(R.id.etdeduccion_mensual);
        jetaños_trabajo=findViewById(R.id.etaños_trabajo);
        jtvbruto_mes=findViewById(R.id.tvbruto_mes);
        jtvbonificacion_mes=findViewById(R.id.tvbonificacion_mes);
        jtvdeduccion_mes=findViewById(R.id.tvdeduccion_mes);
        jtvneto_mes=findViewById(R.id.tvneto_mes);

    }

    public void Calcular_salario(View view){
        String horas_trabajo,basico_hor,tiempo_trabajo,deduccion_mes;
        horas_trabajo=jethoras_trabajadas.getText().toString();
        basico_hor=jetbasico_hora.getText().toString();
        tiempo_trabajo=jetaños_trabajo.getText().toString();
        deduccion_mes=jetdeduccion_mensual.getText().toString();
        if (horas_trabajo.isEmpty() || basico_hor.isEmpty() || tiempo_trabajo.isEmpty() || deduccion_mes.isEmpty()){
            Toast.makeText(this, "Todos los campos son requeridos", Toast.LENGTH_SHORT).show();
        }
        else{
            //Definicion de variables y conversion de tipos de datos
            int cant_horas_traba,cant_basic,cant_tiempo,cant_deduc,bruto_mes,bonificacion_mes,deduc_mes,neto_mes;
            cant_horas_traba=Integer.parseInt(horas_trabajo);
            cant_basic=Integer.parseInt(basico_hor);
            cant_tiempo=Integer.parseInt(tiempo_trabajo);
            cant_deduc=Integer.parseInt(deduccion_mes);
            bruto_mes= cant_horas_traba * cant_basic;
            bonificacion_mes= cant_tiempo * 30000;
            deduc_mes= cant_deduc;
            neto_mes= bruto_mes - deduc_mes + bonificacion_mes;

            //Imprimir resultados
            jtvbruto_mes.setText(String.valueOf(bruto_mes));
            jtvbonificacion_mes.setText(String.valueOf(bonificacion_mes));
            jtvdeduccion_mes.setText(String.valueOf(deduc_mes));
            jtvneto_mes.setText(String.valueOf(neto_mes));
        }
    }

    public void Limpiar_datos(View view){
        jethoras_trabajadas.setText("");
        jetbasico_hora.setText("");
        jetaños_trabajo.setText("");
        jetdeduccion_mensual.setText("");
        jtvbruto_mes.setText("");
        jtvbonificacion_mes.setText("");
        jtvdeduccion_mes.setText("");
        jtvneto_mes.setText("");
        jethoras_trabajadas.requestFocus();
    }

}