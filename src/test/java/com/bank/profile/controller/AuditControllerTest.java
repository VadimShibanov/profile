package com.bank.profile.controller;

import com.bank.profile.dto.AuditDto;
import com.bank.profile.dto.PassportDto;
import com.bank.profile.dto.ProfileDto;
import com.bank.profile.dto.RegistrationDto;
import com.bank.profile.service.AuditService;
import com.bank.profile.service.PassportService;
import com.bank.profile.service.ProfileService;
import com.bank.profile.service.RegistrationService;
import liquibase.pro.packaged.P;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class AuditControllerTest {

    private MockMvc mockMvc;

    @Mock
    private AuditService auditService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        AuditController auditController = new AuditController(auditService);
        mockMvc = MockMvcBuilders.standaloneSetup(auditController).build();
    }

    @Test
    public void testGetAllAudit() throws Exception {

        AuditDto registration1 = new AuditDto();
        registration1.setId(1L);
        AuditDto registration2 = new AuditDto();
        registration2.setId(2L);
        List<AuditDto> registrations = Arrays.asList(registration1, registration2);
        when(auditService.getAllAudits()).thenReturn(registrations);


        mockMvc.perform(get("/audits"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[1].id").value(2));


        verify(auditService, times(1)).getAllAudits();
        verifyNoMoreInteractions(auditService);
    }


    @Test
    public void testGetAuditById() throws Exception {

        AuditDto registration = new AuditDto();
        registration.setId(1L);
        when(auditService.getAuditById(1L)).thenReturn(registration);


        mockMvc.perform(get("/audits/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1));


        verify(auditService, times(1)).getAuditById(1L);
        verifyNoMoreInteractions(auditService);
    }







}