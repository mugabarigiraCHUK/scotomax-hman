package org.hman.amqp;

import com.rabbitmq.client.QueueingConsumer;

public interface AmqpReceiver {

	String handleMessage(QueueingConsumer.Delivery delivery);

}
