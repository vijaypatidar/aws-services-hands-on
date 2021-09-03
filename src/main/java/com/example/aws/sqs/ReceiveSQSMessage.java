package com.example.aws.sqs;

import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClientBuilder;
import com.amazonaws.services.sqs.model.ReceiveMessageResult;

public class ReceiveSQSMessage {
    public static void main(String[] args) {
        AmazonSQS amazonSQS = AmazonSQSClientBuilder.defaultClient();

        String queueName = "events";

        try {
            while (true){
                ReceiveMessageResult receiveMessageResult = amazonSQS.receiveMessage(queueName);
                receiveMessageResult.getMessages().forEach(message -> {
                    try{
                        System.out.println(message);
                        //block of code
                        amazonSQS.deleteMessage(queueName,message.getReceiptHandle());
                    }catch (Exception e){

                    }
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
