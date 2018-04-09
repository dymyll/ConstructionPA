package com.example.dj954347.constructionprojectassistant.database;
import android.database.Cursor;
import android.database.CursorWrapper;
import com.example.dj954347.constructionprojectassistant.Worker;
import java.util.UUID;
/**
 * Created by troyr on 4/4/2018.
 */

public class WorkerCursorWrapper extends CursorWrapper{

    public WorkerCursorWrapper(Cursor cursor){
        super(cursor);
    }

    public Worker getWorker() {
        String uuidString = getString(getColumnIndex(WorkerDbSchema.WorkerTable.Cols.UUID));
        String firstname= getString(getColumnIndex(WorkerDbSchema.WorkerTable.Cols.FirstName));
        String lastname = getString(getColumnIndex(WorkerDbSchema.WorkerTable.Cols.LastName));
        String username = getString(getColumnIndex(WorkerDbSchema.WorkerTable.Cols.Username));
        String password = getString(getColumnIndex(WorkerDbSchema.WorkerTable.Cols.Password));

        Worker worker = new Worker(UUID.fromString(uuidString));
        worker.setFirstName(firstname);
        worker.setLastName(lastname);
        worker.setUsername(username);
        worker.setPassword(password);

        return worker;

    }
}
