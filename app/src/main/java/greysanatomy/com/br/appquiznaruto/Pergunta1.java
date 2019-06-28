package greysanatomy.com.br.appquiznaruto;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Pergunta1 extends AppCompatActivity {

    RadioGroup rgPergunta1;
    Button btnProximo1;
    String nomeUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pergunta1);
        Intent telaAnterior = getIntent();
        Bundle valores = telaAnterior.getExtras();
        nomeUser = valores.getString("user");

        rgPergunta1=(RadioGroup) findViewById(R.id.rgPergunta1);
        btnProximo1=(Button) findViewById(R.id.btnproximo1);

        btnProximo1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int op = rgPergunta1.getCheckedRadioButtonId();
                int pontos = 0;

                if(op != -1){
                    if (op == R.id.rbPerguntaA1){
                        pontos += 2;
                    }

                    Intent i = new Intent(Pergunta1.this, Pergunta2.class);
                    i.putExtra("user", nomeUser);
                    i.putExtra("pontos", pontos);
                    startActivity(i);
                }
                else{
                    Toast.makeText(Pergunta1.this, "Por Favor, selecione uma opção!", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
