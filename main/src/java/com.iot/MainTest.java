package com.iot;

import org.junit.Test;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by xiongxiaoyu
 * Data:2018/7/3
 * Time:21:46
 *
 *   https://www.cnblogs.com/leechenxiang/p/5441126.html
 *
 */
public class MainTest {

	@Test
	public void testCluster() throws Exception {
		Set<HostAndPort> nodes = new HashSet<>();
		nodes.add(new HostAndPort("192.168.1.193", 7001));
		nodes.add(new HostAndPort("192.168.1.194", 7002));
		nodes.add(new HostAndPort("192.168.1.195", 7003));
		nodes.add(new HostAndPort("192.168.1.196", 7004));
		nodes.add(new HostAndPort("192.168.1.197", 7005));
		nodes.add(new HostAndPort("192.168.1.198", 7006));
		JedisCluster jedisCluster = new JedisCluster(nodes);
		jedisCluster.set("name", "lee");
		jedisCluster.set("age", "18");
		String name = jedisCluster.get("name");
		String value = jedisCluster.get("age");
		System.out.println(name);
		System.out.println(value);
		jedisCluster.close();
	}
}
