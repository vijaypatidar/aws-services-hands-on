package com.example.aws.sns;

import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.AmazonSNSClientBuilder;
import com.amazonaws.services.sns.model.DeleteTopicRequest;

public class DeleteSnsTopic {
    public static void main(String[] args) {
        AmazonSNS sns = AmazonSNSClientBuilder.defaultClient();

        DeleteTopicRequest request = new DeleteTopicRequest("arn:aws:sns:ap-south-1:618045298702:topic-sdk");
        sns.deleteTopic(request);
        
    }
}
