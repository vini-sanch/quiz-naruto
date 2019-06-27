package greysanatomy.com.br.appquiznaruto.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.security.Policy;
import java.util.ArrayList;

import greysanatomy.com.br.appquiznaruto.Model.Jogador;

public class JogadorDAO extends SQLiteOpenHelper {
    private static final String NOME_BANCO = "DBJogador.db";
    private static final int VERSAO = 1;
    private static final String TABELA = "tbjogador";
    private static final String ID = "id";
    private static final String NOME = "nome";
    private static final String PONTOS = "pontos";

    public JogadorDAO(Context context){
        super(context, NOME_BANCO, null, VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //Criaçao da tabela
        String sql = "CREATE TABLE " + TABELA + " ( " +
                " " + ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                " " + NOME + " TEXT," +
                " " + PONTOS + " INTEGER );";

        //Execução do comando SQL
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //Atualização da tabela pela versão do banco
        String sql = " DROP TABLE IF EXISTS " + TABELA;
        db.execSQL(sql);
        onCreate(db);
    }

    public long salvarPessoa(Jogador j){
        ContentValues valores = new ContentValues();
        long retornoDB;

        valores.put(NOME, j.getNome());
        valores.put(PONTOS, j.getPontos());

        retornoDB = getWritableDatabase().insert(TABELA, null, valores);

        return retornoDB;
    }

    public ArrayList<Jogador> selectAllPessoa(){
        String[] colunas = {ID, NOME, PONTOS};

        //EXIBIR NA ORDEM DE PONTUAÇÃO
        Cursor cursor = getWritableDatabase()
                .query(TABELA, colunas, null, null,
                        null, null, "pontos", null);

        ArrayList<Jogador> listJogador = new ArrayList<Jogador>();

        while (cursor.moveToNext()){
            Jogador p = new Jogador();
            p.setId(cursor.getInt(0)); //0 é o indice do campo id np bd
            p.setNome(cursor.getString(1));
            p.setPontos(cursor.getInt(2));

            listJogador.add(p);
        }

        return listJogador;
    }
}
