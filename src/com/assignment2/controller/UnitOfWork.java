package com.assignment2.controller;
import java.util.*;

public class UnitOfWork {
	
	private HashMap<Integer, Integer> info = new HashMap<Integer, Integer>();//Contains Information

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
		//Iterates through the HashMap
		Iterator it = info.entrySet().iterator();
		while(it.hasNext())
		{
			Map.Entry pair = (Map.Entry)it.next();
			//Produces the Operations for the DB with the ID's
			if((int)pair.getValue()==1)
			{
				//CREATE NEW ENTRY ON DB pair.getKey()
			}
			if((int)pair.getValue()==2)
			{
				//UPDATE ON DB pair.getKey()
			}
			if((int)pair.getValue()==3)
			{
				//DELETE ON DB pair.getKey()
			}
		}
	}
}
