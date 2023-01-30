package kg.megacom.Recommendation.system.Recommendation.system.swaggerconfig;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Arrays;
import java.util.List;


@Configuration
@EnableSwagger2
public class Swagger2Config {
    public static final String Auth="Регистрация/Вход";
    public static final String Album="Альбом";

    public static final String Author="Автор";
    public static final String Favorites="Избранные";
    public static final String Genre="Жанр";

    public static final String Music="Музыкак";
    public static final String MusicAuthor="Автор музыки";
    public static final String MusicGenre="Жанр музыки";
    public static final String Popular="Популярные";
    public static final String Role="Роль";
    public static final String UserEntity="Пользователь";
    public static final String UserFavorites="Получить рекомендацию";

    private ApiKey apiKey() {
        return new ApiKey("JWT", "Authorization", "header");
    }

    private SecurityContext securityContext() {
        return SecurityContext.builder().securityReferences(defaultAuth()).build();
    }
    private List<SecurityReference> defaultAuth() {
        AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        return Arrays.asList(new SecurityReference("JWT", authorizationScopes));
    }

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiEndPointsInfo())
                .securityContexts(Arrays.asList(securityContext()))
                .securitySchemes(Arrays.asList(apiKey()))
                .select()
                .apis(RequestHandlerSelectors
                        .basePackage("kg.megacom.Recommendation.system.Recommendation.system.controller"))
                .paths(PathSelectors.any())
                .build().apiInfo(apiEndPointsInfo())
                .tags(new Tag(Album, ""))
                .tags(new Tag(Author,""))
                .tags(new Tag(Favorites,""))
                .tags(new Tag(Genre,""))
                .tags(new Tag(Music,""))
                .tags(new Tag(MusicAuthor,""))
                .tags(new Tag(MusicGenre,""))
                .tags(new Tag(Popular,""))
                .tags(new Tag(Role,""))
                .tags(new Tag(UserEntity,""))
                .tags(new Tag(Auth,""))
                .tags(new Tag(UserFavorites,""));

    }

    private ApiInfo apiEndPointsInfo() {
        return new ApiInfoBuilder().title("Recommendation system")
                .description("empty")
                .version("1.0.0")
                .build();
    }


}
