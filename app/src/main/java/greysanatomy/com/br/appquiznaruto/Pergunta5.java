package greysanatomy.com.br.appquiznaruto;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Pergunta5 extends AppCompatActivity {

    RadioGroup rgPergunta5;
    Button btnProximo5;
    int pontos;
    String nomeUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pergunta5);
        Intent i = getIntent();

        rgPergunta5=(RadioGroup) findViewById(R.id.rgPergunta5);
        btnProximo5=(Button) findViewById(R.id.btnProximo5);

        Bundle valores = i.getExtras();
        pontos = valores.getInt("pontos");
        nomeUser = valores.getString("user");

        btnProximo5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int op = rgPergunta5.getCheckedRadioButtonId();

                if(op != -1){
                    if (op == R.id.rbPerguntaC4){
                        pontos += 2;
                    }

                    Intent i = new Intent(Pergunta5.this, Pergunta6.class);
                    i.putExtra("user", nomeUser);
                    i.putExtra("pontos", pontos);
                    startActivity(i);
                }
                else{
                    Toast.makeText(Pergunta5.this, "Por Favor, selecione uma opção!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
