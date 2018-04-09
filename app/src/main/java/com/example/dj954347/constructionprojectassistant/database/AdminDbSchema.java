package com.example.dj954347.constructionprojectassistant.database.database;

import java.util.Date;

/**
 * Created by Dymyll on 4/9/2018.
 *
 */

public class AdminDbSchema {
    public  static final class AdminTable{
        public static final String NAME = "admins";

        public static final class Cols {
            public static final String UUID = "uuid";
            public static final String FIRSTNAME = "firstname";
            public static final String LASTNAME = "lastname";
            public static final String ADMINNAME = "adminname";
            public static final String EMAILADDRESS = "emailaddress";
            public static final String PASSWORD = "password";
            public static final String DATEOFBIRTH = "date_of_birth";

        }
    }
}
