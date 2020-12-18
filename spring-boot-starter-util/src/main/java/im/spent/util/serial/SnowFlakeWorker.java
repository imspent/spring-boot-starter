package im.spent.util.serial;

/**
 * 雪花算法
 * 64 位二进制
 * 0      ->  固定为 0 不用
 * 1~41   ->  41 位时间戳
 * 42~51  ->  10 位工作机器编号
 * 52~63  ->  12 位序列号
 */
public class SnowFlakeWorker {

    /**
     * 开始时间截 (2020-01-01)
     */
    private final long startTimestamp = 1577808000000L;

    /**
     * 机器 id 所占的位数
     */
    private final long workerIdBits = 5L;

    /**
     * 数据标识 id 所占的位数
     */
    private final long dataCenterIdBits = 5L;

    /**
     * 支持的最大机器 id 31
     */
    private final long maxWorkerId = ~(-1L << workerIdBits);

    /**
     * 支持的最大数据标识 id 31
     */
    private final long maxDataCenterId = ~(-1L << dataCenterIdBits);

    /**
     * 序列在 id 中占的位数
     */
    private final long sequenceBits = 12L;

    /**
     * 机器 id 向左移 12 位
     */
    private final long workerIdShift = sequenceBits;

    /**
     * 数据标识 id 向左移 17(12+5) 位
     */
    private final long dataCenterIdShift = sequenceBits + workerIdBits;

    /**
     * 时间截向左移 22(12+5+5) 位
     */
    private final long timestampLeftShift = sequenceBits + workerIdBits + dataCenterIdBits;

    /**
     * 生成序列的掩码 (0b111111111111=0xfff=4095)
     */
    private final long sequenceMask = ~(-1L << sequenceBits);

    /**
     * 工作机器 id (0~31)
     */
    private long workerId;

    /**
     * 数据中心 id (0~31)
     */
    private long dataCenterId;

    /**
     * 毫秒内序列 (0~4095)
     */
    private long sequence = 0L;

    /**
     * 上次生成 id 的时间截
     */
    private long lastTimestamp = -1L;

    public SnowFlakeWorker(long workerId, long dataCenterId) {
        if (workerId > maxWorkerId || workerId < 0) {
            throw new IllegalArgumentException(String.format("worker Id can't be greater than %d or less than 0", maxWorkerId));
        }
        if (dataCenterId > maxDataCenterId || dataCenterId < 0) {
            throw new IllegalArgumentException(String.format("datacenter Id can't be greater than %d or less than 0", maxDataCenterId));
        }
        this.workerId = workerId;
        this.dataCenterId = dataCenterId;
    }

    public synchronized long nextId() {
        long timestamp = System.currentTimeMillis();

        if (timestamp < lastTimestamp) {
            throw new RuntimeException("时钟回退，序列号生成失败");
        }

        if (lastTimestamp == timestamp) {
            sequence = (sequence + 1) & sequenceMask;
            if (sequence == 0) {
                // 阻塞到下一个毫秒, 获得新的时间戳
                timestamp = tilNextMillis(lastTimestamp);
            }
        } else {
            sequence = 0;
        }

        lastTimestamp = timestamp;

        return ((timestamp - startTimestamp) << timestampLeftShift)
                | (dataCenterId << dataCenterIdShift)
                | (workerId << workerIdShift)
                | sequence;
    }

    /**
     * 阻塞到下一个毫秒, 直到获得新的时间戳
     * @param lastTimestamp 上次生成ID的时间截
     * @return 当前时间戳
     */
    protected long tilNextMillis(long lastTimestamp) {
        long timestamp = System.currentTimeMillis();
        while (timestamp <= lastTimestamp) {
            timestamp = System.currentTimeMillis();
        }
        return timestamp;
    }
}
