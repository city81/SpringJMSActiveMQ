package com.city81.jms;

import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.MessageListener;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
 
public class MessageReceiver implements MessageListener {
 
    public void onMessage(final Message message) {
    	
        if (message instanceof MapMessage) {

        	final MapMessage mapMessage = (MapMessage) message;

        	try {
            	System.out.println(mapMessage.getString("Name"));
			} catch (JMSException e) {
				// do something
			}
        }
    }
    
    
	public static void main(String... args) {
		
		ApplicationContext context 
			= new ClassPathXmlApplicationContext("./spring/MessageReceiver.xml");

	}
 
}