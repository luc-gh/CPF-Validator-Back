package com.spring.cpf_validator_back.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import java.io.*;
import java.net.*;

@Component
public class TCPClient {
    private static final Logger logger = LoggerFactory.getLogger(TCPClient.class);

    public static boolean validate(String cpf) {
        String serverAddress = "localhost"; // Como o servidor está no mesmo container
        int port = 12345; // Porta fixa para o servidor TCP

        logger.info("Tentando conectar ao TCPServer em {}:{}", serverAddress, port);
        try (Socket socket = new Socket(serverAddress, port)) {
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            logger.info("Enviando CPF: {}", cpf);
            out.println(cpf);

            String response = in.readLine();
            logger.info("Resposta do TCPServer: {}", response);
            return response != null && response.contains("válido");
        } catch (IOException e) {
            logger.error("Erro na conexão TCP: ", e);
            return false;
        }
    }
}
