package greysanatomy.com.br.appquiznaruto;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Pergunta2 extends AppCompatActivity {

    RadioGroup rgPergunta2;
    Button btnProximo2;
    int pontos;
    String nomeUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pergunta2);
        Intent i = getIntent();

        rgPergunta2=(RadioGroup) findViewById(R.id.rgPergunta2);
        btnProximo2=(Button) findViewById(R.id.btnProximo2);

        Bundle valores = i.getExtras();
        pontos = valores.getInt("pontos");
        nomeUser = valores.getString("user");

        btnProximo2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int op = rgPergunta2.getCheckedRadioButtonId();

                if(op != -1){
                    if (op == R.id.rbPerguntaC4){
                        pontos += 2;
                    }

                    Intent i = new Intent(Pergunta2.this, Pergunta3.class);
                    i.putExtra("user", nomeUser);
                    i.putExtra("pontos", pontos);
                    startActivity(i);
                }
                else{
                    Toast.makeText(Pergunta2.this, "Por Favor, selecione uma opção!", Toast.LENGTH_SHORT).show();
                }
            }
        });



    }
}
