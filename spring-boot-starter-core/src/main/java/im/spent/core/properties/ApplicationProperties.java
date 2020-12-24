package im.spent.core.properties;

import im.spent.core.constant.ApplicationConstant;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = ApplicationConstant.SPRING_CLOUD_APPLICATION)
public class ApplicationProperties {

    private long dataCenterId;

    private long workerId;

    public long getDataCenterId() {
        return dataCenterId;
    }

    public void setDataCenterId(long dataCenterId) {
        this.dataCenterId = dataCenterId;
    }

    public long getWorkerId() {
        return workerId;
    }

    public void setWorkerId(long workerId) {
        this.workerId = workerId;
    }
}
