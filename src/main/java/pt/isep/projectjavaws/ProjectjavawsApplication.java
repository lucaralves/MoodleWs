package pt.isep.projectjavaws;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class ProjectjavawsApplication extends SpringBootServletInitializer {

    /*public static void main(String[] args) {
        SpringApplication.run(ProjectjavawsApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder applicationBuilder) {
        return applicationBuilder.sources(ProjectjavawsApplication.class);
    }*/

    public static void main(String[] args) {
        new SpringApplicationBuilder(ProjectjavawsApplication.class)
                .web(WebApplicationType.NONE) // .REACTIVE, .SERVLET
                .run(args);
    }
}
