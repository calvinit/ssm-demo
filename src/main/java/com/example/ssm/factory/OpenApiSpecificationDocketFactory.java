package com.example.ssm.factory;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Set;

@EnableOpenApi
public class OpenApiSpecificationDocketFactory {

    public Docket createDocket() {
        Contact contact = new Contact("calvinit", "https://gitee.com/calvinit/ssm-demo", "");
        ApiInfo apiInfo = new ApiInfoBuilder()
                .title("SSM框架搭建Demo")
                .description("SSM框架搭建Demo，仅供猿友们学习交流之用，请勿用于商业用途")
                .contact(contact)
                .version("1.0-RELEASE")
                .build();
        return new Docket(DocumentationType.OAS_30)
                .enable(true)
                .pathMapping("/")
                .apiInfo(apiInfo)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.ssm.controller"))
                .paths(PathSelectors.any())
                .build()
                .protocols(Set.of("http", "https"));
    }
}