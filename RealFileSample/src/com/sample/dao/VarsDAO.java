package com.sample.dao;

import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.sample.dbo.Vars;

/**
 * A data access object (DAO) providing persistence and search support for Vars
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see com.sample.dao.Vars
 * @author MyEclipse Persistence Tools
 */
public class VarsDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory.getLogger(VarsDAO.class);
	// property constants
	public static final String SORT = "sort";
	public static final String ROW_INDEX = "rowIndex";
	public static final String ROW_FILTER = "rowFilter";
	public static final String ROW_REPLACE = "rowReplace";
	public static final String CELL_INDEX = "cellIndex";
	public static final String CELL_FILTER = "cellFilter";
	public static final String CELL_REPLACE = "cellReplace";
	public static final String ACTIVE = "active";

	protected void initDao() {
		// do nothing
	}

	public void save(Vars transientInstance) {
		log.debug("saving Vars instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Vars persistentInstance) {
		log.debug("deleting Vars instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Vars findById(java.lang.Integer id) {
		log.debug("getting Vars instance with id: " + id);
		try {
			Vars instance = (Vars) getHibernateTemplate().get(
					"com.sample.dbo.Vars", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Vars instance) {
		log.debug("finding Vars instance by example");
		try {
			List results = getHibernateTemplate().findByExample(instance);
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Vars instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Vars as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}
	
	public List findByContentProperty(String propertyName, Object value) {
		log.debug("finding Vars instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = 
					"from Vars as model " +
					"left join fetch model.content as c " +
					"where c." + propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}
	
	public List findByContentId(Object contentId) {
		return findByContentProperty("contentId", contentId);
	}

	public List findBySort(Object sort) {
		return findByProperty(SORT, sort);
	}

	public List findByRowIndex(Object rowIndex) {
		return findByProperty(ROW_INDEX, rowIndex);
	}

	public List findByRowFilter(Object rowFilter) {
		return findByProperty(ROW_FILTER, rowFilter);
	}

	public List findByRowReplace(Object rowReplace) {
		return findByProperty(ROW_REPLACE, rowReplace);
	}

	public List findByCellIndex(Object cellIndex) {
		return findByProperty(CELL_INDEX, cellIndex);
	}

	public List findByCellFilter(Object cellFilter) {
		return findByProperty(CELL_FILTER, cellFilter);
	}

	public List findByCellReplace(Object cellReplace) {
		return findByProperty(CELL_REPLACE, cellReplace);
	}

	public List findByActive(Object active) {
		return findByProperty(ACTIVE, active);
	}

	public List findAll() {
		log.debug("finding all Vars instances");
		try {
			String queryString = "from Vars";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Vars merge(Vars detachedInstance) {
		log.debug("merging Vars instance");
		try {
			Vars result = (Vars) getHibernateTemplate().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Vars instance) {
		log.debug("attaching dirty Vars instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Vars instance) {
		log.debug("attaching clean Vars instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static VarsDAO getFromApplicationContext(ApplicationContext ctx) {
		return (VarsDAO) ctx.getBean("VarsDAO");
	}
}