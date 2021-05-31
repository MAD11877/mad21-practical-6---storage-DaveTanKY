package sg.edu.np.practical2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.Random;

public class DBHandler  extends SQLiteOpenHelper {

    public DBHandler(@Nullable Context context) {
        super(context, "UserDB", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableStatement = "CREATE TABLE USERS (ID INTEGER PRIMARY KEY AUTOINCREMENT, NAME TEXT, DESCRIPTION TEXT, FOLLOWED INTEGER DEFAULT 0)";

        db.execSQL(createTableStatement);



        Random rand = new Random();
        for (int i = 0; i < 20; i++) {

            int randName = rand.nextInt();
            int randDesc = rand.nextInt();
            int randFollowed = rand.nextInt();
            ContentValues values =  new ContentValues();

            User u = new User();
            u.setName("Dave " + randName);
            u.setDesc("Description " + randDesc);
            if (randFollowed % 2 == 0) {
                values.put("followed", 1);
            }
            else {
                values.put("followed", 0);
            }


            values.put("name", u.name);
            values.put("description", u.desc);

            db.insert("USERS", null, values);
        }
        db.close();

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS USERS");
        onCreate(db);
    }

    public void addUser(User u)
    {
        ContentValues values = new ContentValues();
        values.put("name", u.name);
        values.put("description", u.desc);
        if (u.followed)
        {
            values.put("followed", 1);
        }
        else
        {
            values.put("followed", 0);
        }

        SQLiteDatabase db = getWritableDatabase();
        db.insert("USERS", null, values);
        db.close();
    }

    public ArrayList<User> getUser(String name)
    {
        SQLiteDatabase db = getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM USERS", null);
        User u = null;
        ArrayList<User> list = new ArrayList<>();
        while(cursor.moveToNext())
        {
            u = new User();
            u.setName(cursor.getString(1));
            u.setDesc(cursor.getString(2));
            if (cursor.getInt(3) == 1)
            {
                u.setFollowed(true);
            }
            else
            {
                u.setFollowed(false);
            }
            list.add(u);
        }
        cursor.close();
        db.close();
        return list;
    }

    public void updateUser(User u)
    {

        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name", u.name);
        values.put("description", u.desc);
        if (u.followed)
        {
            values.put("followed", 1);
        }
        else
        {
            values.put("followed", 0);
        }

        db.update("USERS", values, "NAME = ?", new String[]{u.name} );
    }
}
