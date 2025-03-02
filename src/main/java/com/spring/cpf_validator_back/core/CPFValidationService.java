package com.spring.cpf_validator_back.core;

import com.spring.cpf_validator_back.client.TCPClient;
import com.spring.cpf_validator_back.client.UDPClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class CPFValidationService {
    private static final Logger logger = LoggerFactory.getLogger(CPFValidationService.class);

    public boolean validateCPF(String cpf, String protocol) {
        logger.info("Iniciando validação do CPF: {} via protocolo: {}", cpf, protocol);
        boolean valid;
        if ("tcp".equalsIgnoreCase(protocol)) {
            logger.info("Chamando TCPClient para validação do CPF.");
            valid = TCPClient.validate(cpf);
        } else if ("udp".equalsIgnoreCase(protocol)) {
            logger.info("Chamando UDPClient para validação do CPF.");
            valid = UDPClient.validate(cpf);
        } else {
            logger.warn("Protocolo desconhecido: {}. Retornando inválido.", protocol);
            return false;
        }
        logger.info("Resultado da validação: {}", valid ? "CPF válido" : "CPF inválido");
        return valid;
    }
}
