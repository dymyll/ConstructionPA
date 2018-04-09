package com.example.dj954347.constructionprojectassistant.database;

import android.database.Cursor;
import android.database.CursorWrapper;
import com.example.dj954347.constructionprojectassistant.Project;
import java.util.Date;
import java.util.UUID;
/**
 * Created by troyr on 4/4/2018.
 */

public class ProjectCursorWrapper extends CursorWrapper{

    public ProjectCursorWrapper(Cursor cursor){
        super(cursor);
    }

    public Project getProject() {
        String uuidString = getString(getColumnIndex(ProjectsDbSchema.ProjectTable.Cols.UUID));
        String name= getString(getColumnIndex(ProjectsDbSchema.ProjectTable.Cols.NAME));
        String address = getString(getColumnIndex(ProjectsDbSchema.ProjectTable.Cols.Address));
        String description = getString(getColumnIndex(ProjectsDbSchema.ProjectTable.Cols.Description));
        String projectstatus = getString(getColumnIndex(ProjectsDbSchema.ProjectTable.Cols.PorjectStatus));
        long completiondate = getLong(getColumnIndex(ProjectsDbSchema.ProjectTable.Cols.CompletionDate));

        Project project = new Project(UUID.fromString(uuidString));
        project.setName(name);
        project.setAddress(address);
        project.setDescription(description);
        project.setProjectStatus(projectstatus);
        project.setCompletetionDate(new Date(completiondate));

        return project;

    }
}