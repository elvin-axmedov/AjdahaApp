package HTTPConnections;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.lenovo.ajdahaapp.Activities.MainActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import SQLiteConnections.DBSql;
import models.SalesMan;

/**
 * Created by Lenovo on 19-Nov-17.
 */

public class HttpOperations {
    JsonArrayRequest jsonArrayRequest;
    JsonObjectRequest jsonObjectRequest;



    public HttpOperations() {
    }

    public void getJsonArrayResponse(String url, Context context, final ServerCallback callback) {

        jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                callback.onSuccess(response);
            }
        }, null);
        Volley.newRequestQueue(context).add(jsonArrayRequest);
    }
}
