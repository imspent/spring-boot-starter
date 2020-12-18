package im.spent.util.serial;

import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(SnowFlakeProperties.class)
public class SnowFlakeAutoConfiguration {

    @Bean
    @ConditionalOnBean(SnowFlakeProperties.class)
    public SnowFlakeWorker snowFlakeWorker(SnowFlakeProperties properties) {
        return new SnowFlakeWorker(properties.getDataCenterId(), properties.getWorkerId());
    }
}
