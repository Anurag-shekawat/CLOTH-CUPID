package com.masai;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SpringFoxCoonfiguration {

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
        .apiInfo(getInfo()).select().apis(RequestHandlerSelectors.any()).paths(PathSelectors.any()).build();
	}

	// private ApiInfo apiDetails() {
	// 	return new ApiInfo("Online Shoping application", "Api for shoping application", "1.0", "Free to use",
	// 			new springfox.documentation.service.Contact(null, null, null), "Github",
	// 			"https://github.com/Anurag-shekawat/main-transport-9463", Collections.emptyList());
	// }
	private ApiInfo getInfo() {
        return new ApiInfo("Cloth Cupid : Online Shopping Application", 
                            "This project is developed by Masai School Students \n"+
                             "Team Name - main-transport-9463 \n"+
                             " Team Members : \n"+
                             " ------------------- \n"+
                             "Anurag Shekhawat \n"+
                             "Vinay Pathania \n"+
                             "Suhaib Malik \n"+
                             "Shubham Singh \n"+
                             "Akash Kumar", 
                            "1.0", "Term of Services", 
                            new springfox.documentation.service.Contact("Team main-transport-9463", "https://github.com/Anurag-shekawat/main-transport-9463", "abc@gmail.com"), 
                            "Lisence of API", 
                            "https://github.com/Anurag-shekawat/main-transport-9463", 
                            Collections.emptyList());
    }

}