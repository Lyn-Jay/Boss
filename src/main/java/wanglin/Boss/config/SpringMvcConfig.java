//package wanglin.Boss.config;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//import wanglin.Boss.interceptor.LogInterceptor;
//
//import javax.annotation.Resource;
//
//@Configuration
//public class SpringMvcConfig implements WebMvcConfigurer {
//    @Resource
//    LogInterceptor logInterceptor;
//
//    public void addInterceptors(InterceptorRegistry registry){
//        registry.addInterceptor(logInterceptor).addPathPatterns("/**").excludePathPatterns("/login");
//    }
//
//}
