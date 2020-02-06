package com.example.ssm.configure;

import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
public class Swagger2Configuration {

    @Bean("docket")
    public Docket createDocket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.ssm.controller"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        Contact contact = new Contact("calvinit", "https://gitee.com/calvinit/ssm-demo", "");
        return new ApiInfoBuilder()
                .title("SSM框架搭建Demo")
                .description("SSM框架搭建Demo，仅供猿友们学习交流之用，请勿用于商业用途")
                .contact(contact)
                .version("1.0-RELEASE")
                .build();
    }
}
