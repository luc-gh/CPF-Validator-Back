package com.spring.cpf_validator_back.core;

import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/validate")
@CrossOrigin(origins = "*")
@AllArgsConstructor
public class CPFController {

    private static final Logger logger = LoggerFactory.getLogger(CPFController.class);
    private final CPFValidationService cpfValidationService;

    @GetMapping
    public ResponseEntity<Map<String, Object>> validateCPF(@RequestParam String cpf, @RequestParam String protocol) {
        logger.info("Requisição recebida para validar CPF: {} com protocolo: {}", cpf, protocol);
        boolean isValid = cpfValidationService.validateCPF(cpf, protocol);
        String message = isValid ? "CPF válido" : "CPF inválido";
        logger.info("Enviando resposta: {}", message);
        return ResponseEntity.ok(Map.of("valid", isValid, "message", message));
    }
}
