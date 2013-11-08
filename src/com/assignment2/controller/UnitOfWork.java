package com.assignment2.controller;
import java.util.*;
import com.assignment2.dao.PersonService;
import com.assignment2.model.PeopleContainer;
public class UnitOfWork {
	
	private HashMap<Integer, Integer> info;//Contains Information
	private static UnitOfWork UOW;
	
	private UnitOfWork()
	{
		info = new HashMap<Integer, Integer>();
	}
	
	public static UnitOfWork GetInstance()
	{
		if(UOW == null)
			UOW = new UnitOfWork();
		return UOW;
	}
	
	public boolean ContainsKey(int pid)
	{
		return info.containsKey(pid);
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
	
	public void commit()
	{
		if(info.size() > 0)
		{
			//Iterates through the HashMap
			Iterator it = info.entrySet().iterator();
			while(it.hasNext())
			{
				Map.Entry pair = (Map.Entry)it.next();
				//Produces the Operations for the DB with the ID's
				if((int)pair.getValue()==1)
				{
					PersonService.getInstance().createPersonDAO((int)pair.getKey());
				}
				if((int)pair.getValue()==2)
				{
					PersonService.getInstance().updatePersonDAO((int)pair.getKey());
				}
				if((int)pair.getValue()==3)
				{
					PersonService.getInstance().deletePersonDAO((int)pair.getKey());
				}
			}
			info.clear();
		}
	}
}
