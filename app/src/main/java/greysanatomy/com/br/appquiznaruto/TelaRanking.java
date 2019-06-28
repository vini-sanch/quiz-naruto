package greysanatomy.com.br.appquiznaruto;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import greysanatomy.com.br.appquiznaruto.DAO.JogadorDAO;
import greysanatomy.com.br.appquiznaruto.Model.Jogador;

public class TelaRanking extends AppCompatActivity {
    ListView listRanking;
    Button btnHome;
    JogadorDAO jDao;
    ArrayList<Jogador> listArray;
    ArrayAdapter<Jogador> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_ranking);

        listRanking = (ListView) findViewById(R.id.lstRanking);
        registerForContextMenu(listRanking);
        btnHome = (Button) findViewById(R.id.btnHome);
        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(TelaRanking.this, MainActivity.class);
                startActivity(i);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        preencherLista();
    }

    public void preencherLista(){
        jDao = new JogadorDAO(TelaRanking.this);

        listArray = jDao.selectAllJogador();
        jDao.close();

        if (listRanking != null){
            arrayAdapter = new ArrayAdapter<Jogador>(
                    TelaRanking.this,
                    android.R.layout.simple_list_item_1,
                    listArray);

            listRanking.setAdapter(arrayAdapter);
        }
    }
}
