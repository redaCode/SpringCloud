package com.reda;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = RabbitServerApplication.class)
public class RabbitServerApplicationTests {

//	@Autowired
//	private Sender sender;

	@Autowired
	private DirectMsgSender directSender;

	@Autowired
	private TopicLogSender topicLogSender;

	@Test
	public void send() {
//		sender.send();
		//direct
//		directSender.send();

		topicLogSender.send();
	}
}
