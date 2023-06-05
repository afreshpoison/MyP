package it_school.sumdu.edu.myapp.clients;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Client.class}, version = 1, exportSchema = false)
public abstract class ClientRoomDatabase extends RoomDatabase {
    public abstract ClientDao clientDao();
    private static volatile ClientRoomDatabase clientRoomDatabase;
    private static final int NUMBER_OF_THREADS = 5;
    static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    static ClientRoomDatabase getDatabase(final Context context) {
        if (clientRoomDatabase == null) {
            synchronized (ClientRoomDatabase.class) {
                if (clientRoomDatabase == null) {
                    clientRoomDatabase = Room.databaseBuilder(context.getApplicationContext(),
                                    ClientRoomDatabase.class, "client_database")
                            .build();
                }
            }
        }
        return clientRoomDatabase;
    }
}
