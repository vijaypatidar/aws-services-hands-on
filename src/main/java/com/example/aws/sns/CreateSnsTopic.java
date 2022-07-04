package com.example.aws.sns;

import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.AmazonSNSClientBuilder;
import com.amazonaws.services.sns.model.CreateTopicResult;

public class CreateSnsTopic {
    public static void main(String[] args) {
        AmazonSNS sns = AmazonSNSClientBuilder.defaultClient();

        CreateTopicResult topic = sns.createTopic("topic-sdk");
        System.out.println("Topic created arn : "+topic.getTopicArn());
    }
}
