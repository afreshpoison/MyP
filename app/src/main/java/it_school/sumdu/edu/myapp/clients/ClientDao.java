package it_school.sumdu.edu.myapp.clients;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface ClientDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Client client);

    @Update
    void update(Client client);

    @Query("SELECT * from client_table ORDER By name Asc")
    LiveData<List<Client>> getClient();

    @Query("DELETE from client_table")
    void deleteAll();
}
