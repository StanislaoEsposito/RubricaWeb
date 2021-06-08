package com.protom.model.util;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class DBUtil {
	
	public static final String RUBRICA_WEB_PU = "RubricaWeb";

	public static EntityManager getEntityManager(String s) {
		return Persistence.createEntityManagerFactory(s).createEntityManager();
	}

}
