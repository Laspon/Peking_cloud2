/*
 *
 *  * Licensed to the Apache Software Foundation (ASF) under one or more
 *  * contributor license agreements.  See the NOTICE file distributed with
 *  * this work for additional information regarding copyright ownership.
 *  * The ASF licenses this file to You under the Apache License, Version 2.0
 *  * (the "License"); you may not use this file except in compliance with
 *  * the License.  You may obtain a copy of the License at
 *  *
 *  *     http://www.apache.org/licenses/LICENSE-2.0
 *  *
 *  * Unless required by applicable law or agreed to in writing, software
 *  * distributed under the License is distributed on an "AS IS" BASIS,
 *  * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  * See the License for the specific language governing permissions and
 *  * limitations under the License.
 *
 */

package awd.mis.servers.config;

import org.dromara.raincat.common.config.TxConfig;
import org.dromara.raincat.core.bootstrap.TxTransactionBootstrap;
import org.dromara.raincat.core.bootstrap.TxTransactionInitialize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import awd.framework.common.utils.JSONUtil;

/**
 * RaincatAutoConfiguration is spring boot starter handler.
 *
 * @author xiaoyu(Myth)
 */
@Configuration
@EnableAspectJAutoProxy(proxyTargetClass = true)
@EnableConfigurationProperties
@ComponentScan(basePackages = {"org.dromara.raincat.*"})
public class RaincatAutoConfiguration {


    private final TxConfigProperties txConfigProperties;

    @Autowired
    public RaincatAutoConfiguration(TxConfigProperties txConfigProperties) {
        this.txConfigProperties = txConfigProperties;        
    }

    /**
     * init TxTransactionBootstrap.
     *
     * @param txTransactionInitialize {@linkplain TxTransactionInitialize}
     * @return TxTransactionBootstrap
     */
    @Bean
    public TxTransactionBootstrap tccTransactionBootstrap(final TxTransactionInitialize txTransactionInitialize) {
        final TxTransactionBootstrap bootstrap = new TxTransactionBootstrap(txTransactionInitialize);
        bootstrap.builder(builder());
        return bootstrap;
    }

    /**
     * init bean of TxConfig.
     *
     * @return {@linkplain TxConfig}
     */
    @Bean
    public TxConfig txConfig() {
    	System.err.println(builder().build());
        return builder().build();
    }

    private TxConfig.Builder builder() {
        return TxTransactionBootstrap.create()
                .setSerializer(txConfigProperties.getSerializer())
                .setNettySerializer(txConfigProperties.getNettySerializer())
                .setNettyThreadMax(txConfigProperties.getNettyThreadMax())
                .setDelayTime(txConfigProperties.getDelayTime())
                .setHeartTime(txConfigProperties.getHeartTime())
                .setTxManagerUrl(txConfigProperties.getTxManagerUrl())
                .setRefreshInterval(txConfigProperties.getRefreshInterval())
                .setRepositorySuffix(txConfigProperties.getRepositorySuffix())
                .setCompensationCacheType(txConfigProperties.getCompensationCacheType())
                .setCompensation(txConfigProperties.getCompensation())
                .setBufferSize(txConfigProperties.getBufferSize())
                .setRetryMax(txConfigProperties.getRetryMax())
                .setRecoverDelayTime(txConfigProperties.getRecoverDelayTime())
                .setTxDbConfig(txConfigProperties.getTxDbConfig())
                .setTxFileConfig(txConfigProperties.getTxFileConfig())
                .setTxMongoConfig(txConfigProperties.getTxMongoConfig())
                .setTxRedisConfig(txConfigProperties.getTxRedisConfig())
                .setTxZookeeperConfig(txConfigProperties.getTxZookeeperConfig());
    }
}
