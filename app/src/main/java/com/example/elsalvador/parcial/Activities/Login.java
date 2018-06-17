package com.example.elsalvador.parcial.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.elsalvador.parcial.Interface.Conexion;
import com.example.elsalvador.parcial.Object.User;
import com.example.elsalvador.parcial.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Login extends AppCompatActivity{

    private EditText usernarmeEditText;
    private EditText passwordEditText;
    private Button singInButton;
    private Conexion conexion;
    private String baseUrl;
    private Retrofit retrofit;
    private Call<User> call;
    public static String globalToken;
    private Intent toNavDrawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginProcess();

    }

    public void loginProcess(){

        usernarmeEditText = findViewById(R.id.Correo);
        passwordEditText = findViewById(R.id.Contrasena);
        singInButton = findViewById(R.id.Boton);

        baseUrl = "http://gamenewsuca.herokuapp.com/";

        if(retrofit == null){
            retrofit = new retrofit2.Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        conexion = retrofit.create(Conexion.class);

        singInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                call = conexion.loginRequest(usernarmeEditText.getText().toString(), passwordEditText.getText().toString());

                call.enqueue(new Callback<User>() {
                    @Override
                    public void onResponse(Call<User> call, Response<User> response) {

                        if(response.code() != 401){
                            globalToken = response.body().getToken().toString();
                            toNavDrawer = new Intent(Login.this,Main2Activity.class);
                            startActivity(toNavDrawer);
                        }
                        else{
                            Toast.makeText(getApplicationContext(),"Usuario erroneo",Toast.LENGTH_LONG).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<User> call, Throwable t) {
                        Toast.makeText(getApplicationContext(),"Sin Conexion",Toast.LENGTH_LONG).show();
                    }
                });
            }
        });

    }

}