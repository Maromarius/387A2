package com.assignment2.controller;
import java.util.*;
import com.assignment2.dao.PersonService;
import com.assignment2.model.PeopleContainer;
public class UnitOfWork {
	
	private HashMap<Integer, Integer> info = new HashMap<Integer, Integer>();//Contains Information
	
	public UnitOfWork(){
	}
	public void registerNew(int pid)
	{
		if(info.containsKey(pid))
			return;
		else
			info.put(pid, 1);
	}
	
	public void registerDirty(int pid)
	{
		if(info.containsKey(pid))
		{
			info.remove(pid);
			info.put(pid, 2);
		}
		else
			info.put(pid, 2);			
	}
	
	public void registerRemoved(int pid)
	{
		if(info.containsKey(pid))
		{
			info.remove(pid);
			info.put(pid, 3);
		}
		else
			info.put(pid, 3);
	}
	
	public void commit(PersonService PS, PeopleContainer PC)
	{
		//Iterates through the HashMap
		Iterator it = info.entrySet().iterator();
		while(it.hasNext())
		{
			Map.Entry pair = (Map.Entry)it.next();
			//Produces the Operations for the DB with the ID's
			if((int)pair.getValue()==1)
			{
				PS.createPerson(PC.GetPerson((int)pair.getKey()));
			}
			if((int)pair.getValue()==2)
			{
				PS.updatePerson(PC.GetPerson((int)pair.getKey()));
			}
			if((int)pair.getValue()==3)
			{
				PS.deletePerson(PC.GetPerson((int)pair.getKey()));
			}
		}
	}
}
