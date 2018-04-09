package com.example.dj954347.constructionprojectassistant.database.database;

import android.database.Cursor;
import android.database.CursorWrapper;
import com.example.dj954347.constructionprojectassistant.Admin;
import java.util.Date;
import java.util.UUID;

/**
 * Created by Dymyll on 4/2/2018.
 */

public class AdminCursorWrapper extends CursorWrapper {


    public AdminCursorWrapper(Cursor cursor) {
        super(cursor);
    }

    public Admin getAdmin() {
        String uuidString = getString(getColumnIndex(AdminDbSchema.AdminTable.Cols.UUID));
        String firstname = getString(getColumnIndex(AdminDbSchema.AdminTable.Cols.FIRSTNAME));
        String lastname = getString(getColumnIndex(AdminDbSchema.AdminTable.Cols.LASTNAME));
        String adminname = getString(getColumnIndex(AdminDbSchema.AdminTable.Cols.ADMINNAME));
        String emailaddress = getString(getColumnIndex(AdminDbSchema.AdminTable.Cols.EMAILADDRESS));
        long dateofbirth = getLong(getColumnIndex(AdminDbSchema.AdminTable.Cols.DATEOFBIRTH));
        String password = getString(getColumnIndex(AdminDbSchema.AdminTable.Cols.PASSWORD));

        Admin admin = new Admin (UUID.fromString(uuidString));
        admin.setAdminName(adminname);
        admin.setFirstName(firstname);
        admin.setLastName(lastname);
        admin.setEmailAddress(emailaddress);
        admin.setDateOfBirth(new Date(dateofbirth));
        admin.setPassword(password);

        return admin;
    }
}
