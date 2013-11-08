/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.assignment2.model;
import java.util.ArrayList;
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
    
	private ArrayList<Integer> pIds;
    private HashMap<Integer,Person> peopleList;
    private int size;
    
    public PeopleContainer()
    {
    	pIds = new ArrayList<Integer>();
        peopleList = new HashMap<Integer,Person>();
        size=0;
    }
    
    public void AddPerson(Person p)
    {
    	pIds.add(p.getpId());
        peopleList.put(p.getpId(), p);
        size++;
    }
    
    public Person GetPerson(int pid)
    {
        return peopleList.get(pid);
    }
    
    public boolean RemovePerson(int pid)
    {
    	if(peopleList.containsKey(pid))
    	{
    		pIds.remove(pid);
    		peopleList.remove(pid);
        	size--;
    		return true;
    	}
    	return false;
    }
    
    public void UpdatePerson(int pid, Person newPerson)
    {
        peopleList.remove(pid);
        peopleList.put(pid, newPerson);
    }
    public int getSize(){
    	return size;
    }
    public ArrayList<Person> GetPersonList()
    {
    	ArrayList<Person> people = new ArrayList<Person>();
    	for(int i = 0; i < pIds.size();i++)
    	{
    		people.add(peopleList.get(pIds.get(i)));
    	}
    	return people;
    }
    public HashMap<Integer,Person> GetContainer()
    {
        return peopleList;
    }

}
