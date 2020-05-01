package com.example.proyectof;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class Registro extends AppCompatActivity {

    EditText etUsuario, etPasswd, etConfPasswd;
    Button btnReg;
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        etUsuario = findViewById(R.id.etUsuario);
        etPasswd = findViewById(R.id.etPasswd);
        etConfPasswd = findViewById(R.id.etPasswd);

        btnReg = findViewById(R.id.btnReg);

        spinner = (Spinner) findViewById(R.id.spinnerTipoUsuario);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(Registro.this, R.array.tipoUsuarios, R.layout.spinner_item);

        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String elemento = (String) spinner.getAdapter().getItem(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        btnReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usuario, passwd, confPasswd, spinnerUsu;

                usuario = etUsuario.getText().toString();
                passwd = etPasswd.getText().toString();
                confPasswd = etConfPasswd.getText().toString();

                if (passwd.equals("") && passwd.equals("") && confPasswd.equals("") && spinner.getSelectedItemPosition() == 0) {
                    Toast.makeText(Registro.this, "Rellenar todos los campos", Toast.LENGTH_SHORT).show();
                }
                else if (usuario.equals("")) {
                    Toast.makeText(Registro.this, "Nombre de usuario requerido", Toast.LENGTH_SHORT).show();
                }
                else if (passwd.equals("")) {
                    Toast.makeText(Registro.this, "Contraseña requerida", Toast.LENGTH_SHORT).show();
                }
                else if (confPasswd.equals("")) {
                    Toast.makeText(Registro.this, "Contraseña requerida", Toast.LENGTH_SHORT).show();
                }
                else if (!confPasswd.equals(passwd)) {
                    Toast.makeText(Registro.this, "La contraseña no coincide", Toast.LENGTH_SHORT).show();
                }
                else if(spinner.getSelectedItemPosition() == 0) {
                    Toast.makeText(Registro.this, "Selecciona un tipo de usuario", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(Registro.this, "Usuario registrado", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
