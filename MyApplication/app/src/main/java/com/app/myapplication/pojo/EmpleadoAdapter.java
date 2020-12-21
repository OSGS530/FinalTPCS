package com.app.myapplication.pojo;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;

import com.app.myapplication.EmpleadoActivity;
import com.app.myapplication.R;

import java.util.List;

public class EmpleadoAdapter extends ArrayAdapter<Empleado>{
    private Context context;
    private List<Empleado> emp;

    public EmpleadoAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<Empleado> objects) {
        super(context, resource, objects);
        this.context = context;
        this.emp = objects;
    }
    @Override
    public View getView(final int pos, View convertView, ViewGroup parent){
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.list_user, parent, false);

        TextView txtUserId = (TextView) rowView.findViewById(R.id.txtUserId);
        TextView txtUsername = (TextView) rowView.findViewById(R.id.txtEmpleadoName);
        TextView txtTelefono = (TextView) rowView.findViewById(R.id.txtTelefono);
        TextView txtDireccion = (TextView) rowView.findViewById(R.id.txtDireccion);

        txtUserId.setText(String.format("#ID: %s", emp.get(pos).getClave()));
        txtUsername.setText(String.format("Nombre: %s", emp.get(pos).getNombre()));
        txtDireccion.setText(String.format("Direccion: %s", emp.get(pos).getDireccion()));
        txtTelefono.setText(String.format("Telefono: %s", emp.get(pos).getTelefono()));

        rowView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //start Activity User Form
                Intent intent = new Intent(context, EmpleadoActivity.class);
                intent.putExtra("Empleado_id", String.valueOf(emp.get(pos).getClave()));
                intent.putExtra("Empleado_name", emp.get(pos).getNombre());
                intent.putExtra("Empleado_direccion", emp.get(pos).getDireccion());
                intent.putExtra("Empleado_telefono", emp.get(pos).getTelefono());

                context.startActivity(intent);
            }
        });

        return rowView;
    }
}

