package org.apache.play.service.impl;

import javax.annotation.PostConstruct;

import org.apache.play.config.DynamicConfig;
import org.apache.play.config.dict.ConfigComponent;
import org.apache.play.config.dict.ConfigFileDict;
import org.apache.play.config.dict.ConfigFileTypeDict;
import org.springframework.stereotype.Component;

@Component(ConfigComponent.ServiceConfig)
public class ServiceConfig extends DynamicConfig {
    
    public ServiceConfig() {}

    @PostConstruct
    public void init() {
        this.setFileName(System.getProperty(ConfigFileDict.SERVICE_CONFIG_FILE,
                ConfigFileDict.DEFAULT_SERVICE_CONFIG_NAME));
        this.setType(ConfigFileTypeDict.XML);
        super.init();
    }
}
