package awd.cloud.platform.api;


import org.springframework.cloud.netflix.feign.FeignClient;

import awd.cloud.platform.api.hystrix.SjsFallBackFactory;


@FeignClient(name = "${awd.api:AWD-MIS-GATEWAY-SERVER}", fallbackFactory = SjsFallBackFactory.class)

public interface SjsService {


}
