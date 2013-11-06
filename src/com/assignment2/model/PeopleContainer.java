/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.assignment2.model;
import java.util.HashMap;
import java.util.Map;
import com.assignment2.controller.*;


/**
 *
 * @author Philip
 */
public class PeopleContainer {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    private Map<Integer,Person> peopleList;
    
    public PeopleContainer()
    {
        peopleList = new HashMap<Integer,Person>() {};
    }
    
    public void AddPerson(Person p)
    {
        peopleList.put(p.getpId(), p);
    }
    
    public Person GetPerson(int pid)
    {
        return peopleList.get(pid);
    }
    
    public void RemovePerson(int pid)
    {
    	peopleList.remove(pid);
    }
    
    public void UpdatePerson(int pid, Person newPerson)
    {
        peopleList.remove(pid);
        
        peopleList.put(pid, newPerson);
    }
    
    public Map<Integer,Person> GetPeopleList()
    {
        return peopleList;
    }

}
