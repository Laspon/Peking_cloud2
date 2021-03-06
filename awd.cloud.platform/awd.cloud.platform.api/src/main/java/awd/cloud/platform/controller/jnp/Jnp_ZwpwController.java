package awd.cloud.platform.controller.jnp;

import awd.cloud.platform.api.KssService;
import awd.cloud.platform.utils.ResponseMessage;
import awd.framework.common.utils.OpenAPI;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
@RefreshScope
@RequestMapping("/jwp/zwpw")
@Api(tags = "jnp-zwpw",description = "zwpw")
public class Jnp_ZwpwController {

    @Autowired
    private KssService kssService;


    @OpenAPI
    @ApiOperation("分页查询")
    @GetMapping("/zwpwQuery")
    @HystrixCommand
    @ApiResponses({@ApiResponse(code = 200, message = "查询成功"), @ApiResponse(code = 401, message = "未授权"),
            @ApiResponse(code = 403, message = "无权限"), @ApiResponse(code = 404, message = "数据不存在")})
    public ResponseMessage<Map<String, Object>> zwpw_query(HttpServletRequest request, String json) {
        return null;
    }

}
