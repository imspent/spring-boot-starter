package im.spent.core.conf;

import im.spent.core.constant.ApplicationConstant;
import im.spent.core.handler.GlobalExceptionHandler;
import im.spent.core.properties.ApplicationProperties;
import im.spent.core.serial.SnowFlakeWorker;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties({ApplicationProperties.class})
public class CoreAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean
    public GlobalExceptionHandler globalExceptionHandler() {
        return new GlobalExceptionHandler();
    }

    @Bean
    @ConditionalOnMissingBean
    @ConditionalOnProperty({
            ApplicationConstant.SPRING_CLOUD_APPLICATION_DATA_CENTER_ID,
            ApplicationConstant.SPRING_CLOUD_APPLICATION_WORKER_ID})
    public SnowFlakeWorker snowFlakeWorker(ApplicationProperties properties) {
        return new SnowFlakeWorker(properties.getDataCenterId(), properties.getWorkerId());
    }
}
