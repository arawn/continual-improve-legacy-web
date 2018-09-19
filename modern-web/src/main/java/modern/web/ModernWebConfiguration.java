package modern.web;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.autoconfigure.web.ResourceProperties;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.netflix.zuul.web.ZuulHandlerMapping;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableZuulProxy
public class ModernWebConfiguration extends WebMvcConfigurerAdapter {

    private ResourceProperties resourceProperties;
    public ModernWebConfiguration(ResourceProperties resourceProperties) {
        this.resourceProperties = resourceProperties;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/assets/**")
                .addResourceLocations("classpath:assets/")
                .setCachePeriod(resourceProperties.getCachePeriod());
        registry.setOrder(500);
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/order.jsp").setViewName("index");
    }


    @Configuration
    static class ZuulHandlerMappingConfiguration implements InitializingBean {

        private ZuulHandlerMapping zuulHandlerMapping;
        public ZuulHandlerMappingConfiguration(ZuulHandlerMapping zuulHandlerMapping) {
            this.zuulHandlerMapping = zuulHandlerMapping;
        }

        @Override
        public void afterPropertiesSet() throws Exception {
            zuulHandlerMapping.setOrder(1000);
        }

    }

}
