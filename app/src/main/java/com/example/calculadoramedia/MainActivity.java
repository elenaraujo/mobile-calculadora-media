package com.example.calculadoramedia;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText notaA1, notaA2, notaA3;
    TextView resultado, aviso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        notaA1 = (EditText) findViewById(R.id.inputA1);
        notaA2 = (EditText) findViewById(R.id.inputA2);
        notaA3 = (EditText) findViewById(R.id.inputA3);
        resultado = (TextView) findViewById(R.id.textResultado);
        aviso = (TextView) findViewById(R.id.textAviso);
    }
    public void calcular(View v) {

        String n1 = notaA1.getText().toString();
        String n2 = notaA2.getText().toString();
        String n3 = notaA3.getText().toString();

        if(!n1.isEmpty() && !n2.isEmpty()) {
            aviso.setText("");
            float nota1 = Float.parseFloat(n1);
            float nota2 = Float.parseFloat(n2);
            float maiorNota = nota2;

            if(!n3.isEmpty()) {
                float nota3 = Float.parseFloat(n3);
                if(nota3 > nota2) maiorNota = nota3;
            }

            if(nota1 < 0.1 || maiorNota < 5) {
                double notaFinal = (nota1*0.4) + (maiorNota*0.6) / 2;
                resultado.setText(String.format("%,.2f", notaFinal) + " - Reprovado");
            } else {
                double notaFinal = (nota1*0.4) + (maiorNota*0.6);

                if(notaFinal >= 6) {
                    resultado.setText(String.format("%,.2f", notaFinal) + " - Aprovado");
                } else {
                    resultado.setText(String.format("%,.2f", notaFinal) + " - Reprovado");
                }
            }
        } else {
            resultado.setText("");
            aviso.setText("Os campos \"Nota da A1\" e \"Nota da \"A2\" são obrigatórios");
        }
    }

    public void limpar(View v) {
        notaA1.setText("");
        notaA2.setText("");
        notaA3.setText("");
        resultado.setText("");
        aviso.setText("");
    }
}