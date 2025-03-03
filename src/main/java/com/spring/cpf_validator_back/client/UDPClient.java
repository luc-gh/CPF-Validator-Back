package com.spring.cpf_validator_back.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import java.io.IOException;
import java.net.*;

@Component
public class UDPClient {
    private static final Logger logger = LoggerFactory.getLogger(UDPClient.class);

    public static boolean validate(String cpf) {
        String serverAddress = "localhost"; // Mesmo container
        int port = 54321; // Porta fixa para o servidor UDP

        logger.info("Enviando pacote UDP para {}:{}", serverAddress, port);
        try (DatagramSocket socket = new DatagramSocket()) {
            InetAddress address = InetAddress.getByName(serverAddress);
            byte[] buffer = cpf.getBytes();
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length, address, port);
            socket.send(packet);

            byte[] responseBuffer = new byte[1024];
            DatagramPacket responsePacket = new DatagramPacket(responseBuffer, responseBuffer.length);
            socket.receive(responsePacket);

            String response = new String(responsePacket.getData(), 0, responsePacket.getLength());
            logger.info("Resposta do UDPServer: {}", response);
            return !response.toLowerCase().contains("inválido");
        } catch (IOException e) {
            logger.error("Erro na comunicação UDP: ", e);
            return false;
        }
    }
}
