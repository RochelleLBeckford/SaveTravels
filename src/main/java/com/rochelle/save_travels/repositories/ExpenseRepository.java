package com.rochelle.save_travels.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rochelle.save_travels.models.Expense;

// CrudRepository takes a generic of what ever we are tracking -> expense and then Long as it's data type for id
// -> this is all we need to do to connect to our DB
// -> best practice is to have the @Repository but is not needed -> just best practice
// want code to be as readible as possible at a glance 
@Repository
public interface ExpenseRepository extends CrudRepository<Expense, Long>{
    // we need to override our findAll
    // -> when find all i want to list an expense
    List<Expense> findAll();
}
