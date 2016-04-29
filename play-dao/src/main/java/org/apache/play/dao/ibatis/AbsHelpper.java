package org.apache.play.dao.ibatis;

import java.util.ArrayList;
import java.util.List;

import org.apache.play.dao.IHelpper;

public abstract class AbsHelpper<T> implements IHelpper<T> {
  
  private String TowerTabName;
  /*
   * (non-Javadoc)
   * @see com.tower.service.dao.ibatis.IHelpper#getTowerTabName()
   */
  
  public String getTowerTabName() {
    return TowerTabName;
  }
  /*
   * (non-Javadoc)
   * @see com.tower.service.dao.ibatis.IHelpper#setTowerTabName(java.lang.String)
   */
  
  public void setTowerTabName(String TowerTabName) {
    this.TowerTabName = TowerTabName;
  }
  
  protected List<T> oredCriteria;

  public AbsHelpper() {
    oredCriteria = new ArrayList<T>();
  }

  private String orderByClause;

  /*
   * (non-Javadoc)
   * @see com.tower.service.dao.ibatis.IHelpper#setOrderByClause(java.lang.String)
   */
  
  public void setOrderByClause(String orderByClause) {
    this.orderByClause = orderByClause;
  }

  /*
   * (non-Javadoc)
   * @see com.tower.service.dao.ibatis.IHelpper#getOrderByClause()
   */
  
  public String getOrderByClause() {
    return orderByClause;
  }

  private boolean distinct;

  /*
   * (non-Javadoc)
   * @see com.tower.service.dao.ibatis.IHelpper#setDistinct(boolean)
   */
  
  public void setDistinct(boolean distinct) {
    this.distinct = distinct;
  }

  /*
   * (non-Javadoc)
   * @see com.tower.service.dao.ibatis.IHelpper#isDistinct()
   */
  
  public boolean isDistinct() {
    return distinct;
  }

  /*
   * (non-Javadoc)
   * @see com.tower.service.dao.ibatis.IHelpper#getOredCriteria()
   */
  
  public List<T> getOredCriteria() {
    return oredCriteria;
  }
  
  /*
   * (non-Javadoc)
   * @see com.tower.service.dao.ibatis.IHelpper#or(java.lang.Object)
   */
  public void or(T criteria) {
    oredCriteria.add(criteria);
  }

  /*
   * (non-Javadoc)
   * @see com.tower.service.dao.ibatis.IHelpper#or()
   */
  public T or() {
      T criteria = createCriteriaInternal();
    oredCriteria.add(criteria);
    return criteria;
  }

  /*
   * (non-Javadoc)
   * @see com.tower.service.dao.ibatis.IHelpper#createCriteria()
   */
  public T createCriteria() {
      T criteria = createCriteriaInternal();
    if (oredCriteria.size() == 0) {
      oredCriteria.add(criteria);
    }
    return criteria;
  }

  /*
   * (non-Javadoc)
   * @see com.tower.service.dao.ibatis.IHelpper#clear()
   */
  
  public void clear() {
    oredCriteria.clear();
    orderByClause = null;
    distinct = false;
  }
}
