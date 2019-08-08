package ru.avtotest.ab.appmanager;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import ru.avtotest.ab.model.AccountFields;
import ru.avtotest.ab.model.Accounts;
import ru.avtotest.ab.model.GroupData;
import ru.avtotest.ab.model.Groups;

import java.util.List;

public class DbHelper {

  private final SessionFactory sessionFactory;

  public DbHelper() {

    // A SessionFactory is set up once for an application!
    final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
            .configure() // configures settings from hibernate.cfg.xml
            .build();
    sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();

  }

  public Groups groups() {
    Session session = sessionFactory.openSession();
    session.beginTransaction();
    List<GroupData> result = session
            .createQuery("from GroupData").list();
    session.getTransaction().commit();
    session.close();
    return new Groups(result);
  }

  public Accounts accounts() {
    Session session = sessionFactory.openSession();
    session.beginTransaction();
    List<AccountFields> result = session
            .createQuery("from AccountFields where deprecated = '0000-00-00'").list();
    session.getTransaction().commit();
    session.close();
    return new Accounts(result);

  }
}
