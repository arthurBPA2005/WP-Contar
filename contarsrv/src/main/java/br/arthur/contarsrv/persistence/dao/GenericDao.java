package br.arthur.contarsrv.persistence.dao;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
import javax.transaction.UserTransaction;

import br.arthur.contarsrv.persistence.EMFactory;

@Stateless
@SuppressWarnings("unchecked")
public abstract class GenericDao<T> {

	@SuppressWarnings("rawtypes")
	protected Class entityClass;

	public GenericDao(Class<T> entityClass) {
		this.entityClass = entityClass;
	}

	public void detach(T d) throws Exception {
		EntityManager em = EMFactory.getEntityManager();
		em.detach(d);
	}

	public T create(T d) throws PersistenceException {

		UserTransaction utx = EMFactory.getUserTransaction();
		try {
			if (utx != null) {
				utx.begin();

				EntityManager em = EMFactory.getEntityManager();
				em.merge(d);

				utx.commit();
			} else {
				EntityManager em = EMFactory.getEntityManager();
				em.merge(d);
			}
			return d;
		} catch (Exception e) {
			try {
				utx.rollback();
			} catch (Exception ignore) {
			}
			throw new PersistenceException(e.getMessage());
		}
	}

	public T update(T d) throws PersistenceException {

		UserTransaction utx = EMFactory.getUserTransaction();
		try {
			if (utx != null) {
				utx.begin();

				EntityManager em = EMFactory.getEntityManager();
				em.merge(d);

				utx.commit();
			} else {
				EntityManager em = EMFactory.getEntityManager();
				em.merge(d);
			}
			return d;
		} catch (Exception e) {
			try {
				utx.rollback();
			} catch (Exception ignore) {
			}
			throw new PersistenceException(e.getMessage());
		}
	}

	public void delete(Object chavePrimaria) throws PersistenceException {

		UserTransaction utx = EMFactory.getUserTransaction();
		try {
			if (utx != null) {
				utx.begin();

				EntityManager em = EMFactory.getEntityManager();
				T t = (T) em.find(entityClass, chavePrimaria);
				em.remove(t);

				utx.commit();
			} else {
				EntityManager em = EMFactory.getEntityManager();
				T t = (T) em.find(entityClass, chavePrimaria);
				em.remove(t);
			}
		} catch (Exception e) {
			try {
				utx.rollback();
			} catch (Exception ignore) {
			}
			throw new PersistenceException(e.getMessage());
		}
	}

	public void deleteAll() throws PersistenceException {

		UserTransaction utx = EMFactory.getUserTransaction();
		try {
			utx.begin();

			EntityManager em = EMFactory.getEntityManager();
			Query query = em.createQuery("delete from " + entityClass.getName());
			query.executeUpdate();

			utx.commit();
		} catch (Exception e) {
			try {
				utx.rollback();
			} catch (Exception ignore) {
			}
			throw new PersistenceException(e.getMessage());
		}
	}

	public void deleteAll(String condicao) throws PersistenceException {

		UserTransaction utx = EMFactory.getUserTransaction();
		try {
			utx.begin();

			EntityManager em = EMFactory.getEntityManager();
			Query query = em.createQuery("delete from " + entityClass.getName() + " obj where " + condicao);
			query.executeUpdate();

			utx.commit();
		} catch (Exception e) {
			try {
				utx.rollback();
			} catch (Exception ignore) {
			}
			throw new PersistenceException(e.getMessage());
		}
	}

	public List<T> getList() {

		EntityManager em = EMFactory.getEntityManager();
		Query query = em.createQuery("select obj from " + entityClass.getName() + " obj");
		return query.getResultList();
	}

	public List<T> getListByOrder(String campo) throws PersistenceException {

		EntityManager em = EMFactory.getEntityManager();
		Query query = em.createQuery("select obj from " + entityClass.getName() + " obj " + "order by obj." + campo);
		return query.getResultList();
	}

	public List<T> getListByCond(String condicao) {

		EntityManager em = EMFactory.getEntityManager();
		Query query = em.createQuery("select obj from " + entityClass.getName() + " obj " + "where " + condicao);

		return query.getResultList();
	}

	public List<T> getListByCond(String condicao, Map<String, Object> parametros) {
		EntityManager em = EMFactory.getEntityManager();

		Query query = em.createQuery("select obj from " + entityClass.getName() + " obj where " + condicao);

		if (parametros != null) {
			for (Map.Entry<String, Object> entry : parametros.entrySet()) {
				query.setParameter(entry.getKey(), entry.getValue());
			}
		}

		return query.getResultList();
	}

	public List<T> executeSql(String sql) throws PersistenceException {

		EntityManager em = EMFactory.getEntityManager();
		Query query = em.createQuery(sql);
		return query.getResultList();
	}

	public void execute(String sql) throws PersistenceException {

		UserTransaction utx = EMFactory.getUserTransaction();
		try {
			utx.begin();

			EntityManager em = EMFactory.getEntityManager();
			Query query = em.createQuery(sql);
//			System.out.println(sql);
			query.executeUpdate();

			utx.commit();
		} catch (Exception e) {
			try {
				utx.rollback();
			} catch (Exception ignore) {
			}
			throw new PersistenceException(e.getMessage());
		}
	}

	public void begin() throws PersistenceException {

		UserTransaction utx = EMFactory.getUserTransaction();
		try {
			if (utx.getStatus() != 0) {
				utx.begin();
			}
		} catch (Exception e) {
			try {
				utx.rollback();
			} catch (Exception ignore) {
			}
			throw new PersistenceException(e.getMessage());
		}
	}

	public void commit() throws PersistenceException {

		UserTransaction utx = EMFactory.getUserTransaction();
		try {
			utx.commit();
		} catch (Exception e) {
			try {
				utx.rollback();
			} catch (Exception ignore) {
			}
			throw new PersistenceException(e.getMessage());
		}
	}

	public void executeNative(String sql) throws PersistenceException {

		executeNative(sql, new HashMap<>());
	}

	public void executeNative(String sql, Map<String, Object> parametros) throws PersistenceException {

		UserTransaction utx = EMFactory.getUserTransaction();
		try {
			utx.begin();
			EntityManager em = EMFactory.getEntityManager();
			Query query = em.createNativeQuery(sql);
			for (Map.Entry<String, Object> entry : parametros.entrySet()) {
				query.setParameter(entry.getKey(), entry.getValue());
			}
			query.executeUpdate();
			utx.commit();
		} catch (Exception e) {
			try {
				utx.rollback();
			} catch (Exception ignore) {
				ignore.printStackTrace();
			}
			throw new PersistenceException(e.getMessage());
		}
	}

	public List<Integer> getListDistinct(String campo) throws PersistenceException {

		EntityManager em = EMFactory.getEntityManager();
		Query query = em
				.createQuery("select distinct(" + campo + ") as " + campo + " from " + entityClass.getName() + " obj ");
		return query.getResultList();
	}

	public List<Integer> getListDistinct(String campo, String condicao) throws PersistenceException {

		EntityManager em = EMFactory.getEntityManager();
		Query query = em.createQuery("select distinct(" + campo + ") as " + campo + " from " + entityClass.getName()
				+ " obj " + "where " + condicao);
		return query.getResultList();
	}

	public T getEntity(Object cod) throws PersistenceException {

		try {
			EntityManager em = EMFactory.getEntityManager();
			return (T) em.find(entityClass, cod);
		} catch (Exception e) {
			throw new PersistenceException(e.getMessage());
		}
	}

	public T getEntityByCond(String condicao) throws PersistenceException {

		EntityManager em = EMFactory.getEntityManager();
		Query query = em.createQuery("select obj from " + entityClass.getName() + " obj " + "where " + condicao);
		return (T) query.getSingleResult();
	}

	public T getEntityByNativeQuery(String condicao) throws PersistenceException {

		EntityManager em = EMFactory.getEntityManager();
		Query query = em.createNativeQuery(condicao, entityClass);
		return (T) query.getSingleResult();
	}

	public List<T> getListByNativeQuery(String condicao) throws PersistenceException {

		EntityManager em = EMFactory.getEntityManager();
		Query query = em.createNativeQuery(condicao, entityClass);
		return query.getResultList();
	}

	public List<T> getListByNativeQuery(String sql, Map<String, Object> parametros) throws PersistenceException {

		EntityManager em = EMFactory.getEntityManager();
		Query query = em.createNativeQuery(sql, entityClass);
		for (Map.Entry<String, Object> entry : parametros.entrySet()) {
			query.setParameter(entry.getKey(), entry.getValue());
		}
		return query.getResultList();
	}

	public Object getSigleByNativeQueryTypeless(String condicao) throws PersistenceException {

		EntityManager em = EMFactory.getEntityManager();
		Query query = em.createNativeQuery(condicao);
		return query.getSingleResult();
	}

	public List<Object[]> getListByNativeQueryTypeless(String sql) throws PersistenceException {

		EntityManager em = EMFactory.getEntityManager();
		Query query = em.createNativeQuery(sql);
		return query.getResultList();
	}

	public List<Object[]> getListByNativeQueryTypeless(String sql, Map<String, Object> parametros) {

		EntityManager em = EMFactory.getEntityManager();
		Query query = em.createNativeQuery(sql);
		for (Map.Entry<String, Object> entry : parametros.entrySet()) {
			query.setParameter(entry.getKey(), entry.getValue());
		}
		return query.getResultList();
	}

	public Integer getUtlCod(String campo) throws PersistenceException {

		EntityManager em = EMFactory.getEntityManager();
		Query query = em.createQuery("select max(obj." + campo + ") from " + entityClass.getName() + " obj");
		try {
			return ((Long) query.getSingleResult()).intValue();
		} catch (Exception e) {
			try {
				return ((Integer) query.getSingleResult());
			} catch (Exception e2) {
				try {
					return ((Short) query.getSingleResult()).intValue();
				} catch (Exception e3) {
					return 1;
				}
			}
		}
	}

	public Integer getUtlCod(String campo, String cond) throws PersistenceException {

		EntityManager em = EMFactory.getEntityManager();
		Query query = em
				.createQuery("select max(obj." + campo + ") from " + entityClass.getName() + " obj" + " where " + cond);
		try {
			return ((Long) query.getSingleResult()).intValue();
		} catch (Exception e) {
			try {
				return ((Integer) query.getSingleResult()).intValue();
			} catch (Exception e2) {
				try {
					return ((Short) query.getSingleResult()).intValue();
				} catch (Exception e3) {
					try {
						return ((Byte) query.getSingleResult()).intValue();
					} catch (Exception e4) {
						return 1;
					}
				}
			}
		}
	}

	public Integer getMaxVal(String campo, String cond) throws PersistenceException {

		EntityManager em = EMFactory.getEntityManager();
		Query query = em
				.createQuery("select max(obj." + campo + ") from " + entityClass.getName() + " obj" + " where " + cond);
		try {
			return ((Long) query.getSingleResult()).intValue();
		} catch (NullPointerException e) {
			return 1;
		} catch (Exception e) {
			try {
				return ((Integer) query.getSingleResult()).intValue();
			} catch (Exception e2) {
				try {
					return ((Short) query.getSingleResult()).intValue();
				} catch (Exception e3) {
					try {
						return ((Byte) query.getSingleResult()).intValue();
					} catch (Exception e4) {
						return 1;
					}
				}
			}
		}
	}

	public Integer getMaxVal0(String campo, String cond) throws PersistenceException {

		EntityManager em = EMFactory.getEntityManager();
		Query query = em
				.createQuery("select max(obj." + campo + ") from " + entityClass.getName() + " obj" + " where " + cond);
		try {
			return ((Long) query.getSingleResult()).intValue();
		} catch (NullPointerException e) {
			return 0;
		} catch (Exception e) {
			try {
				return ((Integer) query.getSingleResult()).intValue();
			} catch (Exception e2) {
				try {
					return ((Short) query.getSingleResult()).intValue();
				} catch (Exception e3) {
					try {
						return ((Byte) query.getSingleResult()).intValue();
					} catch (Exception e4) {
						return 0;
					}
				}
			}
		}
	}

	public Integer getNextCod(String campo) {

		EntityManager em = EMFactory.getEntityManager();
		Query query = em.createQuery("select max(obj." + campo + ") from " + entityClass.getName() + " obj");
		try {
			return ((Long) query.getSingleResult()).intValue() + 1;
		} catch (Exception e) {
			try {
				return ((Integer) query.getSingleResult()) + 1;
			} catch (Exception e2) {
				try {
					return ((Short) query.getSingleResult()).intValue() + 1;
				} catch (Exception e3) {
					return 1;
				}
			}
		}
	}

	public Integer getNextCod(String campo, String cond) {

		EntityManager em = EMFactory.getEntityManager();
		Query query = em
				.createQuery("select max(obj." + campo + ") from " + entityClass.getName() + " obj" + " where " + cond);
		try {
			Object obj = query.getSingleResult();
			if (obj == null) {
				return 1;
			} else if (obj instanceof Integer) {
				return ((Integer) obj) + 1;
			} else if (obj instanceof Long) {
				return ((Long) obj).intValue() + 1;
			} else if (obj instanceof Short) {
				return ((Short) query.getSingleResult()).intValue() + 1;
			} else if (obj instanceof Byte) {
				return ((Byte) query.getSingleResult()).intValue() + 1;
			} else if (obj instanceof String) {
				return Integer.parseInt((String) obj);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 1;
	}

	public boolean codIsFree(Integer codPesquisa, String campo) throws PersistenceException {

		try {
			EntityManager em = EMFactory.getEntityManager();
			Query query = em.createQuery("select 1 from " + entityClass.getName() + " obj where obj." + campo + " = "
					+ codPesquisa.toString());
			return query.getResultList().size() == 0;
		} catch (Exception e) {
			throw new PersistenceException(e.getMessage());
		}
	}

	public Long getCount(String condicao) throws PersistenceException {

		try {
			EntityManager em = EMFactory.getEntityManager();
			Query query = em.createQuery("select count(*) from " + entityClass.getName() + " obj where " + condicao);
			try {
				return (Long) query.getSingleResult();
			} catch (Exception e) {
				return ((Integer) query.getSingleResult()).longValue();
			}
		} catch (Exception e) {
			throw new PersistenceException(e.getMessage());
		}
	}

	public Long getNextCodSequence(String nomeSequenece) {

		EntityManager em = EMFactory.getEntityManager();
		Query qe = em.createNativeQuery("SELECT " + nomeSequenece + ".NEXTVAL FROM DUAL");
		BigDecimal codigo = (BigDecimal) qe.getResultList().iterator().next();
		return codigo.longValue();
	}

	public void refresh(T entity) {
		EntityManager em = EMFactory.getEntityManager();
		em.refresh(entity);
	}
}
