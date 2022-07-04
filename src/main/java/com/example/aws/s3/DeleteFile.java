package com.example.aws.s3;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.AmazonS3Exception;

import java.io.File;

public class DeleteFile {
    public static void main(String[] args) {
        AmazonS3 amazonS3 = AmazonS3ClientBuilder.defaultClient();
        String bucketName = "es4all";
        try {
            String fileKey = "user.txt";
            amazonS3.deleteObject(bucketName,fileKey);
            System.out.println("File deleted successfully");
        }catch (AmazonS3Exception e){
            e.printStackTrace();
        }
    }
}
