package it_school.sumdu.edu.myapp.clients;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "client_table")
public class Client {
    @PrimaryKey
    @NonNull
    String name;
    String lastName;
    String phoneNumber;
    String appointment;
    String comment;

    public Client(@NonNull String name, String lastName, String phoneNumber, String appointment) {
        this.name = name;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.appointment = appointment;
    }

    @NonNull
    public String getName() {
        return name;
    }

    public void setName(@NonNull String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public String getAppointment() {
        return appointment;
    }
    public void setAppointment(String appointment) {
        this.appointment = appointment;
    }
    public String getComment() {
        return comment;
    }
    public void setComment(String comment) {
        this.comment = comment;
    }
}

