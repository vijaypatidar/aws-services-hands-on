package com.example.aws.s3;

import com.amazonaws.SdkClientException;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.GeneratePresignedUrlRequest;
import com.amazonaws.services.s3.model.S3Object;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class PreSignedUrl {
    public static void main(String[] args) {
        AmazonS3 amazonS3 = AmazonS3ClientBuilder.defaultClient();
        String bucketName = "es4all";
        try {
            String fileKey = "user.txt";
            GeneratePresignedUrlRequest request = new GeneratePresignedUrlRequest(bucketName,fileKey);
            URL url = amazonS3.generatePresignedUrl(request);
            System.out.println(url.toString());
        } catch (SdkClientException e) {
            e.printStackTrace();
        }
    }
}
