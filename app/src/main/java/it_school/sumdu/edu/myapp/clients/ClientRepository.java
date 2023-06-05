package it_school.sumdu.edu.myapp.clients;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

public class ClientRepository {
    ClientRoomDatabase clientRoomDatabase;
    ClientDao clientDao;
    private LiveData<List<Client>> listClients;

    public ClientRepository(Application application) {
        clientRoomDatabase = clientRoomDatabase.getDatabase(application);
        clientDao = clientRoomDatabase.clientDao();
        listClients = clientDao.getClient();
    }

    public void insertClient(Client client) {
        ClientRoomDatabase.databaseWriteExecutor.execute(() -> clientDao.insert(client));
    }

    public LiveData<List<Client>> getAllClients() {
        return listClients;
    }
}

