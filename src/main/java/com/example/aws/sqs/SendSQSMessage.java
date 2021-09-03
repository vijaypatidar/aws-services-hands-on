package com.example.aws.sqs;

import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClientBuilder;
import com.amazonaws.services.sqs.model.ReceiveMessageResult;

public class SendSQSMessage {
    public static void main(String[] args) {
        AmazonSQS amazonSQS = AmazonSQSClientBuilder.defaultClient();

        String queueName = "events";

        try {
            while (true){
                amazonSQS.sendMessage(queueName,"Sending test data to SQS "+System.currentTimeMillis());
                Thread.sleep(3000);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
