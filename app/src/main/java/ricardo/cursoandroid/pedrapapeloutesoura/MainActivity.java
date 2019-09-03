package ricardo.cursoandroid.pedrapapeloutesoura;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {


    private String escolha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void selecionarPedra(View view){

        this.opcaoSelecionada( escolha="pedra");

    }
    public void selecionarPapel (View view){
        this.opcaoSelecionada(escolha="papel");
    }

    public void selecionarTesoura (View view){
        this.opcaoSelecionada(escolha =  "tesoura");
    }


    public void opcaoSelecionada(String escolha){
        this.escolha = escolha;

        ImageView imagemResultado = (ImageView) findViewById(R.id.imageResultado);
        TextView textoResultado = (TextView) findViewById(R.id.txtResultado);

        //gerar um numero aleatorio
        String[] opcoes = {"pedra", "papel", "tesoura"};
        int numero = (int) new Random().nextInt(opcoes.length);
        String escolhaApp = opcoes[numero];

        switch (escolhaApp){

            case "pedra" :
                imagemResultado.setImageResource(R.drawable.pedra);
                break;

            case "papel" :
                imagemResultado.setImageResource(R.drawable.papel);
                break;
            case "tesoura" :
                imagemResultado.setImageResource(R.drawable.tesoura);
                break;
        }

        if (    (escolhaApp=="pedra" && escolha=="tesoura") ||
                (escolhaApp=="papel" && escolha=="pedra") ||
                (escolhaApp=="tesoura" && escolha=="papel") ){//app ganhador
            textoResultado.setText("Você perdeu!");

        }else if((escolha=="pedra" && escolhaApp=="tesoura") ||
                (escolha=="papel" && escolhaApp=="pedra") ||
                (escolha=="tesoura" && escolhaApp=="papel")){ textoResultado.setText("Você ganhou!");
        }else {
            textoResultado.setText("Empatamos!");
        }


    }


}
