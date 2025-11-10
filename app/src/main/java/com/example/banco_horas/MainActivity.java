package com.example.banco_horas;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.banco_horas.banco.UsuarioBanco;
import com.example.banco_horas.model.Usuario;

public class MainActivity extends AppCompatActivity {

    EditText edit_email, edit_password;
    TextView resultado;
    Button btn_enter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edit_email =  findViewById(R.id.edit_email);
        edit_password =  findViewById(R.id.edit_password);
        btn_enter = findViewById(R.id.btn_enter);
        resultado = findViewById(R.id.resultado);
    }


    public void login(View v){
        String email = edit_email.getText().toString();
        String senha = edit_password.getText().toString();

        Usuario usu = new UsuarioBanco().selecionarUsuario(email, senha);
        if (usu != null){
            Intent intent = new Intent(MainActivity.this, MenuPrincipal.class);
            startActivity(intent);

            finish();
        }else {
            resultado.setText("Usuario ou Senha Invalido");
            limpar();
        }


    }


    private void limpar(){
        edit_email.setText("");
        edit_password.setText("");
    }

}