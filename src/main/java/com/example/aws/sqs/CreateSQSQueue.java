package com.example.aws.sqs;

import com.amazonaws.services.s3.model.AmazonS3Exception;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClientBuilder;
import com.amazonaws.services.sqs.model.AmazonSQSException;
import com.amazonaws.services.sqs.model.CreateQueueRequest;

public class CreateSQSQueue {
    public static void main(String[] args) {
        AmazonSQS amazonSQS = AmazonSQSClientBuilder.defaultClient();

        String queueName = "events";
        CreateQueueRequest queueRequest = new CreateQueueRequest(queueName)
                .addAttributesEntry("DelaySeconds", "60")
                .addAttributesEntry("MessageRetentionPeriod", "86400");

        try {
            amazonSQS.createQueue(queueRequest);
            System.out.println("SQS queue created : "+queueName);
        } catch (AmazonSQSException e) {
            e.printStackTrace();
        }


    }
}
