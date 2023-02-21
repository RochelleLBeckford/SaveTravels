package com.rochelle.save_travels.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rochelle.save_travels.models.Expense;
import com.rochelle.save_travels.repositories.ExpenseRepository;

// all of our Business Logic goes here
// this annotation for service is required -> if not there it will throw an error
@Service
// controller talks to the service -> service talks to the repository 
// We have to inject our dependencies -> we have to wire them up 
public class ExpenseService {
    // now they are connected 
    // -> all funcitonality in my repo now have access to in my service
    @Autowired ExpenseRepository expenseRepository;


    // ^ CREATE ^
    // void since not returning anything -> just making an expense
    // -> when i invoke this going to pass in an expense
    public void createExpense(Expense expense) {
        // now to pass along burger to DB 
        // whatever you make as your entity i will save it for you
        // -> pass on down expense that came from frontend 
        expenseRepository.save(expense);
        // to check if this worked it will be in my DB
    }


    // ^ READ ALL ^
    // In service 
    // -> create a method to get all my expenses from my DB to my view
    // -> return a list of expenses
    // -> now can call this method in my controller
    public List<Expense> getAllExpenses() {
        return expenseRepository.findAll();
    }


    // ^ READ ONE ^
    // -> now just need to call this in our controller
    // -> know which burger you want by the id -> pass in Lond id
    public Expense getOneExpense(Long id) {
        // getting an expense is an optional type
        Optional<Expense> optionalExpense = expenseRepository.findById(id);
        // Jave shorthand for if, else if, else statment
        return optionalExpense.orElse(null);
    } 

    // ^ UPDATE ^
    // -> method for update
    // controller talks to the service the servive talks to the repository
    public void updateExpense(Expense expense) {
        /* 
        -> save -> get the same burger from the database 
        -> fixing it and passing it back
        -> taking that burger and resaving it to the modified version
        */
        expenseRepository.save(expense);
    }


    // ^ DELETE ^
    public void obliterateExpense(Expense expense) {
        // controller talks to the service -> service talks to the repository
        expenseRepository.delete(expense);
    }
}
