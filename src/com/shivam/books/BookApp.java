package com.shivam.books;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.*;

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
			
		session.save(at);   
			
		Book b = new Book();
			
		b.setBid("b1");
		b.setName("Lost_Soul");
		b.setGenre("Philosophical");
		b.setAuthor("Shivam");
		b.setPrice(110);
			
		session.save(b);
			
		b.setAt(at);
			
		tr.commit();
		session.close();
		
	}

}
