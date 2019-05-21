package com.lc.prontosocorro.webservice;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;

public class WebServiceUtils {

    public ArrayList<UnidadeProntoSocorroObj>  getUnidadesPS(String end) {

        String json = NetworkUtils.getJSONFromAPI(end);
        ArrayList<UnidadeProntoSocorroObj> retorno = parseJson(json);
        Log.i("Resultado", json);

        return retorno;
    }

    private ArrayList<UnidadeProntoSocorroObj> parseJson(String json) {

        try {

            ArrayList<UnidadeProntoSocorroObj> listaUnidadesPS = new ArrayList<>();


            JSONObject jsonObj = new JSONObject(json);
            JSONArray arrayFeatures = jsonObj.getJSONArray("features");

            // Iteração dentro da lista de objetos Json recebido
            for (int i=0; i < arrayFeatures.length(); i++) {

                UnidadeProntoSocorroObj unidade = new UnidadeProntoSocorroObj();
                JSONObject objArray = arrayFeatures.getJSONObject(i);

                //Atribui a propriedade
                JSONObject propriedade = objArray.getJSONObject("properties");
                unidade.setNome(propriedade.getString("NMUNIDAD"));
                unidade.setEndereco(propriedade.getString("NMENDUNID"));
                unidade.setTipoPatrimonio(propriedade.getString("NMPATRIM"));
                unidade.setTipoUnidade(propriedade.getString("CDTIPO"));

                //Atribui GeoLocalizacao

                // Implementacao FUTURA

                listaUnidadesPS.add(unidade);
            }

            return listaUnidadesPS;

        } catch (JSONException e) {

            e.printStackTrace();
            return null;

        }
    }

}