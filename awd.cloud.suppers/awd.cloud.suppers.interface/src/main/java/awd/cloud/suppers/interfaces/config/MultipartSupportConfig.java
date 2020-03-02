package awd.cloud.suppers.interfaces.config;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.HttpMessageConverters;
import org.springframework.cloud.netflix.feign.support.SpringEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.codec.Encoder;

/**
 * @Description feign文件上传支持
 * @Author WS
 * @Date 2019-07-13 20:51
 */
@Configuration
public class MultipartSupportConfig {
    @Autowired
    private ObjectFactory<HttpMessageConverters> messageConverters;


    @Bean
    public Encoder feignFormEncoder() {
    	return new SpringFormEncoder(new SpringEncoder(messageConverters));
    }
  }
