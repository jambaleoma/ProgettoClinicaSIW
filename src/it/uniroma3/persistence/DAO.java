package it.uniroma3.persistence;

import java.util.List;

public interface DAO<C> {
	public void save(C entity);
	public void update(C entity);
	public C findByPrimaryKey(long id);
	public void delete(C entity);
	public List<C> findAll();

}
