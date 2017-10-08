package com.example.tassio.filmark;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.io.Serializable;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.android.volley.*;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    // Definição das variáveis do Main Activity
    private static final String TAG = MainActivity.class.getName();
    private Button btSearch;
    private EditText fieldSearch;
    private String url = "http://theapache64.xyz:8080/movie_db/search?keyword=";
    /*
    * OBS: Sobre a API: foi utilizado um outro site para a busca das informações dos filmes, devido
    * ao fato da API solicitada: OMDB API - ser um recurso que necessita de pagamento para utilização
    * e validação das chaves. O site utilizado acima corresponde ao mesmo sistema de consulta HTTP RESTful
    * somente alterando o tamanho do banco de dados, que por ser um servidor gratuito, deve ter menos informações
    * de filmes.
     */


    private JSONObject object = new JSONObject();

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
                sendRequestAndPrintResponse();
            }
        });
    }

    // Método de união das Strings da API do Buscador de Filmes + o título de procura inserido no campo
    private void sendRequestAndPrintResponse() {
        // Remoção dos campos com espaços inseridos pelo usuário
        String input = fieldSearch.getText().toString();
        input = input.replace(" ", "");

        // Início da busca via JSONObjectRequest
        JsonObjectRequest req = new JsonObjectRequest(Request.Method.GET, url + input, null, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {
                Log.d(TAG, response.toString());
                try {
                    // Coleta somente das informações do filme
                    object = response.getJSONObject("data");

                    Log.d(TAG, object.toString());
                    // Caso consiga a informação, mudar para a próxima janela
                    moveAct();
                } catch (JSONException e) {
                    // Caso não consiga a informação, dar resposta ao usuário do erro da palavra chave
                    Log.d(TAG, e.toString());
                    // Pedir ao usuário que tente novamente
                    Toast.makeText(getApplicationContext(),
                            "Erro na busca pela palavra-chave, tente novamente.", Toast.LENGTH_SHORT).show();
                }

            }
        }, new Response.ErrorListener() {
            // Caso haja erros de conexão, perguntar ao usuário e informá-lo que o dispositivo não consegue se conectar.
            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.println(error);

                VolleyLog.e("Error: ", error.getMessage());

                Toast.makeText(getApplicationContext(),
                        "Erro na pesquisa, seu celular está conectado?", Toast.LENGTH_SHORT).show();
            }
        });
        // Adicionando o request à fila de queue
        Volley.newRequestQueue(this).add(req);
    }

    // Método de passagem de informaões do filme para próxima tela + Passagem para proxima tela
    private void moveAct() {
        Intent it = new Intent(MainActivity.this, activity_film_detail.class);

        it.putExtra("json", object.toString());

        startActivity(it);
    }

}




