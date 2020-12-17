package im.spent.mybatis.conf;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tk.mybatis.mapper.autoconfigure.MybatisProperties;

@Configuration
public class MybatisAutoConfiguration {

    private static final Logger logger = LoggerFactory.getLogger(MybatisAutoConfiguration.class);

    @Bean("mybatis-tk.mybatis.mapper.autoconfigure.MybatisProperties")
    public MybatisProperties mybatisProperties() {
        logger.info("Auto Configure MyBatis Properties");
        org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration();
        configuration.setMapUnderscoreToCamelCase(true);

        MybatisProperties properties = new MybatisProperties();
        properties.setConfiguration(configuration);
        return properties;
    }
}
