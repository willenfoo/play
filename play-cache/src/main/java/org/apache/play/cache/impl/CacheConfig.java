package org.apache.play.cache.impl;

import javax.annotation.PostConstruct;

import org.apache.play.config.DynamicConfig;
import org.apache.play.config.dict.ConfigComponent;
import org.apache.play.config.dict.ConfigFileDict;
import org.apache.play.config.dict.ConfigFileTypeDict;
import org.springframework.stereotype.Component;

@Component(ConfigComponent.CacheConfig)
public class CacheConfig extends DynamicConfig{
    public CacheConfig(){
    }
    
    @PostConstruct
    public void init(){
        setFileName(System.getProperty(ConfigFileDict.CACHE_CONFIG_FILE,
            ConfigFileDict.DEFAULT_CACHE_CONFIG_NAME));
        this.setType(ConfigFileTypeDict.XML);
        super.init();
    }
}
