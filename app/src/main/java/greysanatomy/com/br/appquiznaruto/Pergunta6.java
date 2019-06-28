package greysanatomy.com.br.appquiznaruto;

import android.content.Intent;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;

import greysanatomy.com.br.appquiznaruto.DAO.JogadorDAO;
import greysanatomy.com.br.appquiznaruto.Model.Jogador;

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


                if(op != -1){
                    if (op == R.id.rbPerguntaF3){
                        pontos += 2;
                    }

                    cadastrarJogador();
                }
                else{
                        Toast.makeText(Pergunta6.this, "Por Favor, selecione uma opção!", Toast.LENGTH_SHORT).show();
                }

                /*Intent i = new Intent();
                i.putExtra("user", nomeUser);
                i.putExtra("pontos", pontos);*/

                /*Intent next = new Intent(Pergunta6.this);
                startActivity(next); :D */
            }
        });
    }

    private void cadastrarJogador(){
        Jogador j = new Jogador();
        long retorno;
        
        j.setPontos(pontos);
        j.setNome(nomeUser);

        JogadorDAO jDao = new JogadorDAO(Pergunta6.this);
        retorno = jDao.salvarJogador(j);
        jDao.close();

        Intent i = new Intent();

        if(retorno == -1) {
            Toast.makeText(this, "Ocorreu Um Erro Com A Conexão!", Toast.LENGTH_SHORT).show();
            i.setClass(Pergunta6.this, TelaUsuario.class);
        }
        else{
            i.setClass(Pergunta6.this, TelaRanking.class);
        }

        startActivity(i);
    }
}
