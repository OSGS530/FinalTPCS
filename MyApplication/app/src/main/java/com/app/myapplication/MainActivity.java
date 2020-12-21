package com.app.myapplication;

import android.content.Intent;
import android.os.Bundle;

import com.app.myapplication.pojo.Empleado;
import com.app.myapplication.pojo.EmpleadoAdapter;
import com.app.myapplication.remote.APIUtils;
import com.app.myapplication.remote.PersonaService;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.security.identity.AccessControlProfileId;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    Button btnAddEmpleado;
    Button btnGetEmpleadoList;
    ListView listView;

    PersonaService personaService;
    List<Empleado> list = new ArrayList<Empleado>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle("Mis Empleados");
        btnAddEmpleado = (Button)findViewById(R.id.btnAddUser);
        btnGetEmpleadoList = (Button) findViewById(R.id.btnGetUsersList);
        listView = (ListView) findViewById(R.id.listView);
        personaService = APIUtils.getUserService();

        btnGetEmpleadoList.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){
                getEmpleadoList();
            }
        });

        btnAddEmpleado.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){
                Intent intent = new Intent(MainActivity.this, EmpleadoActivity.class);
                intent.putExtra("user_name", "");
                startActivity(intent);
            }
        });

    }

    public void getEmpleadoList(){
        Call<List<Empleado>> call = personaService.getEmpleados();
        call.enqueue(new Callback<List<Empleado>>() {
            @Override
            public void onResponse(Call<List<Empleado>> call, Response<List<Empleado>> response) {
                if(response.isSuccessful()){
                    list = response.body();
                    listView.setAdapter(new EmpleadoAdapter(MainActivity.this, R.layout.list_user,list));
                }
            }

            @Override
            public void onFailure(Call<List<Empleado>> call, Throwable t) {
                Log.e("Error: ",t.getMessage());
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

}
