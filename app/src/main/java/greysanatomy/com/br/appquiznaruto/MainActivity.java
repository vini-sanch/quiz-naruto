package greysanatomy.com.br.appquiznaruto;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import static android.view.MotionEvent.ACTION_DOWN;
import static android.view.MotionEvent.ACTION_UP;

public class MainActivity extends AppCompatActivity {

    private Button btnStart, btnInfo;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnStart = (Button) findViewById(R.id.btnStart);
        btnInfo = (Button) findViewById(R.id.btnInfo);

        btnStart.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == ACTION_DOWN){
                    btnStart.setBackground(getResources().getDrawable(R.drawable.botao_design2));
                    btnStart.setTextColor(getResources().getColor(R.color.colorAccent));
                }
                else if(event.getAction() == ACTION_UP){
                    btnStart.setBackground(getResources().getDrawable(R.drawable.botao_design1));
                    btnStart.setTextColor(getResources().getColor(R.color.color3));
                }
                return false;
            }
        });

        btnInfo.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == ACTION_DOWN){
                    btnInfo.setCompoundDrawablesRelativeWithIntrinsicBounds(
                            getResources().getDrawable(R.drawable.ic_naruto_symbol2),
                            null,
                            null,
                            null);
                    btnInfo.setBackground(getResources().getDrawable(R.drawable.botao_design2));
                    btnInfo.setTextColor(getResources().getColor(R.color.colorAccent));
                }
                else if(event.getAction() == ACTION_UP){
                    btnInfo.setCompoundDrawablesRelativeWithIntrinsicBounds(
                            getResources().getDrawable(R.drawable.ic_folha_symbol),
                            null,
                            null,
                            null);
                    btnInfo.setBackground(getResources().getDrawable(R.drawable.botao_design1));
                    btnInfo.setTextColor(getResources().getColor(R.color.color3));
                }
                return false;
            }
        });
    }

    public void startQuiz(View v){
        Intent next = new Intent(MainActivity.this, User.class);
        startActivity(next);
    }
}