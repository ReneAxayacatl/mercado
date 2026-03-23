package com.rene.mercado;

// import org.springframework.boot.SpringApplication;
// import org.springframework.boot.autoconfigure.SpringBootApplication;

// @SpringBootApplication
// public class MercadoApplication {

// 	public static void main(String[] args) {
// 		SpringApplication.run(MercadoApplication.class, args);
// 	}

// }
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class MercadoApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(MercadoApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(MercadoApplication.class);
    }
}