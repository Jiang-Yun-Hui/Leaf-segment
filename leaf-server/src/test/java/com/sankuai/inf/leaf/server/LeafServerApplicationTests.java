package com.sankuai.inf.leaf.server;

import com.sankuai.inf.leaf.common.Result;
import com.sankuai.inf.leaf.server.utils.IdGenUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@ComponentScan("com.sankuai")
public class LeafServerApplicationTests {

	@Test
	public void contextLoads() {
		for (int i = 0; i < 100; ++i) {
			Result r = IdGenUtil.get("leaf-segment-test");
			System.out.println(r);
		}
	}

}
