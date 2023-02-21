package com.rochelle.save_travels.controllers;
//? Pair Programming -> Dominic Basa

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rochelle.save_travels.models.Expense;
import com.rochelle.save_travels.services.ExpenseService;

// controller annotation to identify that this is my controller
@Controller
public class MainController {
    /* 
    -> where my routes reside
    ->  now they are connected 
    -> all funcitonality in my service now have access to in my controller
    */
    @Autowired ExpenseService expenseService;
    
    // & CREATE/ READ ALL 
    // ^ READ ALL ^
    // route that is going to render my index.jsp
    @RequestMapping("/")
    // have to send down expense -> in root make sure ModelAttribute is here as well 
    // to send objects to the frontend for display
    public String index(@ModelAttribute("expense")Expense expense, Model model){
        // Inservice -> create a method to get all my expenses from my DB to my view
        // Invoke method to get List of expenses
        List<Expense> expenses = expenseService.getAllExpenses();
        System.out.print(expenses);
        model.addAttribute("expenses", expenses);
        return "index.jsp";
    }
    // my page is now rendering 
    // -> now want to display expenses -> object that represents a expense
    

    // ^ CREATE ^
    // now want to pass down an empty espense to my form
    //? Want a handler for that form 
    @PostMapping("/expenses") 
    /*     
    -> checking validations need @Valid
    -> bound to the form using the modelAttribute
    -> pass that expense on down to my createExpense
    */
    public String create(@Valid @ModelAttribute("expense")Expense expense, BindingResult result) {
        // since using modelAttribute to get the expense to the form 
        // -> need modelAttribute to get the expense back from the form
        if (result.hasErrors()) {
            // give them back the form to try again
            return "index.jsp";
        } else {
            /* 
            ->have my form make an expense
            ->create a converter -> need to wire it and connect the dependency
            ->need the actual expense 
            -> method does not exist in service so have to make it 
            */
            expenseService.createExpense(expense);
        }
        return "redirect:/";
    }


    // ^ READ ONE ^
    /* 
    -> when do this show.jsp should have access to one expense at the specified index
    -> have one expense object that is being passed down to jsp
    attributes can be individual strings, they can be expenses, they can be whatever you want to pass down
    -> want to click on one of these titles and have it take me to a show page
    -> can use request mapping or get mapping 
    */
    @GetMapping("/expenses/{id}")
    // -> now just need to call the method created in service to read one 
    // get variables that live in the url -> Path Variable
    public String show(@PathVariable("id")Long id, Model model) {
        // need to get my expense to my show page -> link data in my controller to my template -> Model model
        Expense expense = expenseService.getOneExpense(id);
        model.addAttribute("expense", expense);
        return "show.jsp";
    }


    // ^ UPDATE ^
    // the edit page
    /* 
    putting stuff on my DB -> 2 routes
    -> one to display the form and one to handle the form 
    */
    // This route shows the form -> renders the form 
    @GetMapping("/expenses/edit/{id}")
    public String edit(@PathVariable("id")Long id, Model model){
        /* 
        -> the edit page is often similar to the new page so copy it and change a few things
        -> samething as read one since need to view one burger to edit it
        -> so can use that code as well
        */
        Expense expense = expenseService.getOneExpense(id);
        model.addAttribute("expense", expense);
        return "edit.jsp";
    }

    // This is the route it to handle the edit -> send the expense
    @PutMapping("/expenses/{id}") 
    public String update(@ModelAttribute("expense")Expense expense) {
        // just make sure to make a different functions name
        expenseService.updateExpense(expense);
        return "redirect:/";
    } 


    // ^ DELETE ^ 
    @DeleteMapping("/expenses/{id}")
    // want to delete whatever expense has this variable 
    public String obliterate(@PathVariable("id")Long id) {
        // need to find the expense 1st that has that id
        Expense expense = expenseService.getOneExpense(id);
        expenseService.obliterateExpense(expense);
        // no where else to go after delete burger -> no show page for that burger
        return "redirect:/";
    }
}
