package com.spring.cpf_validator_back.server;

import com.spring.cpf_validator_back.core.CPFValidator;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.*;

@Component
public class UDPServer {

    public static void main(String[] args) {
        int port = 54321;

        try (DatagramSocket socket = new DatagramSocket(port)) {
            System.out.println("Servidor UDP iniciado na porta " + port);

            byte[] buffer = new byte[1024];

            while (true) {
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
                socket.receive(packet);

                String cpf = new String(packet.getData(), 0, packet.getLength());
                boolean isValid = CPFValidator.isValidCPF(cpf);

                String response = isValid ? "CPF válido" : "CPF inválido";
                byte[] responseBytes = response.getBytes();

                DatagramPacket responsePacket = new DatagramPacket(responseBytes, responseBytes.length, packet.getAddress(), packet.getPort());
                socket.send(responsePacket);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
