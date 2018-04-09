package com.example.dj954347.constructionprojectassistant.database;

/**
 * Created by troyr on 4/2/2018.
 */

public class WorkerDbSchema {
        public static final class WorkerTable {
            public static final String NAME = "Workers";

            public static final class Cols {
                public static final String UUID = "mId";
                public static final String FirstName = "workers first name";
                public static final String LastName = "workers last name";
                public static final String Username = "username";
                public static final String Password= "password";
            }
        }
}
