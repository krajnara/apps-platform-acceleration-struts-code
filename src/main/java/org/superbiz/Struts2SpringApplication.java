package org.superbiz;

import com.opensymphony.module.sitemesh.filter.PageFilter;
import org.apache.struts2.dispatcher.ActionContextCleanUp;
import org.apache.struts2.dispatcher.FilterDispatcher;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import javax.servlet.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by 103209 on 14/09/17.
 */
@SpringBootApplication
public class Struts2SpringApplication {
    public static void main(String[] args) {
        SpringApplication.run(Struts2SpringApplication.class, args);
    }

    @Bean
    public FilterRegistrationBean struts2() {
        FilterRegistrationBean bean = new FilterRegistrationBean();
        bean.setFilter(new FilterDispatcher());
        bean.setName("struts2");
        Map<String, String> map = new HashMap<String, String>();
        map.put("actionPackages", "com.lq");
        bean.setInitParameters(map);
        bean.setOrder(1);

        return bean;
    }

    @Bean
    public FilterRegistrationBean strutsCleanup() {
        FilterRegistrationBean bean = new FilterRegistrationBean();
        bean.setFilter(new ActionContextCleanUp());
        bean.setName("struts-cleanup");
        bean.setOrder(2);

        return bean;
    }

    @Bean
    public FilterRegistrationBean sitemesh() {
        FilterRegistrationBean bean = new FilterRegistrationBean();
        bean.setFilter(new PageFilter());
        bean.setName("sitemesh");
        bean.setOrder(3);

        return bean;
    }

}
