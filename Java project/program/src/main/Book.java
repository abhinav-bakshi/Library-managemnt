package main;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class Book 
{
	public Boolean addBook(bookdetails bd,Map<Long, bookdetails> bm) 
	{
		//Add book to map
		bm.put(bd.getBookID(), bd);
		//Return true once book added
		return true;
	}
	
	public Boolean deleteBook(Long ID,Map<Long, bookdetails> bm) 
	{
		//Iterate Book map
		Iterator<Entry<Long, bookdetails>> itr = bm.entrySet().iterator();
		//Iterate Books
		while (itr.hasNext()) 
		{			
			Entry<Long, bookdetails> entry = itr.next();
			//Compare bookID and remove
			if(ID == entry.getKey())
			{
				
				if(entry.getValue().getIssued())
				{
					System.out.println("You can not delete issued book!");
					break;
				}
				//Remove book entry from the map
				itr.remove();
				//Return true
				return true;
			}			
		}
		//Return false if book not deleted
		return false;
	}

	
	public void displayAvailableBookInfo(Map<Long, bookdetails> bm) 
	{		
		//Iterate Book map
		Iterator<Entry<Long, bookdetails>> itr = bm.entrySet().iterator();
		System.out.println("BOOK ID \t AUTHOR \t TITLE");
		//Iterate Books object
		while (itr.hasNext()) 
		{			
			Entry<Long, bookdetails> entry = itr.next();
			bookdetails bd = entry.getValue();
			//Check issued indicator as false
			if(bd!=null && !bd.getIssued())
			{
				System.out.println(entry.getKey().toString() +"\t\t"+ bd.getAuthor() +"\t\t"+ bd.getTitle());
			}			
		}	
	}
	
	
	
	public void displayIssuedBookInfo(Map<Long, bookdetails> bm) 
	{
		//Iterate Book map
		Iterator<Entry<Long, bookdetails>> itr = bm.entrySet().iterator();
		//Instantiate Column object
		System.out.println("BOOK ID \t AUTHOR \t TITLE");
		//Iterate Books object
		while (itr.hasNext()) 
		{			
			Entry<Long, bookdetails> entry = itr.next();
			bookdetails bd = entry.getValue();
			//Check issued indicator and it should be true
			if(bd.getIssued())
			{				
				System.out.println(entry.getKey().toString() +"\t\t"+ bd.getAuthor() +"\t\t"+ bd.getTitle());
			}			
		}
	}

}
