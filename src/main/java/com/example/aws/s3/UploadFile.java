package com.example.aws.s3;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.AmazonS3Exception;

import java.io.File;

public class UploadFile {
    public static void main(String[] args) {
        AmazonS3 amazonS3 = AmazonS3ClientBuilder.defaultClient();
        String bucketName = "es4all";
        try {
            File file = new File("user.txt");
            String fileKey = "user.txt";
            amazonS3.putObject(bucketName,fileKey,file);
            System.out.println("File uploaded successfully");
        }catch (AmazonS3Exception e){
            e.printStackTrace();
        }
    }
}
