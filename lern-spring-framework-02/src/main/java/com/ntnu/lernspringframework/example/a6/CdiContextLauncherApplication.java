package com.ntnu.lernspringframework.example.a6;

import jakarta.inject.Inject;
import jakarta.inject.Named;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

//@Component
@Named
class BusinessService{
    private DataService dataService;
    //@Autowired
    @Inject
    public void setDataService(DataService dataService) {
        System.out.println("Setter injection");
        this.dataService = dataService;
    }

    public DataService getDataService() {
        return dataService;
    }
}
//@Component
@Named
class DataService{

}
@Configuration
@ComponentScan
public class CdiContextLauncherApplication {
    public static void main(String[] args) {
        try(AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(CdiContextLauncherApplication.class)){
            System.out.println(context.getBean(BusinessService.class).getDataService());
        }

    }
}
