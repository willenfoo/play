package org.apache.play.config;

public interface IConfiguration {
    
    String getString(String key);

    Object getProperty(String key);
}
