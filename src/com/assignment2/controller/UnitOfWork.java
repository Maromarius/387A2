package com.assignment2.controller;
import java.util.*;

public class UnitOfWork {
	
	private HashMap<Integer, Integer> info = new HashMap<Integer, Integer>();
	
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
	
	public void registerClean(Person prs)
	{
		if(prs.getId() == null)
			return;
	}
	
	public void commit()
	{
		insertNew();
		updateDirty();
		deleteRemoved();
	}
	
	public void insertNew()
	{
		for(Iterator objects = newObjects.iterator(); objects.hasNext();)
		{
			Person prs = (Person) objects.next();
			//TODO Create New Person on DB
		}
	}
	
	public void updateDirty()
	{
		for(Iterator objects = dirtyObjects.iterator(); objects.hasNext();)
		{
			Person prs = (Person) objects.next();
			// TODO Update Person on DB
		}
	}
	
	public void deleteRemoved()
	{
		for(Iterator objects = removedObjects.iterator(); objects.hasNext();)
		{
			Person prs = (Person) objects.next();
			//TODO Delete Person on DB
		}
	}
	

}
