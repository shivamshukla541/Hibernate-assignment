package com.shivam.books;
import java.util.Scanner;

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
		
		Scanner sc = new Scanner(System.in);
		for(int i=0;i<10;i++) {
			
			Author at = new Author();
			
			System.out.println("Enter id for Author "+i);
			at.setAid(sc.next());
			System.out.println("Enter Date of Birth for Author "+i);
			at.setDob(sc.nextInt());
			System.out.println("Enter Name for Author "+i);
			at.setName(sc.next());
			
			session.save(at);   
			
		}
		
		for(int i=0;i<10;i++) {
			
			Book b = new Book();
			
			System.out.println("Enter id for Book "+i);
			b.setBid(sc.next());
			System.out.println("Enter name for Book "+i);
			b.setName(sc.next());
			System.out.println("Enter genre for Book "+i);
			b.setGenre(sc.next());
			System.out.println("Enter author name for Book "+i);
			b.setAuthor(sc.next());
			System.out.println("Enter price for Book "+i);
			b.setPrice(sc.nextFloat());
			
			session.save(b);
			
		}
		
		
		tr.commit();
		session.close();
		sf.close();
	}

}
