package com.example.dj954347.constructionprojectassistant;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.dj954347.constructionprojectassistant.database.database.CustomerBaseHelper;
import com.example.dj954347.constructionprojectassistant.database.database.CustomerCursorWrapper;
import com.example.dj954347.constructionprojectassistant.database.database.CustomerDbSchema;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static com.example.dj954347.constructionprojectassistant.database.database.CustomerDbSchema.CustomerTable.Cols.DATEOFBIRTH;
import static com.example.dj954347.constructionprojectassistant.database.database.CustomerDbSchema.CustomerTable.Cols.EMAILADDRESS;
import static com.example.dj954347.constructionprojectassistant.database.database.CustomerDbSchema.CustomerTable.Cols.FIRSTNAME;
import static com.example.dj954347.constructionprojectassistant.database.database.CustomerDbSchema.CustomerTable.Cols.LASTNAME;
import static com.example.dj954347.constructionprojectassistant.database.database.CustomerDbSchema.CustomerTable.Cols.PASSWORD;

/**
 * Created by Dymyll on 4/2/2018.
 */

public class CustomerList {

        private static CustomerList sCustomerList;
        private Context mContext;
        private SQLiteDatabase mDatabase;

        public static CustomerList get(Context context) {
            if (sCustomerList == null) {
                sCustomerList = new CustomerList(context);
            }

            return sCustomerList;
        }

        private CustomerList(Context context) {
            mContext = context.getApplicationContext();
            mDatabase = new CustomerBaseHelper(mContext)
                    .getWritableDatabase();


        }

    public void addCustomer(Customer c) {
        ContentValues values = getContentValues(c);
        mDatabase.insert(CustomerDbSchema.CustomerTable.NAME, null, values);
    }

    public List<Customer> getCustomers() {
        List<Customer> customers = new ArrayList<>();
        CustomerCursorWrapper cursor = queryCustomers(null, null);
        try {
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                customers.add(cursor.getCustomer());
                cursor.moveToNext();
            }
        } finally {
            cursor.close();
        }
        return customers;
    }

    public Customer getCustomer(UUID id) {

        CustomerCursorWrapper cursor = queryCustomers(
                CustomerDbSchema.CustomerTable.Cols.UUID + " = ?",
                new String[]{id.toString()}
        );
        try {
            if (cursor.getCount() == 0) {
                return null;
            }
            cursor.moveToFirst();
            return cursor.getCustomer();
        } finally {
            cursor.close();
        }
    }

    public void updateCustomer(Customer customer) {
        String uuidString = customer.getId().toString();
        ContentValues values = getContentValues(customer);
        mDatabase.update(CustomerDbSchema.CustomerTable.NAME, values,
                CustomerDbSchema.CustomerTable.Cols.UUID + " = ?",
                new String[]{uuidString});
    }

    private CustomerCursorWrapper queryCustomers(String whereClause, String[] whereArgs) {
        Cursor cursor = mDatabase.query(
                CustomerDbSchema.CustomerTable.NAME,
                null, // Columns - null selects all columns
                whereClause,
                whereArgs,
                null, // groupBy
                null, // having
                null  // orderBy
        );
        return new CustomerCursorWrapper(cursor);
    }


    private static ContentValues getContentValues(Customer customer) {
        ContentValues values = new ContentValues();
        values.put(CustomerDbSchema.CustomerTable.Cols.UUID, customer.getId().toString());
        values.put(FIRSTNAME, customer.getFirstName());
        values.put(LASTNAME, customer.getLastName());
        values.put(EMAILADDRESS, customer.getEmailAddress());
        values.put(DATEOFBIRTH, customer.getDateofBirth().toString());
        values.put(PASSWORD, customer.getPassword());
        return values;
    }
}
