package com.spring.cpf_validator_back.server;

import com.spring.cpf_validator_back.core.CPFValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.*;
import java.net.*;

@Component
public class TCPServer {

    private static final Logger logger = LoggerFactory.getLogger(TCPServer.class);

    public static void main(String[] args) {
        int port = 12345;

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            logger.info("Servidor TCP iniciado na porta {}", port);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                logger.info("Cliente conectado: {}", clientSocket.getInetAddress());

                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

                String cpf = in.readLine();
                boolean isValid = CPFValidator.isValidCPF(cpf);

                out.println(isValid ? "CPF válido" : "CPF inválido");

                clientSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
