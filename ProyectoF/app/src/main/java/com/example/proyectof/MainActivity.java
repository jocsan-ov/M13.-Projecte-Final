package com.example.proyectof;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etUsuario, etPasswd;
    Button btnLogin;
    TextView tvReg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etUsuario = findViewById(R.id.etUsuario);
        etPasswd = findViewById(R.id.etPasswd);

        btnLogin = findViewById(R.id.btnLogin);
        tvReg = findViewById(R.id.tvReg);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usuario, passwd;

                usuario = etUsuario.getText().toString();
                passwd = etPasswd.getText().toString();

                if (passwd.equals("") && usuario.equals("")) {
                    Toast.makeText(MainActivity.this, "Hay campos sin rellenar", Toast.LENGTH_SHORT).show();
                }
                else if (usuario.equals("")) {
                    Toast.makeText(MainActivity.this, "Usuario requerido", Toast.LENGTH_SHORT).show();
                }
                else if (passwd.equals("") ) {
                    Toast.makeText(MainActivity.this, "Contraseña requerida", Toast.LENGTH_SHORT).show();
                }
                else {
                    Intent i = new Intent(MainActivity.this, Inicio.class);
                    startActivity(i);
                    finish();
                }
            }
        });

        tvReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, Registro.class);
                startActivity(i);
                finish();
            }
        });
    }
}
