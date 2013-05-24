package com.city81.jms;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;
 
public class MessageSender {
 
    private final JmsTemplate jmsTemplate;
 
    public MessageSender(final JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }
 
    public void send(final Map map) {
        jmsTemplate.convertAndSend(map);
    }
 
    public static void main (String... args) {
    	
		ApplicationContext context 
			= new ClassPathXmlApplicationContext("./spring/MessageSender.xml");
		MessageSender testMessageSender = (MessageSender) context.getBean("messageSender");
		
		Map map = new HashMap();
		map.put("Name", "MYNAME");		
		testMessageSender.send(map);
		System.out.println("Sent MYNAME MapMessage");
		System.exit(1);
		
    }
    
}
