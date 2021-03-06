package awd.mis.appstore.config;

import feign.RequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Feign配置注册（全局）
 **/
@Configuration
public class FeignSupportConfig {
  /**
   * feign请求拦截器
   *
   * @return
   */
  @Bean
  public RequestInterceptor requestInterceptor(){
    return new FeignBasicAuthRequestInterceptor();
  }
}
