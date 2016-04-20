package org.apache.play.dao.ibatis;

import javax.annotation.PostConstruct;

import org.apache.play.config.DynamicConfig;
import org.apache.play.config.dict.ConfigComponent;
import org.apache.play.config.dict.ConfigFileDict;
import org.springframework.stereotype.Component;

@Component(ConfigComponent.AccConfig)
public class AccConfig extends DynamicConfig {

  public AccConfig() {
  }

  @PostConstruct
  public void init(){
      setFileName(System.getProperty(ConfigFileDict.ACCESS_CONTROL_CONFIG_FILE,
          ConfigFileDict.DEFAULT_ACCESS_CONTROL_CONFIG_NAME));
      super.init();
  }

}
