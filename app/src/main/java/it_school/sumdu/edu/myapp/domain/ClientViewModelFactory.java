package it_school.sumdu.edu.myapp.domain;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public class ClientViewModelFactory implements ViewModelProvider.Factory {
    private final Application application;

    public ClientViewModelFactory(Application myApplication) {
        application = myApplication;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new ClientViewModel(application);
    }
}

