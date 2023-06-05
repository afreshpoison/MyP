package it_school.sumdu.edu.myapp.domain;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;


import it_school.sumdu.edu.myapp.clients.Client;
import it_school.sumdu.edu.myapp.clients.ClientRepository;

public class ClientViewModel extends AndroidViewModel {
    private ClientRepository clientRepository;
    private static LiveData<List<Client>> listLiveData;

    public ClientViewModel(Application application) {
        super(application);
        clientRepository = new ClientRepository(application);
        listLiveData = clientRepository.getAllClients();
    }

    public static LiveData<List<Client>> getAllClientsFromVm() {
        return listLiveData;
    }

    public LiveData<List<Client>> getClientsByName(String name) {
       return listLiveData;
    }

    public void insertClient(Client client) {clientRepository.insertClient(client);
    }
}
