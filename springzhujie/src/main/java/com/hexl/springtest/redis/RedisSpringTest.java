package com.hexl.springtest.redis;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

public class RedisSpringTest {
	
	public static void main(String[] args) {
		try {
			ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
			context.start();
			
			ShardedJedisPool pool = (ShardedJedisPool) context.getBean("shardedJedisPool");
			ShardedJedis jedis = pool.getResource();
			
			String key = "pyt";
			String value = "";
			
			jedis.del(key); // 删数据
			
			jedis.set(key, "www.puyitou"); // 存数据
			value = jedis.get(key); // 取数据
			System.out.println(key + "=" + value);
			
			jedis.set(key, "m.puyitou.com"); // 存数据
			value = jedis.get(key); // 取数据
			System.out.println(key + "=" + value);
			
			jedis.del(key); // 删数据
			value = jedis.get(key); // 取数据
			System.out.println(key + "=" + value);

			context.stop();
		} catch (Exception e) {
			System.out.println("==>RedisSpringTest context start error:"+e);
			System.exit(0);
		} finally {
			System.out.println("===>System.exit");
			System.exit(0);
		}
	}
}
