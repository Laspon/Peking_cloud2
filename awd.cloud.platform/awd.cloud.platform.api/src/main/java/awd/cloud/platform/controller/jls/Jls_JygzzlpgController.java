/*
 * Copyright 2008 [rapid-framework], Inc. All rights reserved.
 * Website: http://www.rapid-framework.org.cn
 */

package awd.cloud.platform.controller.jls;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

@RestController
@RefreshScope
@RequestMapping("/v4/jls/jygzzlpg")
@Api(tags = "kss-jygzzlpg",description = "Jygzzlpg") 
public class Jls_JygzzlpgController {
}
