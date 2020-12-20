package im.spent.util.serial;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties({SnowFlakeProperties.class})
public class SnowFlakeAutoConfiguration {

    @Bean
    @ConditionalOnProperty({"spring.cloud.data-center-id", "spring.cloud.worker-id"})
    public SnowFlakeWorker snowFlakeWorker(SnowFlakeProperties properties) {
        return new SnowFlakeWorker(properties.getDataCenterId(), properties.getWorkerId());
    }
}
