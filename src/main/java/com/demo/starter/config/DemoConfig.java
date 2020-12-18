package com.demo.starter.config;

import com.demo.starter.properties.Demo1Properties;
import com.demo.starter.properties.DemoProperties;
import com.demo.starter.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
@EnableConfigurationProperties({Demo1Properties.class, DemoProperties.class})
@ConditionalOnProperty(
        prefix = "demo",
        name = "isopen",
        havingValue = "true"
)
public class DemoConfig {
    @Autowired
    private Demo1Properties demo1Properties;
    @Autowired
    private DemoProperties demoProperties;

    @Bean(name = "demo")
    public DemoService demoService(){
        return new DemoService(demoProperties.getSayWhat(), demoProperties.getToWho());
    }
    @Bean(name = "demo1")
    public DemoService  demo1Service(){
        //时所发生的发
        return new DemoService(demo1Properties.getSayWhat(), demo1Properties.getToWho());
    }
}
