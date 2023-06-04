package org.jsp.userApp.Controller;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test {
public static void main(String[] args) {
	SessionFactory s=new Configuration().configure().buildSessionFactory();
	System.out.println("Table Created");
}
}
