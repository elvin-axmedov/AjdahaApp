package SQLiteConnections;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.lenovo.ajdahaapp.Activities.MainActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import models.SalesMan;

/**
 * Created by Lenovo on 19-Nov-17.
 */

public class DBSql {
    Context myctx;
    SQLiteDatabase db;
    DBHelper dbHelper;

    public DBSql(Context context) {
        myctx = context;
    }

    public void updateSlsMans(JSONArray slsManList) {
        ContentValues cv = new ContentValues();
        open();
        Log.d("Delete", "Row Deleted " + db.delete("SLSMANS",null,null));

        for (int i = 0; i < slsManList.length(); i++) {
            try {
                cv.put("CODE", slsManList.getJSONObject(i).getInt("code"));
                cv.put("NAME", slsManList.getJSONObject(i).getString("name"));
                cv.put("DEPARTMENT", slsManList.getJSONObject(i).getInt("department"));
                cv.put("BRANCH", slsManList.getJSONObject(i).getInt("branch"));
                db.insert("SLSMANS",null,cv);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        close();
    }

    public List<String> getSlsMans() {
        List<String> slsManList = new ArrayList<>();
        open();
        Cursor cursor = db.query("SLSMANS", null, null, null, null, null, null);
        if (cursor.moveToFirst()) {
            do {
                slsManList.add(cursor.getString(2));
            } while (cursor.moveToNext());
        } else {
            Log.d("Error", "Zibili chixdi");
        }
        cursor.close();
        close();
        return slsManList;
    }

    private void open() {
        dbHelper = new DBHelper(myctx);
        db = dbHelper.getWritableDatabase();
    }

    private void close() {
        if (dbHelper != null) {
            dbHelper.close();
        }
    }
}
