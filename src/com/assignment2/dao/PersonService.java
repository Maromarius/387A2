/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.assignment2.dao;

import java.sql.Connection;
import com.assignment2.util.DatabaseConnection;
import com.assignment2.model.PeopleContainer;
import com.assignment2.model.Person;
import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Philip
 */
public class PersonService 
{
	private PersonDao dao;
    
    public PersonService()
    {
    	dao = new PersonDao();
    }
   
    public PeopleContainer getAllFirstLastNamesIds()
    {  
    	PeopleContainer peopleContainer = new PeopleContainer();
        String[] firstNames = dao.getAllFirstNames();
        String[] lastNames = dao.getAllLastNames();
        int[] ids = dao.getAllIds();
        
        if(ids.length == firstNames.length && firstNames.length == lastNames.length)
        {
        	for(int i = 0; i < ids.length; i++)
        	{
        		Person person = new Person();
                person.setFirstName(firstNames[i]);
                person.setLastName(lastNames[i]);
                person.setpId(ids[i]);
                peopleContainer.AddPerson(person);
            }
        }
        return peopleContainer;
    }
    
    public Person getAllPersonInfo(int pid)
    {
    	Person person = new Person();
        ArrayList<String> personInfo = (ArrayList<String>) dao.getPersonbyId(pid);
        person.setpId(Integer.parseInt(personInfo.get(0)));
        person.setFirstName(personInfo.get(1));
        person.setLastName(personInfo.get(2));
        person.setAddress(personInfo.get(3));
        person.setPhoneNumber(personInfo.get(4));
        return person;
    }
    
    public boolean updatePerson(int pid)
    {
        return dao.updateUser(peopleContainer.GetPerson(pid));
    }
    
    public boolean deletePerson(int pid)
    {
    	return dao.deleteUser(pid);
    }

    public boolean createPerson(int pid)
    {
    	return dao.addPerson(peopleContainer.GetPerson(pid));
    }
    
}
