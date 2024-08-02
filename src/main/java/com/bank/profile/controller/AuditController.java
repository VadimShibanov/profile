package com.bank.profile.controller;

import com.bank.profile.dto.AuditDto;
import com.bank.profile.service.AuditService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;

@RestController
@RequestMapping("/audits")
public class AuditController {
    private final Logger logger = LoggerFactory.getLogger(AuditController.class);

    private final AuditService auditService;

    @Autowired
    public AuditController(AuditService auditService) {
        this.auditService = auditService;
    }

    @Operation(summary = "Get all audits")
    @GetMapping
    public List<AuditDto> getAllAudits() {
        logger.info("Received request to get all audits.");
        List<AuditDto> audits = auditService.getAllAudits();
        logger.info("Returning {} audits.", audits.size());
        return audits;
    }

    @Operation(summary = "Get audit by id")
    @GetMapping("/{id}")
    public AuditDto getAuditById(@PathVariable Long id) {
        logger.info("Received request to get audit with id {}.", id);
        AuditDto audit = auditService.getAuditById(id);
        logger.info("Returning audit with id {}.", id);
        return audit;
    }

    @Operation(summary = "Create new audit")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createAudit(@RequestBody AuditDto auditDto) {
        logger.info("Received request to create audit.");
        auditService.createAudit(auditDto);
        logger.info("Audit created successfully.");
    }
}