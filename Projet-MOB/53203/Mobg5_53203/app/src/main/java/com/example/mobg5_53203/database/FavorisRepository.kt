package com.example.mobg5_53203.database

class FavorisRepository(private val favorisDao: FavorisDatabaseDao) {

    /**
     * addFavoris - adds a new entry to the favoris table in the database
     *
     * @param nom: Favoris - the Favoris object to be inserted into the database
     */
    fun addFavoris(nom: Favoris){
        favorisDao.insert(nom)
    }
    /**
     * updateFavoris - updates an existing entry in the favoris table in the database
     *
     * @param fav: Favoris - the updated Favoris object to be inserted into the database
     */
    fun updateFavoris(fav: Favoris){
        favorisDao.update(fav)
    }

    /**
     * get - retrieves a Favoris object from the database based on the provided name
     *
     * @param nom: String - the name of the Favoris object to be retrieved
     * @return Favoris - the Favoris object with the given name
     */
    fun get(nom: String): Favoris {
        return favorisDao.get(nom)
    }


    /**
     * getAll - retrieves a list of all Favoris objects from the database
     *
     * @return List<Favoris> - the list of all Favoris objects in the database
     */
    fun getAll() : List<Favoris> {
        return favorisDao.getAll()
    }

    /**
     * deleteByName - deletes a Favoris object from the database based on the provided name
     *
     * @param nom: String? - the name of the Favoris object to be deleted
     */
    fun deleteByName(nom : String?){
        favorisDao.deleteByName(nom)
    }
}