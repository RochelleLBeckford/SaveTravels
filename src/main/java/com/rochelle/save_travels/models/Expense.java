package com.rochelle.save_travels.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

// establish a burger as an item going to track in out application
@Entity
// tell jpa what table we want to track -> table name is always plural 
@Table(name="expenses")
public class Expense {
    // designate this as an item in our database -> id is needed
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // this is where you setup you attributes 
    // id
    private Long id;

    @NotBlank
    private String expenseName;

    @NotBlank
    private String vendor;

    @NotNull(message = "The amount must be greater than $0!")
    @Min(value= 1)
    // private Integer amount;
    private Integer amount;

    @NotBlank
    private String description;

    // This will not allow the createdAt column to be updated after creation
    // will add our updatedAt and CreatedAt
    @Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;

    // need to make a POJO and Java Bean 
    // empty constructor 

    public Expense() {
    }

    // constructor w/ all fields -> do not need to include the id 
    // -> remove Long id & this.id = id
    // -> remove createdAt and updatedAt as well 

    // *Note -> avoid changing the id because it is sacred -> want the DB to track the id
    public Expense(String expenseName, String vendor, Integer amount, String description) {
        this.expenseName = expenseName;
        this.vendor = vendor;
        this.amount = amount;
        this.description = description;
    }

    /* 
    ~ since private need to access them -> getters and setters ~ 
    ~ POJO -> Plain old java object ~
        -> specific format for creating objects in java
        -> it has to have private attributes 
        -> it has to have a constructor that takes all the params
        -> it has to have getters and setters
        -> it has to have serialized
    -> spring will be able to use it w/o any other set up or config from us -> will be able to access our programs 
    ~ Now can go into controller ~
    -> needed to be a Java Been 
    -> added these id getter and setters so can access private Long id -> now need to create a route for this 
    */
    //~ Getters and setters 
    // have this setter b/c allows us to use and access the id -> not good practice to change the id -> SO DON'T CHANGE IT 
    public Long getId() {
        return this.id;
    }
    // now if check DB will see the new expenses table that has all the data I have set up

    public void setId(Long id) {
        this.id = id;
    }

    public String getExpenseName() {
        return this.expenseName;
    }

    public void setExpenseName(String expenseName) {
        this.expenseName = expenseName;
    }

    public String getVendor() {
        return this.vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public Integer getAmount() {
        return this.amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return this.updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    //now need to make the form that lets me create my burger 

}
