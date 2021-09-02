package com.example.aws.s3;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.Bucket;

import java.util.List;

public class ListBucket {
    public static void main(String[] args) {
        AmazonS3 amazonS3 = AmazonS3ClientBuilder.defaultClient();
        List<Bucket> buckets = amazonS3.listBuckets();
        buckets.forEach(bucket -> {
            System.out.println(bucket.getName()+" "+bucket.getOwner());
        });
    }
}
