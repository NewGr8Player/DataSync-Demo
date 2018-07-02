package com.xavier;

import com.xavier.starter.canal.annotation.EnableCanalClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * <p>
 * Canal日志分析定制处理解决方案
 * <ul>
 * <li>集成Durid连接池</li>
 * <li>集成CanalClientStarter</li>
 * <li>集成Hibernate进行数据持久化</li>
 * <li>使用ConcurrentMap作为代码级缓存，确保线程级数据安全</li>
 * </ul>
 * TODO-List
 * <ol>
 * <li>使用可配置方式进行数据汇总</li>
 * </ol>
 * </p>
 *
 * @author NewGr8Player
 */
@EnableCaching
@EnableCanalClient
@SpringBootApplication
public class CanalApplication {

	public static void main(String[] args) {
		SpringApplication.run(CanalApplication.class, args);
	}
}
