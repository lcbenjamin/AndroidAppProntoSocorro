package com.lc.prontosocorro;

import android.os.Bundle;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import com.lc.prontosocorro.webservice.UnidadeProntoSocorroObj;
import com.lc.prontosocorro.webservice.WebServiceUtils;
import java.util.ArrayList;

public class ListaProntoSocorros extends AppCompatActivity {

    private ProgressDialog load;
    private ArrayList<UnidadeProntoSocorroObj> unidadesProntoSocorro;
    private static String URL_WEBSERVICE ="http://dados.recife.pe.gov.br/dataset/08a65119-e0a1-4e70-9276-b975034980a0/resource/b309d41b-6eb2-4bdd-af6e-581be5f8e239/download/saudemunicipalestadual.geojson";
    private ListView listaUnidadesSaude;


    @Override
    protected void onCreate(Bundle icicle) {
        super.onCreate(icicle);

        setContentView(R.layout.lista_todas_unidades);
        listaUnidadesSaude = findViewById(R.id.listaTodasUnidades);
        GetJson download = new GetJson();
        download.execute();
    }

    public void iniciaAdapter(){

        ArrayAdapter<UnidadeProntoSocorroObj> adapter = new ArrayAdapter<>(this,
                android.R.layout.select_dialog_item,unidadesProntoSocorro);

        listaUnidadesSaude.setAdapter(adapter);

    }

    private class GetJson extends AsyncTask<Void, Void, ArrayList<UnidadeProntoSocorroObj>> {

        @Override
        protected void onPreExecute(){
            load = ProgressDialog.show(ListaProntoSocorros.this,
                    "Por favor Aguarde ...", "Recuperando Informações do Servidor...");
        }

        @Override
        protected ArrayList<UnidadeProntoSocorroObj> doInBackground(Void... params) {

            WebServiceUtils util = new WebServiceUtils();
            return  util.getUnidadesPS(URL_WEBSERVICE);
        }

        @Override
        protected void onPostExecute(ArrayList<UnidadeProntoSocorroObj> ups){
            unidadesProntoSocorro = ups;
            load.dismiss();

            iniciaAdapter();

            }
    }

}
