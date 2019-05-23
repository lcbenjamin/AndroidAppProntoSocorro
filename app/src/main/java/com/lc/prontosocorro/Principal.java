package com.lc.prontosocorro;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Principal extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
    }

    public void onclickListarUPS(View view){

        Intent intent = new Intent(this, ListaProntoSocorros.class);
        startActivity(intent);
    }

    public void onClickSocorrer(View view){

        Intent intent = new Intent(this, Socorrer.class);
        startActivity(intent);
    }
}
