package br.com.fausto.institutions_app.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import br.com.fausto.institutions_app.model.UniversityParsedItem

@Dao
interface UniversityDao {

    @Insert(onConflict = REPLACE)
    fun save(universityParsedItem: UniversityParsedItem)

    @Query("SELECT * FROM UniversityParsedItem LIMIT 1000")
    fun loadAll(): MutableList<UniversityParsedItem>

    @Query("DELETE FROM UniversityParsedItem")
    fun clearTable()

}