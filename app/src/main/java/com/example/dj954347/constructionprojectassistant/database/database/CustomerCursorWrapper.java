package com.example.dj954347.constructionprojectassistant.database.database;

import android.database.Cursor;
import android.database.CursorWrapper;
import com.example.dj954347.constructionprojectassistant.Customer;
import java.util.Date;
import java.util.UUID;

/**
 * Created by Dymyll on 4/2/2018.
 */

public class CustomerCursorWrapper extends CursorWrapper {


        public CustomerCursorWrapper(Cursor cursor) {
            super(cursor);
        }

        public Customer getCustomer() {
            String uuidString = getString(getColumnIndex(CustomerDbSchema.CustomerTable.Cols.UUID));
            String firstname = getString(getColumnIndex(CustomerDbSchema.CustomerTable.Cols.FIRSTNAME));
            String lastname = getString(getColumnIndex(CustomerDbSchema.CustomerTable.Cols.LASTNAME));
            String username = getString(getColumnIndex(CustomerDbSchema.CustomerTable.Cols.USERNAME));
            String emailaddress = getString(getColumnIndex(CustomerDbSchema.CustomerTable.Cols.EMAILADDRESS));
            long dateofbirth = getLong(getColumnIndex(CustomerDbSchema.CustomerTable.Cols.DATEOFBIRTH));
            String password = getString(getColumnIndex(CustomerDbSchema.CustomerTable.Cols.PASSWORD));

            Customer customer = new Customer(UUID.fromString(uuidString));
            customer.setUserName(username);
            customer.setFirstName(firstname);
            customer.setLastName(lastname);
            customer.setEmailAddress(emailaddress);
            customer.setDateOfBirth(new Date(dateofbirth));
            customer.setPassword(password);

            return customer;
        }
}
