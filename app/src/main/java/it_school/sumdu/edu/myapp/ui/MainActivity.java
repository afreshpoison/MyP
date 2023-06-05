package it_school.sumdu.edu.myapp.ui;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import it_school.sumdu.edu.myapp.R;
import it_school.sumdu.edu.myapp.clients.Client;
import it_school.sumdu.edu.myapp.domain.ClientViewModel;




public class MainActivity extends AppCompatActivity {
    private EditText editClientName;
    private EditText editClientLastName;
    private EditText editClientPhoneNumber;
    private EditText editClientAppointment;
    private EditText editClientComment;
    private Button buttonSave;
    private Button showClientsButton;
    private ClientViewModel clientViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Client client = new Client(editClientName.getText().toString(),
                        editClientLastName.getText().toString(),
                        editClientPhoneNumber.getText().toString(),
                        editClientAppointment.getText().toString());
                        editClientComment.getText().toString();
                    Log.d("СТВОРЕННЯ", "Клієнт додано");
                System.out.print("Клієнт додано");
                clientViewModel.insertClient(client);
                showAddedAlert(editClientName.getText().toString(), editClientLastName.getText().toString());
            }
        });

        showClientsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("СТВОРЕННЯ", "Стартова активність запущена");
                startActivity(new Intent(MainActivity.this, ClientList.class));
            }
        });

        clientViewModel = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(ClientViewModel.class);
    }

    private void findViews() {
        editClientName = findViewById(R.id.editClientName);
        editClientLastName = findViewById(R.id.editClientLastName);
        editClientPhoneNumber = findViewById(R.id.editClientPhoneNumber);
        editClientAppointment = findViewById(R.id.editClientAppointment);
        editClientComment = findViewById(R.id.editClientComment);
        buttonSave = findViewById(R.id.buttonSave);
        showClientsButton = findViewById(R.id.showClientsButton);
    }

    private void showAddedAlert(String firstName, String lastName) {
        new AlertDialog.Builder(this)
                .setTitle("Користувач додано")
                .setMessage(firstName + " " + lastName)
                .setNegativeButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        editClientName.setText("");
                        editClientLastName.setText("");
                        editClientPhoneNumber.setText("");
                        editClientAppointment.setText("");
                        editClientComment.setText("");
                    }
                })
                .show();
    }
}

