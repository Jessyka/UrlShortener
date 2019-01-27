package shortened_url_project.dao;

import org.hibernate.JDBCException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import shortened_url_project.model.UrlModel;

public class UrlDao implements DaoInterface<UrlModel, String> {
	
	private Session currentSession;
	private Transaction currentTransaction;
	private static SessionFactory sessionFactory;
	
	public Session openCurrentSession() {
		currentSession = getSessionFactory().openSession();
		return currentSession;
	}
	
	public Session openCurrentSessionwithTransaction() {
		currentSession = getSessionFactory().openSession();
		currentTransaction = currentSession.beginTransaction();
		return currentSession;
	}
	
	public void closeCurrentSession() {
		currentSession.close();
	}
	
			     
	public void closeCurrentSessionwithTransaction() {
		currentTransaction.commit();
		currentSession.close();
	}
	
	private static SessionFactory getSessionFactory() {		
		if(sessionFactory == null)
			sessionFactory = new Configuration().configure().buildSessionFactory();
		return sessionFactory;
	}
	
	public Session getCurrentSession() {
		return currentSession;
	}
	
	public void setCurrentSession(Session currentSession) {
		this.currentSession = currentSession;
	}
	
	public Transaction getCurrentTransaction() {
		return currentTransaction;
	}
	
	public void setCurrentTransaction(Transaction currentTransaction) {
		this.currentTransaction = currentTransaction;
	}
	
	public void persist(UrlModel entity) {
		getCurrentSession().save(entity);
	}
	
	public void update(UrlModel entity) {
		getCurrentSession().update(entity);
	}
	
	public UrlModel getById(long id) {
		UrlModel urlmodel = (UrlModel) getCurrentSession().get(UrlModel.class, id);
		return urlmodel;
	}
	
	public UrlModel getByOriginalUrl(String url) {
		String jpql = "select a from UrlModel a where a.original_url = :url";
		
		Query<UrlModel> query = getCurrentSession().createQuery(jpql);
		query.setParameter("url", url);
		
		UrlModel urlmodel = (UrlModel) query.setMaxResults(1).getSingleResult();
		return urlmodel;
	}
	
	public UrlModel getByShortened(long id) {
		
		String jpql = "select a from UrlModel a where a.id = :id";
		
		Query<UrlModel> query = getCurrentSession().createQuery(jpql);
		query.setParameter("id", id);
		
		UrlModel urlmodel = (UrlModel) query.setMaxResults(1).getSingleResult();
		return urlmodel;
	}
	
	public void delete(UrlModel entity) {
		getCurrentSession().delete(entity);
	}
}
