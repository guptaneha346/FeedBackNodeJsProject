package com.holiday.bank;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AwsConfig {

    @Bean
    public BasicAWSCredentials basicAWSCredentials() {
        return new BasicAWSCredentials("accessKey", "secretKey");
    }

    @Bean(name="amazonClient")
    public AmazonS3 amazonS3Client() {
        return AmazonS3ClientBuilder.standard()
                .withCredentials(new AWSStaticCredentialsProvider(this.basicAWSCredentials()))
                .withRegion("region_name_here").build();
    }
}
