package br.arthur.contarsrv.persistence;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.persistence.EntityManager;
import javax.transaction.UserTransaction;

public class EMFactory {

	public static EntityManager getEntityManager() {
		
		try {
			Context ctx = new InitialContext();
			return (EntityManager) ctx.lookup("java:comp/env/Controle/EntityManager");
		} catch (Exception e) {
			throw new IllegalStateException("Falha no lookup do EntityManager (java:comp/env/Controle/EntityManager)", e);
		}
	}

	public static UserTransaction getUserTransaction() {
		
		try {
			Context ctx = new InitialContext();
			return (UserTransaction) ctx.lookup("java:comp/UserTransaction");
		} catch (Exception e) {
			return null;
		}
	}	
}
