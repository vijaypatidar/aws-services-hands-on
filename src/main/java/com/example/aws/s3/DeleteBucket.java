package com.example.aws.s3;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.AmazonS3Exception;

public class DeleteBucket {
    public static void main(String[] args) {
        AmazonS3 amazonS3 = AmazonS3ClientBuilder.defaultClient();
        String bucketName = "es4all";

        try {
            amazonS3.deleteBucket(bucketName);
            System.out.println("S3 bucket deleted");
        }catch (AmazonS3Exception e){
            e.printStackTrace();
        }
    }
}
