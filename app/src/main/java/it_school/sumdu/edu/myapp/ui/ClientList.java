package it_school.sumdu.edu.myapp.ui;

import android.os.Build;
import android.os.Bundle;
import android.widget.SearchView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import it_school.sumdu.edu.myapp.R;
import it_school.sumdu.edu.myapp.clients.Client;
import it_school.sumdu.edu.myapp.clients.ClientListAdapter;
import it_school.sumdu.edu.myapp.domain.ClientViewModel;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ClientList extends AppCompatActivity {
    private SearchView searchView;
    private RecyclerView recyclerView;
    private ClientViewModel clientViewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.client_list);
        findViews();

        clientViewModel = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(ClientViewModel.class);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        clientViewModel.getAllClientsFromVm().observe(this, clients ->
        {
            if (clients != null && !clients.isEmpty()) {
                ClientListAdapter adapter = new ClientListAdapter((ArrayList<Client>) clients);
                recyclerView.setAdapter(adapter);
            }
        });

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                clientViewModel.getAllClientsFromVm().observe(ClientList.this, clients ->
                {
                    if (clients != null && !clients.isEmpty()) {
                        List<Client> filteredList;
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                            filteredList = clients.stream()
                                    .filter(client -> client.getName().contains(query)).collect(Collectors.toList());
                            ClientListAdapter adapter = new ClientListAdapter((ArrayList<Client>) filteredList);
                            recyclerView.setAdapter(adapter);
                        }
                    }
                });
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                ClientViewModel.getAllClientsFromVm().observe(ClientList.this, students ->
                {
                    if (students != null && !students.isEmpty()) {
                        List<Client> filteredList;
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                            filteredList = students.stream()
                                    .filter(student -> student.getName().contains(newText)).collect(Collectors.toList());
                            ClientListAdapter adapter = new ClientListAdapter((ArrayList<Client>) filteredList);
                            recyclerView.setAdapter(adapter);
                        }
                    }
                });

                return false;
            }
        });
    }

    private void findViews() {
        recyclerView = findViewById(R.id.recycleView);
        searchView = findViewById(R.id.searchView);
    }
}