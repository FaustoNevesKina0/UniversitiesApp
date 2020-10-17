package br.usjt.ads20.prova;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;

import com.facebook.stetho.Stetho;

import java.io.IOException;
import java.util.ArrayList;

import br.usjt.ads20.prova.model.Universidade;
import br.usjt.ads20.prova.model.UniversidadeNetwork;
/**
 * Fausto Neves Kina
 * RA 81820328
 */
public class MainActivity extends AppCompatActivity {
    private EditText txtNome;
    public static final String NOME = "br.usjt.ads20.appfilmes.nome";
    public static final String UNIVERSIDADES = "br.usjt.ads20.appfilmes.universidades";
    private ProgressBar progressBar;

    private String url = "http://universities.hipolabs.com/search?name=";
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Stetho.initializeWithDefaults(this);

        progressBar = findViewById(R.id.progressBarMainActivity);
        txtNome = (EditText) findViewById(R.id.busca_fila);
        context = this;
    }

    public void buscar(View view) {
        progressBar.setVisibility(View.VISIBLE);
        new getUniversidades().execute(url + txtNome.getText().toString());
    }

    private class getUniversidades extends AsyncTask<String, Void, ArrayList<Universidade>> {
        @Override
        protected ArrayList<Universidade> doInBackground(String... strings) {
            ArrayList<Universidade> universidades = new ArrayList<>();
            try {
                universidades = UniversidadeNetwork.buscarUniversidades(strings[0]);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return universidades;
        }

        @Override
        protected void onPostExecute(ArrayList<Universidade> universidades) {
            progressBar.setVisibility(View.INVISIBLE);
            Intent intent = new Intent(context, ListarUniversidadesActivity.class);
            String nome = txtNome.getText().toString();
            intent.putExtra(NOME, nome);
            intent.putExtra(UNIVERSIDADES, universidades);
            startActivity(intent);
        }
    }
}