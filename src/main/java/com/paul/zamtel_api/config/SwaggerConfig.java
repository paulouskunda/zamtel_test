package com.paul.zamtel_api.config;

import com.google.common.base.Predicate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import java.util.ArrayList;
import java.util.List;

import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
@EnableSwagger2
public class SwaggerConfig {


    @Bean
    public Docket postsApi(){
        ParameterBuilder ticketPar = new ParameterBuilder();
        List<Parameter> pars = new ArrayList<Parameter>();
        ticketPar.name ("Authorization"). description ("Authorization token")
                .modelRef(new ModelRef("string")).parameterType("header")
                .required (false) .build (); // The ticket parameter in the header is not required, you can pass it empty
        pars.add (ticketPar.build ()); // According to each method name, I also know what parameters the current method is setting

        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .build()
                .globalOperationParameters(pars)
                .apiInfo(metaData());
    }

    private Predicate<String> postPaths() {
        return (regex("/.*"));
    }

    private ApiInfo metaData() {
        ApiInfo apiInfo = new ApiInfo(
                "ZAMTEL BACKEND API",
                "API Documentation for ZAMTEL",
                "1.0",
                "",
                new Contact("Paul Kunda", "https://github.com/paulouskunda", "pkunda24@sgmail.com"),
                "-",
                "-");
        return apiInfo;
    }

}

