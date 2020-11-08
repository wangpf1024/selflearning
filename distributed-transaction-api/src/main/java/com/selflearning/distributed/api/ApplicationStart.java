package com.selflearning.distributed.api;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication(scanBasePackages="com.sinoiov.bxcx.distributed.transaction")
public class ApplicationStart {


    public static void main(String[] args) {

        SpringApplication.run(ApplicationStart.class,args);

    }


}
