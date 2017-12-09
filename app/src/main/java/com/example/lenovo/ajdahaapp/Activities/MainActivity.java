package com.example.lenovo.ajdahaapp.Activities;

import android.app.Dialog;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.example.lenovo.ajdahaapp.R;

import org.json.JSONArray;

import java.util.List;

import HTTPConnections.HttpOperations;
import HTTPConnections.ServerCallback;
import SQLiteConnections.DBSql;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnCl, btnWh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCl = (Button) findViewById(R.id.btnCl);
        btnWh = (Button) findViewById(R.id.btnWh);
        btnCl.setOnClickListener(this);
        btnWh.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnCl:

                /*ContentValues cv = new ContentValues();
                cv.put("CODE", 666);
                cv.put("NAME", "ELSAFA");
                cv.put("DEPARTMENT", 0);
                cv.put("BRANCH", 1);
                db.insert("SLSMANS", null, cv);
*/
                myCustomDialog().show();
                /*Intent clIntend = new Intent(this, ClOperations.class);
                startActivity(clIntend);*/
                break;
            case R.id.btnWh:



                /*Cursor cursor = db.query("SLSMANS", null, null, null, null, null, null);
                if (cursor.moveToFirst()) {
                    do {
                        Log.d("SQL RETURNS", "Code: " + cursor.getInt(cursor.getColumnIndex("CODE")) +
                                "Name: " + cursor.getString(cursor.getColumnIndex("NAME"))
                        );
                    }
                    while (cursor.moveToNext());

                }else
                    Log.d("SQL RETURNS","Hew zad yoxdu");
                cursor.close();


                Intent whIntend = new Intent(this, WhOperations.class);
                startActivity(whIntend);*/
                break;
        }

    }

    public Dialog myCustomDialog() {
        AlertDialog.Builder d = new AlertDialog.Builder(MainActivity.this);
        View dialogView = getLayoutInflater().inflate(R.layout.dialog_cl_operations, null);
        Button dbtnOk, dbtnCancel;
        dbtnOk = (Button) dialogView.findViewById(R.id.dbtnOk);
        dbtnCancel = (Button) dialogView.findViewById(R.id.dbtnCancel);
        Spinner spinner = (Spinner) dialogView.findViewById(R.id.spRoot);


        HttpOperations h = new HttpOperations();
        //String url="http://192.168.43.80:8080/rest/salesman";
        String url="http://192.168.5.239:8080/rest/salesman";

        h.getJsonArrayResponse(url, MainActivity.this, new ServerCallback() {
            @Override
            public void onSuccess(JSONArray jsonArray) {
                DBSql db = new DBSql(MainActivity.this);
                db.updateSlsMans(jsonArray);
            }
        });

        DBSql db = new DBSql(MainActivity.this);
        List<String> salesManList = db.getSlsMans();

        spinner.setAdapter(new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_spinner_dropdown_item, salesManList));

        d.setView(dialogView);
        final AlertDialog dialog = d.create();

        dbtnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        return dialog;


    }
}
