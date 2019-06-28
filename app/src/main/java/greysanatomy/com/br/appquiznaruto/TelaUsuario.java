package greysanatomy.com.br.appquiznaruto;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class TelaUsuario extends AppCompatActivity {
    EditText edtNomeUser;
    Button btnProximo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_usuario);

        edtNomeUser = (EditText) findViewById(R.id.edtNomeUser);
        btnProximo = (Button) findViewById(R.id.btnProximoUser);

        btnProximo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nome = edtNomeUser.getText().toString().trim();

                if(nome.length() > 0){
                    Intent i = new Intent(TelaUsuario.this, Pergunta1.class);
                    i.putExtra("user", nome);
                    startActivity(i);
                }
                else{
                    edtNomeUser.setError("Por favor, digite seu nome de usuário :)");
                }
            }
        });
    }
}

