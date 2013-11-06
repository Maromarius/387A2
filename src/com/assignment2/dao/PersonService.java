/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.assignment2.dao;

import com.assignment2.model.PeopleContainer;
import com.assignment2.model.Person;

/**
 *
 * @author Philip
 */
public class PersonService 
{
    private boolean isConnected;
    private PeopleContainer peopleContainer;
    
    public PersonService()
    {
        isConnected = false;
        peopleContainer = new PeopleContainer();
    }
    
    public boolean Connect()
    {
        isConnected = true; //db attempt connection;
        if(isConnected)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    public PeopleContainer PopulateFirstLastNamesContainer()
    {
		return peopleContainer;
        
        
    }
    
    private void populateFirstNameLastNames()
    {
        if(isConnected)
        {
            //get all id, firstname and lastname from db
            
            Person person = new Person();
            person.setFirstName(null);
            person.setLastName(null);
            person.setpId(-1);
            peopleContainer.AddPerson(person);
        }
    }
    private void getAllPersonInfo(int pid)
    {
        if(isConnected)
        {
            Person person = peopleContainer.GetPerson(pid);
            //get remaining info from db.
            person.setAddress(null);
            person.setPhoneNumber(null);
            //update peopleContainer
            peopleContainer.UpdatePerson(pid, person);
        }
    }
    
    public boolean UpdatePerson(Person p)
    {
        //Push Person Data to db
        return true;
    }
    
}
