package com.example.dj954347.constructionprojectassistant;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.dj954347.constructionprojectassistant.database.AdminBaseHelper;
import com.example.dj954347.constructionprojectassistant.database.AdminCursorWrapper;
import com.example.dj954347.constructionprojectassistant.database.AdminDbSchema;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static com.example.dj954347.constructionprojectassistant.database.AdminDbSchema.AdminTable.Cols.DATEOFBIRTH;
import static com.example.dj954347.constructionprojectassistant.database.AdminDbSchema.AdminTable.Cols.EMAILADDRESS;
import static com.example.dj954347.constructionprojectassistant.database.AdminDbSchema.AdminTable.Cols.FIRSTNAME;
import static com.example.dj954347.constructionprojectassistant.database.AdminDbSchema.AdminTable.Cols.LASTNAME;
import static com.example.dj954347.constructionprojectassistant.database.AdminDbSchema.AdminTable.Cols.PASSWORD;
import static com.example.dj954347.constructionprojectassistant.database.AdminDbSchema.AdminTable.Cols.ADMINNAME;

/**
 * Created by Dymyll on 4/2/2018.
 */

public class AdminList {

    private static AdminList sAdminList;
    private Context mContext;
    private SQLiteDatabase mDatabase;

    public static AdminList get(Context context) {
        if (sAdminList == null) {
            sAdminList = new AdminList(context);
        }

        return sAdminList;
    }

    private AdminList(Context context) {
        mContext = context.getApplicationContext();
        mDatabase = new AdminBaseHelper(mContext)
                .getWritableDatabase();


    }

    public void addAdmin(Admin c) {
        ContentValues values = getContentValues(c);
        mDatabase.insert(AdminDbSchema.AdminTable.NAME, null, values);
    }

    public List<Admin> getAdmins() {
        List<Admin> admins = new ArrayList<>();
        AdminCursorWrapper cursor = queryAdmins(null, null);
        try {
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                admins.add(cursor.getAdmin());
                cursor.moveToNext();
            }
        } finally {
            cursor.close();
        }
        return admins;
    }

    public Admin getAdmin(UUID id) {

        AdminCursorWrapper cursor = queryAdmins(
                AdminDbSchema.AdminTable.Cols.UUID + " = ?",
                new String[]{id.toString()}
        );
        try {
            if (cursor.getCount() == 0) {
                return null;
            }
            cursor.moveToFirst();
            return cursor.getAdmin();
        } finally {
            cursor.close();
        }
    }

    public void updateAdmin(Admin customer) {
        String uuidString = customer.getId().toString();
        ContentValues values = getContentValues(customer);
        mDatabase.update(AdminDbSchema.AdminTable.NAME, values,
                AdminDbSchema.AdminTable.Cols.UUID + " = ?",
                new String[]{uuidString});
    }

    private AdminCursorWrapper queryAdmins(String whereClause, String[] whereArgs) {
        Cursor cursor = mDatabase.query(
                AdminDbSchema.AdminTable.NAME,
                null, // Columns - null selects all columns
                whereClause,
                whereArgs,
                null, // groupBy
                null, // having
                null  // orderBy
        );
        return new AdminCursorWrapper(cursor);
    }


    private static ContentValues getContentValues(Admin customer) {
        ContentValues values = new ContentValues();
        values.put(AdminDbSchema.AdminTable.Cols.UUID, customer.getId().toString());
        values.put(FIRSTNAME, customer.getFirstName());
        values.put(LASTNAME, customer.getLastName());
        values.put(ADMINNAME, customer.getAdminName());
        values.put(EMAILADDRESS, customer.getEmailAddress());
        values.put(DATEOFBIRTH, customer.getDateofBirth().toString());
        values.put(PASSWORD, customer.getPassword());
        return values;
    }
}
