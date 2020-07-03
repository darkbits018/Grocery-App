package com.example.grocery;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import java.util.List;

import java.util.List;

@Dao
public interface ItemDAO {
    @Insert
    void InsertItem(Item item);

    @Query("select * from Grocery")
    List<Item>getAllItems();


}
