package greysanatomy.com.br.appquiznaruto;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btnStart, btnInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnStart = (Button) findViewById(R.id.btnStart);
        btnInfo = (Button) findViewById(R.id.btnInfo);
    }

    // Indo para a tela de informação
    public void nextInfo(View v){
        Context c = v.getContext();
        Intent next = new Intent(c, TelaInfo.class);
        startActivity(next);
    }

    // Indo para a tela de usuário
    public void nextUser(View v){
        //pegando o contexto da div (A activity que chamou o evento)
        Context c = v.getContext();
        //Instanciando o objeto next que fará a transição para a próxima tela
        Intent next = new Intent(c, TelaUser.class);

        //indo para a próxima tela
    }

    public void startQuiz(View v){
        Intent next = new Intent(MainActivity.this, Pergunta1.class);
        startActivity(next);
    }
}
