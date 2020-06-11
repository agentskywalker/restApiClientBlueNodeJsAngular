package com.agentskywalker.office.employeemanagement.apiclient.controller;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/*https://stackoverflow.com/questions/27170772/where-to-put-static-files-such-as-css-in-a-spring-boot-project
Just make sure you haven't used @EnableWebMvc in your application as that will disable Spring Boot's auto-configuration of Spring MVC.*/
/*@Controller
@EnableAutoConfiguration
@EnableWebMvc*/

@Configuration
@ComponentScan
public class MvcConfiguration implements WebMvcConfigurer {

   /*@Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
    }*/

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry){
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();


        resolver.setViewClass(JstlView.class);
        resolver.setPrefix("/WEB-INF/view/");
        resolver.setSuffix(".jsp");
        resolver.setViewClass(JstlView.class);
        registry.viewResolver(resolver);
    }

}
