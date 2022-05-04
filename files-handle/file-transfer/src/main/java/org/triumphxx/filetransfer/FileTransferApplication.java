package org.triumphxx.filetransfer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class FileTransferApplication {

    public static void main(String[] args) {
        SpringApplication.run(FileTransferApplication.class, args);
    }

}
