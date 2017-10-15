package com.example.tassio.filmark;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.android.volley.*;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    // Definição das variáveis do Main Activity
    private static final String TAG = MainActivity.class.getName();
    private Button btSearch;
    private EditText fieldSearch;
    private HTTPConnection httpConnection = new HTTPConnection();
    JSONArray cast;

    /*
    OBS: Sobre a API: foi utilizado um outro site para a busca das informações dos filmes
    (temporáriamente), devido ao fato da API solicitada: OMDB API - ser um recurso que necessita de
    pagamento para utilização e validação das chaves. O site utilizado acima corresponde ao mesmo
    sistema de consulta HTTP RESTful somente alterando as funcionalidades e o tamanho do banco de dados,
    que por ser um servidor gratuito, deve ter menos informações de filmes.
     */

    /*
    OBS2: Foi encontrado uma API que será utilizada no lugar dessa genérica, nessa API é necessário
    o uso de chaves e token de autenticação, e será possível listar os filmes antes de abrir os
    detalhes do selecionado.
    */

    @Override // Método a ser executado no início da aplicação
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Veiculação do botão de procura e do campo da barra de procura
        btSearch = (Button) findViewById(R.id.btSearch);
        fieldSearch = (EditText) findViewById(R.id.fieldSearch);

        btSearch.setOnClickListener(new View.OnClickListener() {
            // Método a ser executado ao apertar o botão de procura
            public void onClick(View v){
                httpConnection.sendSearchMovie(getApplicationContext(), fieldSearch.getText().toString(), new SearchCallBack() {
                    @Override
                    public void onAnswer(JSONObject result) {
                        try {
                            cast = result.getJSONArray("results");
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        moveAct();
                    }
                });
            }
        });
    }

    // Método de passagem de informaões do filme para próxima tela + Passagem para proxima tela
    private void moveAct() {
        Intent it = new Intent(MainActivity.this, FilmList.class);

        it.putExtra("jsonArray", cast.toString());

        startActivity(it);
    }

    public interface SearchCallBack {
        void onAnswer(JSONObject result);
    }





}




