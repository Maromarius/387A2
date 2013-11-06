/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.assignment2.dao;

import java.sql.Connection;
import com.assignment2.util.DatabaseConnection;
import com.assignment2.model.PeopleContainer;
import com.assignment2.model.Person;

import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Philip
 */
public class PersonService 
{
    private PeopleContainer peopleContainer;
    
    public PersonService()
    {
        peopleContainer = new PeopleContainer();
    }
   
    
    public PeopleContainer PopulateFirstLastNamesContainer()
    {
		return peopleContainer;
        
        
    }
    
    private void getAllFirstLastNamesIds()
    {
        //get all id, firstname and lastname from db
        HashMap<Integer,Person> personList = new HashMap<Integer,Person>();
        
        
        //Connect to db and get lists
        Person person = new Person();
        person.setFirstName(null);
        person.setLastName(null);
        person.setpId(-1);
        peopleContainer.AddPerson(person);
    }
    private void getAllPersonInfo(int pid)
    {
        Person person = peopleContainer.GetPerson(pid);
        //get remaining info from db.
        person.setAddress(null);
        person.setPhoneNumber(null);
        //update peopleContainer
        peopleContainer.UpdatePerson(pid, person);
    }
    
    public boolean UpdatePerson(Person p)
    {
        //Push Person Data to db
        return true;
    }
    
}
