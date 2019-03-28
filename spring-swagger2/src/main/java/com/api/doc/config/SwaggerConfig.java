//package com.winxuan.books.vendor.swagger;
//
//import io.swagger.annotations.Api;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import springfox.documentation.builders.ApiInfoBuilder;
//import springfox.documentation.builders.PathSelectors;
//import springfox.documentation.builders.RequestHandlerSelectors;
//import springfox.documentation.service.ApiInfo;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spring.web.plugins.Docket;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;
//
//@Configuration
//@EnableSwagger2
//public class SwaggerConfig  {
//
//    @Value("${swagger2.enable}")
//    private boolean enable;
//    /**
//     * 创建Docker对象
//     * Docker apiInfo()：用来创建该API的基本信息，展示在文档的页面中（自定义展示的信息）
//     *
//     * ApiSelectorBuilder select()：设置哪些接口暴露给Swagger展示
//     * ApiSelectorBuilder apis()：要展示的API apis()
//     *      RequestHandlerSelectors.any() 任何路径
//     *      RequestHandlerSelectors.basePackage("com.ustcinfo.*")  包位置
//     *      RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class)  类位置
//     * ApiSelectorBuilder paths()：要展示的路径
//     *      PathSelectors.any()：任何路径都可以
//     * Docker build()：创建Docker对象
//     */
//    @Bean
//    public Docket createRestApi() {
//        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select().apis(RequestHandlerSelectors.any()).paths(PathSelectors.any()).build();
//    }
//
//
//    @Bean("用户模块")
//    public Docket userApis() {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .groupName("用户模块")
//                .select()
//                .apis(RequestHandlerSelectors.withClassAnnotation(Api.class))
//                .paths(PathSelectors.regex("/user.*"))
//                .build()
//                .apiInfo(apiInfo())
//                .enable(enable);
//    }
//
//    @Bean("客户模块")
//    public Docket customApis() {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .groupName("客户模块")
//                .select()
//                .apis(RequestHandlerSelectors.withClassAnnotation(Api.class))
//                .paths(PathSelectors.regex("/custom.*"))
//                .build()
//                .apiInfo(apiInfo())
//                .enable(enable);
//    }
//
//    /**
//     * 自定义该API工具展示信息，标题、描述、更新的地址、作者信息、版本等
//     *
//     * ApiInfoBuilder title(String str): 设置标题
//     * ApiInfoBuilder description(String str): 描述
//     * ApiInfoBuilder termsOfServiceUrl(String str): 更新地址
//     * ApiInfoBuilder contact(String str): 作者信息
//     * ApiInfoBuilder version(String str): 版本
//     */
//    private ApiInfo apiInfo() {
//        return new ApiInfoBuilder()
//                .title("XXXXX系统平台接口文档")
//                .description("提供子模块1/子模块2/子模块3的文档, 更多请关注公众号: 随行享阅")
//                .termsOfServiceUrl("https://xingtian.github.io/trace.github.io/")
//                .version("1.0")
//                .build();
//    }
//}
