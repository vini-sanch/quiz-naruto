package greysanatomy.com.br.appquiznaruto;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Pergunta3 extends AppCompatActivity {

    RadioGroup rgPergunta3;
    Button btnProximo3;
    int pontos;
    String nomeUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pergunta3);
        Intent i = getIntent();

        rgPergunta3=(RadioGroup) findViewById(R.id.rgPergunta3);
        btnProximo3=(Button) findViewById(R.id.btnProximo3);

        Bundle valores = i.getExtras();
        pontos = valores.getInt("pontos");
        nomeUser = valores.getString("user");

        btnProximo3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int op = rgPergunta3.getCheckedRadioButtonId();

                if(op != -1){
                    if (op == R.id.rbPerguntaC4){
                        pontos += 2;
                    }

                    Intent i = new Intent(Pergunta3.this, Pergunta4.class);
                    i.putExtra("user", nomeUser);
                    i.putExtra("pontos", pontos);
                    startActivity(i);
                }
                else{
                    Toast.makeText(Pergunta3.this, "Por Favor, selecione uma opção!", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
