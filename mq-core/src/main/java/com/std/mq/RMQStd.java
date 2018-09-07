package com.std.mq;

import org.apache.rocketmq.client.consumer.DefaultMQPullConsumer;
import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.MessageQueueSelector;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageQueue;
import org.apache.rocketmq.remoting.exception.RemotingException;

import java.util.List;

/**
 * Created by Administrator on 2018/7/22.
 */
public class RMQStd {

    public static void main(String[] args) throws MQClientException, RemotingException, InterruptedException, MQBrokerException {

        DefaultMQProducer producer = new DefaultMQProducer("my-group");
        producer.setNamesrvAddr("111.231.62.191:9876");
        producer.setRetryTimesWhenSendFailed(3);

        producer.setVipChannelEnabled(false);
        producer.start();

        for (int i=1;i<=10;i++) {
            Message message = new Message();
            message.setTopic("test-topic");
            message.setTags("test-tag");
            message.setBody("i am a msg".getBytes());
            message.setKeys(String.valueOf(i));
            SendResult sendResult = producer.send(message);

//            SendResult sendResult = producer.send(message, new MessageQueueSelector() {
//                @Override
//                public MessageQueue select(List<MessageQueue> mqs, Message msg, Object arg) {
//                    MessageQueue messageQueue = mqs.get(0);
//                    messageQueue.
//                    return null;
//                }
//            },1);

            System.out.println(sendResult);
        }





        // 顺序消费





    }


}
