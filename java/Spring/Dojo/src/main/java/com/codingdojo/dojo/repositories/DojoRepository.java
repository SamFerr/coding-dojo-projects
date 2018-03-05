package com.codingdojo.dojo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.dojo.models.DojoModel;

@Repository
public interface DojoRepository extends CrudRepository<DojoModel, Long> {
	
//	Gets all of the dojos from the model
	@Query("SELECT d FROM Dojo d")
	List<DojoModel> findAll();
	
//	Gets all of the names of all of the dojos
	@Query("SELECT d.name FROM Dojo d")
	List<DojoModel> findAllDojosNames();
	
//	Gets all of the Dojos by ID (still in a list)
	@Query("SELECT d FROM Dojo d WHERE id = ?1")
	List<DojoModel> getDojoWhereId(Long id);
	
//	Gets al of the Dojos by ID and returns one dojo at a time
	@Query("SELECT d FROM Dojo d WHERE id = ?1")
	DojoModel getSingleDojoWhereId(Long id);
	
//	Modifying Queries
//	Note the int type. It is because it returns the number of rows affected
	
//	setting the name for one dojo
	@Modifying
	@Query("update Dojo d set d.name = ?1 WHERE d.id = ?2")
	int setNameForOne(String name, Long id);
	
//	setting the name for all dojos
	@Modifying
	@Query("update Dojo d set d.name = ?1")
	int setNameForAll(String name);
	
//	deleting just one dojo where the id is 
	@Modifying
	@Query("delete Dojo d WHERE d.id = ?1")
	int deleteOneDojo(Long id);
	
	
//	Native Queries that we can write any query in raw SQL
	
//	get all the names of the dojos with id. If we select all, we get a list of Dojo objects back.
	@Query(value="SELECT * FROM dojos", nativeQuery=true)
	List<DojoModel> findAllDojosNamesWithId();
	
//	get all the names of the dojos with id. If we want to select specific column, we will get a list of Object arrays because it is no longer Dojo objects.
//	Each index of the array will be the column selected respectively. Therefore 0 = id column, 1 = name column
	@Query(value="SELECT id, name from dojos", nativeQuery=true)
	List<Object[]> findAllDojosNamesWithId2();
	
//	Get one Dojo
	@Query(value="SELECT * FROM dojos WHERE id = ?1", nativeQuery=true)
	DojoModel getDojosWhereId(Long id);
	
//	inner join retrieving only the dojos
	@Query("SELECT d FROM Dojo d JOIN d.ninjas n")
	List<DojoModel> joinDojosAndNinjas();
	
//	inner join retrieving dojos and ninjas
	@Query("SELECT d, n FROM Dojo d JOIN d.ninjas n")
	List<Object[]> joinDojosAndNinjas2();
	
	
	
	
}
