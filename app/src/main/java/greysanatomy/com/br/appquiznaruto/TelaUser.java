package greysanatomy.com.br.appquiznaruto;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class TelaUser extends AppCompatActivity {
    EditText edtNomeUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_user);

        edtNomeUser = (EditText) findViewById(R.id.edtNomeUser);
    }

    public void userControls(View v){
        Intent i = new Intent(v.getContext(), Pergunta1.class);
        i.putExtra("user", edtNomeUser.getText().toString().trim());
        startActivity(i);
    }

}
