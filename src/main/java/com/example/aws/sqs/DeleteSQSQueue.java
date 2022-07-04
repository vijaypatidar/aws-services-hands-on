package com.example.aws.sqs;

import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClientBuilder;
import com.amazonaws.services.sqs.model.AmazonSQSException;
import com.amazonaws.services.sqs.model.CreateQueueRequest;
import com.amazonaws.services.sqs.model.DeleteQueueRequest;

public class DeleteSQSQueue {
    public static void main(String[] args) {
        AmazonSQS amazonSQS = AmazonSQSClientBuilder.defaultClient();

        String queueName = "events";
        DeleteQueueRequest request = new DeleteQueueRequest(queueName);

        try {
            amazonSQS.deleteQueue(request);
            System.out.println("SQS queue deleted : "+queueName);
        } catch (AmazonSQSException e) {
            e.printStackTrace();
        }


    }
}
