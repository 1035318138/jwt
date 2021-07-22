package com.jwt;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Parameter;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Can.Ru
 */
@EnableSwagger2
@SpringBootApplication
@EnableAutoConfiguration
public class JWTApplication {

    public static void main(String[] args) {
        SpringApplication.run(JWTApplication.class, args);
    }

    @Bean
    public Docket createRestApi(){
        ApiInfo DEFAULT = new ApiInfo("Api jwt test", "Api jwt test", "1.0", "urn:tos",
                new Contact("xxx", "x:8080", "x@email.com"), "Apache 2.0", "http://www.apache.org/licenses/LICENSE-2.0", new ArrayList<VendorExtension>());
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(DEFAULT)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.jwt.controller"))
                .paths(PathSelectors.any()).build()
                .globalOperationParameters(setHeaderToken());
    }


    private List<Parameter> setHeaderToken() {
        ParameterBuilder tokenPar = new ParameterBuilder();
        List<Parameter> pars = new ArrayList<>();
        tokenPar.name("token").description("token").modelRef(new ModelRef("string")).parameterType("header").required(false).build();
        pars.add(tokenPar.build());
        return pars;
    }

}
