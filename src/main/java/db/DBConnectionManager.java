package db;

import models.Client;
import org.hibernate.HibernateException;
import org.hibernate.Metamodel;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import javax.persistence.metamodel.EntityType;

public class DBConnectionManager {
    private static final SessionFactory ourSessionFactory;

    static {
        try {
            Configuration configuration = new Configuration();
            configuration.configure();

            ourSessionFactory = configuration.buildSessionFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static Session getSession() throws HibernateException {
        return ourSessionFactory.openSession();
    }

    public DBConnectionManager(){
        final Session session = getSession();
        try {
            System.out.println("querying all the managed entities...");
            final Metamodel metamodel = session.getSessionFactory().getMetamodel();
            for (EntityType<?> entityType : metamodel.getEntities()) {
                final String entityName = entityType.getName();
                final Query query = session.createQuery("from " + entityName);
                System.out.println("executing: " + query.getQueryString());
            }
        } finally {
            session.close();
        }
    }

    public static void closeConnection(){
        getSession().close();
    }

    public static void save(Object var1) {
        // Return some cliched textual content
        Session session = DBConnectionManager.getSession();
        session.beginTransaction();

        //Save the client in database
        session.save(var1);

        //Commit the transaction
        session.getTransaction().commit();
        DBConnectionManager.closeConnection();
    }
}
