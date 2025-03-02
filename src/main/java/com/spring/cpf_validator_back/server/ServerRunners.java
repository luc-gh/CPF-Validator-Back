package com.spring.cpf_validator_back.server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ServerRunners implements CommandLineRunner {
    private static final Logger logger = LoggerFactory.getLogger(ServerRunners.class);

    @Override
    public void run(String... args) throws Exception {
        // Inicia o TCPServer em uma thread separada
        logger.info("Iniciando ServerRunners");
        new Thread(() -> TCPServer.main(new String[]{})).start();
        // Inicia o UDPServer em uma thread separada
        new Thread(() -> UDPServer.main(new String[]{})).start();
    }
}
