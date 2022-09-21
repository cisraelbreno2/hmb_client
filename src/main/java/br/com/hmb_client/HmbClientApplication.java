package br.com.hmb_client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class HmbClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(HmbClientApplication.class, args);
    }

}
