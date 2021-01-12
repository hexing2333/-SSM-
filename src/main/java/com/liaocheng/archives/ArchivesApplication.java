package com.liaocheng.archives;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.liaocheng.archives.Dao")
public class ArchivesApplication {

    public static void main(String[] args) {
        SpringApplication.run(ArchivesApplication.class, args);
    }

}
