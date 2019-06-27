package greysanatomy.com.br.appquiznaruto;

import android.content.Intent;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;

public class Pergunta6 extends AppCompatActivity {

    RadioGroup rgPergunta6;
    Button btnproximo6;
    int pontos;
    String nomeUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pergunta6);
        Intent i = getIntent();

        rgPergunta6=(RadioGroup) findViewById(R.id.rgPerguta6);
        btnproximo6=(Button) findViewById(R.id.btnproximo6);

        Bundle valores = i.getExtras();
        pontos = valores.getInt("pontos");
        nomeUser = valores.getString("user");

        btnproximo6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int op = rgPergunta6.getCheckedRadioButtonId();

                if (op == R.id.rbPerguntaF3){
                    pontos += 2;
                }

                else{
                    pontos += 0;
                }

                Intent i = new Intent();
                i.putExtra("user", nomeUser);
                i.putExtra("pontos", pontos);

                /*Intent next = new Intent(Pergunta6.this);
                startActivity(next); :D */
            }
        });
    }
}
