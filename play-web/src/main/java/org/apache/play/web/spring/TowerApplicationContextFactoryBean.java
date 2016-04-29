package org.apache.play.web.spring;

import org.apache.play.service.TowerServiceContainer;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TowerApplicationContextFactoryBean implements InitializingBean,
		FactoryBean<ClassPathXmlApplicationContext>, ApplicationContextAware {

	private TowerServiceContainer container = null;

	public TowerApplicationContextFactoryBean(String id,String location) {
		container = new TowerServiceContainer(id,location);
		container.start();
		classPathXmlApplicationContext = container.getContext();
	}
	
	private ApplicationContext applicationContext;
	
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		this.applicationContext = applicationContext;
	}
	private ClassPathXmlApplicationContext classPathXmlApplicationContext;
	
	public ClassPathXmlApplicationContext getObject() throws Exception {
		return classPathXmlApplicationContext;
	}

	
	public Class<?> getObjectType() {
		return ClassPathXmlApplicationContext.class;
	}

	
	public boolean isSingleton() {
		return true;
	}

	
	public void afterPropertiesSet() throws Exception {
		
	}

}
