package com.example.aws.s3;

import com.amazonaws.SdkClientException;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.S3Object;

import java.io.IOException;
import java.io.InputStream;

public class ReadFile {
    public static void main(String[] args) {
        AmazonS3 amazonS3 = AmazonS3ClientBuilder.defaultClient();
        String bucketName = "es4all";
        try {
            String fileKey = "user.txt";
            S3Object object = amazonS3.getObject(bucketName, fileKey);
            System.out.println(object);
            InputStream stream = object.getObjectContent();
            byte[] bytes = new byte[1024];
            int read ;
            while ((read=stream.read(bytes))>0){
                System.out.println(new String(bytes,0,read));
            }
            stream.close();
        } catch (SdkClientException | IOException e) {
            e.printStackTrace();
        }
    }
}
