package com.accenture.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.accenture.entity.EmployeeEntityBean;

public interface EmployeeDAO extends CrudRepository<EmployeeEntityBean, Integer>{
	
	
	

}


/*
public interface CrudRepository<T, ID extends Serializable>
extends Repository<T, ID> {

//Saves the given entity.
<S extends T> S save(S entity);      

//Returns the entity identified by the given ID.
Optional<T> findById(ID primaryKey); 

//Returns all entities.
Iterable<T> findAll();               

//Returns the number of entities.
long count();                        

//Deletes the given entity.
void delete(T entity);               

//Indicates whether an entity with the given ID exists.
boolean existsById(ID primaryKey);   

// … more functionality omitted.
}


*/
