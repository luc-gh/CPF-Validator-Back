package com.spring.cpf_validator_back.server;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ServerRunners implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        // Inicia o TCPServer em uma thread separada
        new Thread(() -> TCPServer.main(new String[]{})).start();
        // Inicia o UDPServer em uma thread separada
        new Thread(() -> UDPServer.main(new String[]{})).start();
    }
}
