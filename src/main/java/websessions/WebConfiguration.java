package websessions;

import org.apache.ignite.cache.websession.WebSessionFilter;
import org.apache.ignite.startup.servlet.ServletContextListenerStartup;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebConfiguration {

    @Bean
    public ServletContextListenerStartup listener() {
        return new ServletContextListenerStartup();
    }

    @Bean
    public FilterRegistrationBean filterRegistrationBean() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new WebSessionFilter());
        registration.addUrlPatterns("/*");

        return registration;
    }

    @Bean
    public ServletContextInitializer initializer() {
        return servletContext -> {
            servletContext.setInitParameter("IgniteConfigurationFilePath", "/home/vpligin/Downloads/websessions/src/main/resources/gridgain-configuration-client.xml");
            servletContext.setInitParameter("IgniteWebSessionsCacheName", "sessioncache");
        };
    }

}
