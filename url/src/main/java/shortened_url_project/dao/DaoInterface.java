package shortened_url_project.dao;

import java.io.Serializable;

public interface DaoInterface<T, Id extends Serializable> {
	public void persist(T entity);
	public void update(T entity);
	public T getById(long id);
	public void delete(T entity);
	
}
