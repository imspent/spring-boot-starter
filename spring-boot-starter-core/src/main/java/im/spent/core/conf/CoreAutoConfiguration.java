package im.spent.core.conf;

import im.spent.core.handler.GlobalExceptionHandler;
import im.spent.core.properties.ApplicationProperties;
import im.spent.core.serial.SnowFlakeWorker;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties({ApplicationProperties.class})
public class CoreAutoConfiguration {

    @Bean
    public GlobalExceptionHandler globalExceptionHandler() {
        return new GlobalExceptionHandler();
    }

    @Bean
    @ConditionalOnBean(ApplicationProperties.class)
    public SnowFlakeWorker snowFlakeWorker(ApplicationProperties properties) {
        return new SnowFlakeWorker(properties.getDataCenterId(), properties.getWorkerId());
    }
}
