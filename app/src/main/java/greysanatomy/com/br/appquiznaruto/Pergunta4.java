package greysanatomy.com.br.appquiznaruto;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;

public class Pergunta4 extends AppCompatActivity {

    RadioGroup rgPergunta4;
    Button btnProximo4;
    int pontos;
    String nomeUser;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pergunta4);
        Intent i = getIntent();

        rgPergunta4=(RadioGroup) findViewById(R.id.rgPergunta5);
        btnProximo4=(Button) findViewById(R.id.btnProximo4);

        Bundle valores = i.getExtras();
        pontos = valores.getInt("pontos");
        nomeUser = valores.getString("user");

        btnProximo4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int op = rgPergunta4.getCheckedRadioButtonId();

                if (op == R.id.rbPerguntaD2){
                    pontos += 2;
                }

                else{
                    pontos += 0;
                }

                Intent i =  new Intent();
                i.putExtra("user", nomeUser);
                i.putExtra("pontos", pontos);

                Intent next = new Intent(Pergunta4.this, Pergunta5.class);
                startActivity(next);
            }
        });
    }
}
