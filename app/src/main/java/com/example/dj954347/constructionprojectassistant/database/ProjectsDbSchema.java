package com.example.dj954347.constructionprojectassistant.database;

import java.util.Date;

/**
 * Created by troyr on 4/1/2018.
 */

public class ProjectsDbSchema {
    public static final class ProjectTable {
        public static final String NAME = "Projects";

        public static final class Cols {
            public static final String UUID = "uuid";
            public static final String NAME = "owners name";
            public static final String Address = "address";
            public static final String Description = "description";
            public static final String PorjectStatus = "updates on project";
            public static final String CompletionDate = "completion date";
        }
    }
}
