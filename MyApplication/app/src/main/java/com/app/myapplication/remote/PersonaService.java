package com.app.myapplication.remote;

import android.app.Person;

import com.app.myapplication.pojo.Empleado;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface PersonaService {
    @GET("generic")
    Call<List<Empleado>> getEmpleados();
    @POST("generic")
    Call<Empleado> addEmpleado (@Body Empleado empleado);
    @PUT("generic")
    Call<Empleado> updateEmpleado(int id, @Body Empleado empleado);
    @DELETE("generic/{id}")
    Call<Empleado> deleteEmpleado(@Path("id") int id);
}
