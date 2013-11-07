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
    	ArrayList<String> firstNames = new ArrayList<String>();
    	ArrayList<String> lastNames = new ArrayList<String>();
        firstNames = dao.getAllFirstNames();
        lastNames = dao.getAllLastNames();
        ArrayList<Integer> ids = dao.getAllIds();
        
        if(ids.size() == firstNames.size() && firstNames.size() == lastNames.size())
        {
        	for(int i = 0; i < ids.size(); i++)
        	{
        		Person person = new Person();
                person.setFirstName(firstNames.get(i));
                person.setLastName(lastNames.get(i));
                person.setpId(ids.get(i));
                peopleContainer.AddPerson(person);
            }
        }
        return peopleContainer;
    }
    
    public Person getAllPersonInfo(int pid)
    {
    	Person person = new Person();
    	
        String[] personInfo = dao.getPersonbyId(pid);
        person.setpId(Integer.parseInt(personInfo[0]));
        person.setFirstName(personInfo[1]);
        person.setLastName(personInfo[2]);
        person.setAddress(personInfo[3]);
        person.setPhoneNumber(personInfo[4]);
        return person;
    }
    
    public boolean updatePerson(Person p)
    {
        return dao.updateUser(p.getpId(),p.getFirstName(),p.getLastName(),p.getPhoneNumber(),p.getAddress());
    }
    
    public boolean deletePerson(Person p)
    {
    	return dao.deleteUser(p.getpId());
    }

    public boolean createPerson(Person p)
    {
    	return dao.addPerson(p.getpId(),p.getFirstName(),p.getLastName(),p.getPhoneNumber(),p.getAddress());
    }
    
}
