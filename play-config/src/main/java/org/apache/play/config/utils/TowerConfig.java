package org.apache.play.config.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class TowerConfig {
	private static Properties towerConfig=null;
	static{
		towerConfig = loadProperties();
	}
	public synchronized static String getConfig(String key){
        return towerConfig.getProperty(key);
    }
    private static Properties loadProperties(){
    	towerConfig=new Properties();
        try {
        	InputStream is = TowerConfig.class.getResourceAsStream("/META-INF/tower.properties");
        	towerConfig.load(is);
        } catch (IOException e) {
        }
        return towerConfig;
    }
    
    public static void main(String[] args){
    	System.out.println(TowerConfig.getConfig("db.user"));
    }
}
