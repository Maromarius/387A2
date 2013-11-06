import java.util.*;

public class IdentityMap {

	private List personId = new ArrayList();
	
	public boolean verifyIntegrity(int id)
	{
		for(Iterator ids = personId.iterator(); ids.hasNext();)
		{
			if(id == (int)ids.next())
				return false;
		}
		personId.add(id);
		return true;
	}
	
}
