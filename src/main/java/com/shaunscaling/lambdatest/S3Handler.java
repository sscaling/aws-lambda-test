package com.shaunscaling.lambdatest;

import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.event.S3EventNotification;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.S3Object;

import java.io.InputStream;

public class S3Handler {
    public Object onPut(S3EventNotification input, Context context) {

        LambdaLogger logger = context.getLogger();
        logger.log("Received: " + input.toJson());

//
//        AmazonS3Client s3Client = new AmazonS3Client(new DefaultAWSCredentialsProviderChain());
//
//        for (S3EventNotification.S3EventNotificationRecord record : input.getRecords()) {
//            String s3Key = record.getS3().getObject().getKey();
//            String s3Bucket = record.getS3().getBucket().getName();
//            context.getLogger().log("found id: " + s3Bucket+" "+s3Key);
//            // retrieve s3 object
//            S3Object object = s3Client.getObject(new GetObjectRequest(s3Bucket, s3Key));
//            InputStream objectData = object.getObjectContent();
//            //insert object into elasticsearch
//        }
        return null;
    }
}
