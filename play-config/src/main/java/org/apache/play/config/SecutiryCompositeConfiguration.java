package org.apache.play.config;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import org.apache.commons.configuration.CompositeConfiguration;
import org.apache.commons.configuration.Configuration;
import org.apache.play.log.Logger;
import org.apache.play.log.LoggerFactory;
import org.apache.play.util.DesUtils;

public class SecutiryCompositeConfiguration  extends CompositeConfiguration implements Configuration{
	protected Logger logger = LoggerFactory.getLogger(getClass());
	/**
     * 加密／解密工具
     */
    private DesUtils utils = new DesUtils("national");
    
    private boolean isEncryptPropertyVal(String propertyName){
        if(propertyName.toLowerCase().endsWith(".encrypted")){
            return true;
        }else{
            return false;
        }
    }
    
	
	public Configuration subset(String prefix) {
		return super.subset(prefix);
	}

	
	public boolean isEmpty() {
		return super.isEmpty();
	}

	
	public boolean containsKey(String key) {
		return super.containsKey(key);
	}

	
	public void addProperty(String key, Object value) {
		super.addProperty(key, value);
	}

	
	public void setProperty(String key, Object value) {
		super.setProperty(key, value);
	}

	
	public void clearProperty(String key) {
		super.clearProperty(key);
	}

	
	public void clear() {
		super.clear();
	}

	
	public Object getProperty(String key) {
		return super.getProperty(key);
	}

	
	public Iterator getKeys(String prefix) {
		return super.getKeys(prefix);
	}

	
	public Iterator getKeys() {
		return super.getKeys();
	}

	
	public Properties getProperties(String key) {
		return super.getProperties(key);
	}

	
	public boolean getBoolean(String key) {
		return super.getBoolean(key);
	}

	
	public boolean getBoolean(String key, boolean defaultValue) {
		return super.getBoolean(key);
	}

	
	public Boolean getBoolean(String key, Boolean defaultValue) {
		return super.getBoolean(key, defaultValue);
	}

	
	public byte getByte(String key) {
		return super.getByte(key);
	}

	
	public byte getByte(String key, byte defaultValue) {
		return super.getByte(key,defaultValue);
	}

	
	public Byte getByte(String key, Byte defaultValue) {
		return super.getByte(key, defaultValue);
	}

	
	public double getDouble(String key) {
		return super.getDouble(key);
	}

	
	public double getDouble(String key, double defaultValue) {
		return super.getDouble(key,defaultValue);
	}

	
	public Double getDouble(String key, Double defaultValue) {
		return super.getDouble(key, defaultValue);
	}

	
	public float getFloat(String key) {
		return super.getFloat(key);
	}

	
	public float getFloat(String key, float defaultValue) {
		return super.getFloat(key,defaultValue);
	}

	
	public Float getFloat(String key, Float defaultValue) {
		return super.getFloat(key, defaultValue);
	}

	
	public int getInt(String key) {
		return super.getInt(key);
	}

	
	public int getInt(String key, int defaultValue) {
		return super.getInt(key, defaultValue);
	}

	
	public Integer getInteger(String key, Integer defaultValue) {
		return super.getInteger(key, defaultValue);
	}

	
	public long getLong(String key) {
		return super.getLong(key);
	}

	
	public long getLong(String key, long defaultValue) {
		return super.getLong(key, defaultValue);
	}

	
	public Long getLong(String key, Long defaultValue) {
		return super.getLong(key, defaultValue);
	}

	
	public short getShort(String key) {
		return super.getShort(key);
	}

	
	public short getShort(String key, short defaultValue) {
		return super.getShort(key, defaultValue);
	}

	
	public Short getShort(String key, Short defaultValue) {
		return super.getShort(key, defaultValue);
	}

	
	public BigDecimal getBigDecimal(String key) {
		return super.getBigDecimal(key);
	}

	
	public BigDecimal getBigDecimal(String key, BigDecimal defaultValue) {
		return super.getBigDecimal(key,defaultValue);
	}

	
	public BigInteger getBigInteger(String key) {
		return super.getBigInteger(key);
	}

	
	public BigInteger getBigInteger(String key, BigInteger defaultValue) {
		return super.getBigInteger(key, defaultValue);
	}

	/**
     * 支持加密机制
     */
    public String getString(String key) {
    	String value = super.getString(key);
    	if(value!=null && isEncryptPropertyVal(key)){
    		try {
				value = utils.decrypt(value.toString());
				logger.error("{} 解密成功",key);
			} catch (Exception e) {
				logger.error("{}={}解密失败",key,value);
			}
    	}
        return value;
    }
    /**
     * 支持加密机制
     */
    public String getString(String key, String defaultValue) {
    	String value = super.getString(key,defaultValue);
    	if(value!=null && isEncryptPropertyVal(key)){
    		try {
				value = utils.decrypt(value.toString());
				logger.error("{} 解密成功",key);
			} catch (Exception e) {
				logger.error("{}={}解密失败",key,value);
			}
    	}
        return value;
    }

	
	public String[] getStringArray(String key) {
		return super.getStringArray(key);
	}

	
	public List getList(String key) {
		return super.getList(key);
	}

	
	public List getList(String key, List defaultValue) {
		return super.getList(key, defaultValue);
	}

}
