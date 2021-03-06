/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.assignment2.dao;

import com.assignment2.controller.UnitOfWork;
import com.assignment2.model.IdentityMap;
import com.assignment2.model.PeopleContainer;
import com.assignment2.model.Person;

import java.util.ArrayList;

/**
 *
 * @author Philip
 */
public class PersonService 
{
	private static PersonService instance;
	private static IdentityMap identityMap;
	private PeopleContainer peopleContainer;
	private int NextPId;
	
	private PersonDao dao;
    
    private PersonService()
    {
    	dao = new PersonDao();
    	peopleContainer = new PeopleContainer();
    	NextPId = 1;
    }
   
    public static PersonService getInstance() {
    	if(instance == null)
    	{
    		instance = new PersonService();
    	}
        return instance;
    }
    
    /*public PeopleContainer getContainer()
    {
    	return peopleContainer;
    }*/
    
    public boolean personExists(Person p)
    {
    	return peopleContainer.GetPersonMap().containsKey(p.getpId());
    }
    
    public int getNextPId()
    {
    	return NextPId++;
    }
    
    public PeopleContainer getAllFirstLastNamesIds()
    {  
    	//call to database
    	peopleContainer = new PeopleContainer();
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
                peopleContainer.addPerson(person);
            }
        }
        return peopleContainer;
    }
    
    public Person getAllPersonInfo(int pid)
    {
    	//call to database
    	Person person = peopleContainer.GetPersonMap().get(pid);
    	
        String[] personInfo = dao.getPersonbyId(pid);
        person.setAddress(personInfo[3]);
        person.setPhoneNumber(personInfo[4]);
        person.setLazyLoaded();
        
        peopleContainer.GetPersonMap().put(pid, person);
        
        return person;
    }
    
    public Person getExistingPerson(int pid)
    {
    	return peopleContainer.getPerson(pid);
    }
    
    public boolean createPerson(Person p)
    {
    	UnitOfWork.GetInstance().registerNew(p.getpId());
    	peopleContainer.addPerson(p);
    	
    	return true;
    }
    
    public boolean updatePerson(Person p)
    {
    	UnitOfWork.GetInstance().registerDirty(p.getpId());
    	peopleContainer.updatePerson(p);
        return true;
    }
    
    public boolean deletePerson(int pid)
    {
    	UnitOfWork.GetInstance().registerRemoved(pid);
    	peopleContainer.removePerson(pid);
    	return true;
    }

    public boolean createPersonDAO(int pid)
    {
    	Person p = peopleContainer.getPerson(pid);
    	return dao.addPerson(p.getFirstName(),p.getLastName(),p.getPhoneNumber(),p.getAddress());
    }
    
    public boolean updatePersonDAO(int pid)
    {
    	Person p = peopleContainer.getPerson(pid);
    	return dao.updatePerson(p.getpId(),p.getFirstName(),p.getLastName(),p.getPhoneNumber(),p.getAddress());
    }
    
    public boolean deletePersonDAO(int pid)
    {
    	return dao.deletePerson(pid);
    }
    
    public boolean isEmpty()
    {
    	return peopleContainer.GetSize() == 0;
    }
    
    public ArrayList<Person> getAllExistingPeople()
    {
    	return peopleContainer.getPersonList();
    }
}
