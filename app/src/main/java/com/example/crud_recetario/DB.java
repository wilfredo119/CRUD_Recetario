package com.example.crud_recetario;

import android.content.ContentValues;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DB extends SQLiteOpenHelper {
    public DB(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, "prueba", factory, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table datos(nombre text, ingredientes text, categoria text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
    public String guardar (String nombre , String ingredientes, String categoria){
        String mensaje = "";
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues contenedor = new ContentValues();
        contenedor.put("nombre", nombre);
        contenedor.put("ingredientes", ingredientes);
        contenedor.put("categoria", categoria);
        try {
            database.insertOrThrow("datos",null, contenedor);
            mensaje="Ingresado Correctamente";

        }catch (SQLException e){
            mensaje="Error, al Ingresar";
        }
        return mensaje;
    }

}
