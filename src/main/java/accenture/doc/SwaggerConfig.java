package accenture.doc;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket apiDoc() {
		ParameterBuilder paramBuilder = new ParameterBuilder();
		List<Parameter> params = new ArrayList<>();
			paramBuilder.name("Authorization")
			.description("Bearer token")
			.modelRef(new ModelRef("string"))
			.parameterType("header")
			.build();
		
		params.add(paramBuilder.build());
		
		return new Docket(DocumentationType.SWAGGER_2)
				.globalOperationParameters(params)
				.select()
				.apis(RequestHandlerSelectors.basePackage("accenture.controller"))
				.paths(PathSelectors.any())
				.build()
				.apiInfo(metaData());
				
	}
	
	private ApiInfo metaData() {
		return new ApiInfoBuilder()
				.title("Projeto BankLine")
				.description("API Bancaria - Grupo OaK")
				.version("1.0")
				.contact(new Contact("OaK Team", "https://github.com/Wallacy-Neres/Projeto-Accenture", ""))
				.license("Licença - OaK Team")
				.licenseUrl("https://github.com/Wallacy-Neres/Projeto-Accenture")
				.build();
	}
}
