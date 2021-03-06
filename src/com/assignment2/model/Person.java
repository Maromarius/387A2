package com.assignment2.model;

public class Person {

		private int pId;
	    private String firstName;
	    private String lastName;
	    private String address;
	    private String phoneNumber;
	    private boolean lazyLoaded;
	    private boolean isStoredInDatabase;

	    public Person()
	    {
	    	lazyLoaded = false;
	        firstName = "";
	        lastName = "";
	        address = "";
	        phoneNumber = "";
	        pId = -1;
	    }
	    public Person(int pid, String firstname, String lastname, String addr, String phonenumber, boolean lazyloaded)
	    {
	        firstName = firstname;
	        lastName = lastname;
	        phoneNumber = phonenumber;
	        address = addr;
	        pId = pid;
	        lazyLoaded = lazyloaded;
	    }
	       
	    
	    /**
	     * @return the pId
	     */
	    public int getpId() 
	    {
	        return pId;
	    }

	    /**
	     * @param pId the pId to set
	     */
	    public void setpId(int pId) 
	    {
	        this.pId = pId;
	    }

	    /**
	     * @return the firstName
	     */
	    public String getFirstName() 
	    {
	        return firstName;
	    }

	    /**
	     * @param firstName the firstName to set
	     */
	    public void setFirstName(String firstName) 
	    {
	        this.firstName = firstName;
	    }

	    /**
	     * @return the lastName
	     */
	    public String getLastName() 
	    {
	        return lastName;
	    }

	    /**
	     * @param lastName the lastName to set
	     */
	    public void setLastName(String lastName) 
	    {
	        this.lastName = lastName;
	    }

	    /**
	     * @return the address
	     */
	    public String getAddress() 
	    {
	        return address;
	    }

	    /**
	     * @param address the address to set
	     */
	    public void setAddress(String address) 
	    {
	        this.address = address;
	    }

	    /**
	     * @return the phoneNumber
	     */
	    public String getPhoneNumber() 
	    {
	        return phoneNumber;
	    }

	    /**
	     * @param phoneNumber the phoneNumber to set
	     */
	    public void setPhoneNumber(String phoneNumber) 
	    {
	        this.phoneNumber = phoneNumber;
	    }
	    
	    public void setLazyLoaded()
	    {
	    	lazyLoaded = true;
	    }
	    
	    public boolean isLazyLoaded()
	    {
	    	return lazyLoaded;
	    }
	    
	    public boolean isEqual(Person p)
	    {
	    	return (this.address.equals(p.getAddress()) && this.phoneNumber.equals(p.getPhoneNumber()) && this.firstName.equals(p.getFirstName()) && this.lastName.equals(p.getLastName()) && this.pId == p.getpId());
	    }
	

}
