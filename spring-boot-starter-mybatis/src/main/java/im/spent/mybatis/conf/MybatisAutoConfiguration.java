package im.spent.mybatis.conf;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tk.mybatis.mapper.autoconfigure.MybatisProperties;

@Configuration
@EnableAutoConfiguration
public class MybatisAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean
    public MybatisProperties mybatisProperties() {
        org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration();
        configuration.setMapUnderscoreToCamelCase(true);

        MybatisProperties properties = new MybatisProperties();
        properties.setConfiguration(configuration);
        return properties;
    }
}
