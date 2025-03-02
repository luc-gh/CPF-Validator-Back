package com.spring.cpf_validator_back.core;

import com.spring.cpf_validator_back.client.TCPClient;
import com.spring.cpf_validator_back.client.UDPClient;
import org.springframework.stereotype.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class CPFValidationService {
    private static final Logger logger = LoggerFactory.getLogger(CPFValidationService.class);

    public boolean validateCPF(String cpf, String protocol) {
        logger.info("Iniciando validação do CPF: {} via protocolo: {}", cpf, protocol);
        boolean valid;
        if ("tcp".equalsIgnoreCase(protocol)) {
            valid = TCPClient.validate(cpf);
        } else if ("udp".equalsIgnoreCase(protocol)) {
            valid = UDPClient.validate(cpf);
        } else {
            logger.warn("Protocolo desconhecido: {}. Retornando inválido.", protocol);
            return false;
        }
        logger.info("Resultado da validação: {}", valid ? "CPF válido" : "CPF inválido");
        return valid;
    }
}

