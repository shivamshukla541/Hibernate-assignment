package com.shivam.books;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.*;

/**
 * @author Shivam Shukla
 *
 */
public class BookApp {

	public static void main(String[] args) {
		
		
		Configuration con = new Configuration().configure().addAnnotatedClass(Author.class).addAnnotatedClass(Book.class);
		ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
		SessionFactory sf = con.buildSessionFactory(reg);
		Session session = sf.openSession();
		
		Transaction tr =  session.beginTransaction();
		
		Author at = new Author();
			
		at.setAid("a1");
		at.setDob(1997);
		at.setName("Shivam");
			
		   
			
		Book b = new Book();
			
		b.setBid("b1");
		b.setName("Lost_Soul");
		b.setGenre("Philosophical");
		b.setAuthor("Shivam");
		b.setPrice(110);
			
			
		Book b2 = new Book();
		
		b2.setBid("b2");
		b2.setName("The_Jury");
		b2.setGenre("Crime");
		b2.setAuthor("Shivam");
		b2.setPrice(110);
			
		b.setAt(at);
		b2.setAt(at);
		
		session.save(at);
		session.save(b);
		session.save(b2);

		
					
		tr.commit();
		session.close();
		
	}

}
