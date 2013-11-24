package com.qieventos.persistence;


import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.Session;

public class Connection implements AutoCloseable {
	
	private SessionFactory sessionFactory;
	private Session session;
	
	
	private Connection() {
		
		
		try {
            // Create the SessionFactory from hibernate.cfg.xml
            this.setSessionFactory(new Configuration().configure().buildSessionFactory());
            this.session = this.sessionFactory.openSession();
        }
        catch (Throwable ex) {
            // Make sure you log the exception, as it might be swallowed
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
		
	}
		
		
		
		private static class SingletonHoler{
			static Connection connection = new Connection();  
		}
	
	
	 
	public static Connection getConnection() {
		
		return SingletonHoler.connection;
		
	}

	public Session getSession() 
	{
		return this.session;
	}

	private void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}



	@Override
	public void close() throws Exception {
		
		SingletonHoler.connection.session.close();
	}
	 
}
 
