package com.bank.profile.controller;

import com.bank.profile.dto.PassportDto;
import com.bank.profile.dto.ProfileDto;
import com.bank.profile.dto.RegistrationDto;
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

public class PassportControllerTest {

    private MockMvc mockMvc;

    @Mock
    private PassportService passportService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        PassportController passportController = new PassportController(passportService);
        mockMvc = MockMvcBuilders.standaloneSetup(passportController).build();
    }

    @Test
    public void testGetAllPassport() throws Exception {

        PassportDto registration1 = new PassportDto();
        registration1.setId(1L);
        PassportDto registration2 = new PassportDto();
        registration2.setId(2L);
        List<PassportDto> registrations = Arrays.asList(registration1, registration2);
        when(passportService.getAllPassports()).thenReturn(registrations);


        mockMvc.perform(get("/passports"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[1].id").value(2));


        verify(passportService, times(1)).getAllPassports();
        verifyNoMoreInteractions(passportService);
    }

    @Test
    public void testGetPassportById() throws Exception {

        PassportDto registration = new PassportDto();
        registration.setId(1L);
        when(passportService.getPassportById(1L)).thenReturn(registration);


        mockMvc.perform(get("/passports/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1));


        verify(passportService, times(1)).getPassportById(1L);
        verifyNoMoreInteractions(passportService);
    }
    @Test
    public void testDeletePassport() throws Exception {

        PassportDto registration = new PassportDto();
        registration.setId(1L);


        mockMvc.perform(delete("/passports/1"))
                .andExpect(status().isOk());


        verify(passportService, times(1)).deletePassport(eq(1L));
        verifyNoMoreInteractions(passportService);
    }


    @Test
    public void testCreatePassport() throws Exception {

        PassportDto registration = new PassportDto();
        registration.setId(1L);


        mockMvc.perform(post("/passports")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"id\": 1}"))
                .andExpect(status().isCreated());


        verify(passportService, times(1)).createPassport(any(PassportDto.class));
        verifyNoMoreInteractions(passportService);
    }


    @Test
    public void testUpdatePassport() throws Exception {

        PassportDto registration = new PassportDto();
        registration.setId(1L);


        mockMvc.perform(put("/passports/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"id\": 1}"))
                .andExpect(status().isOk());


        verify(passportService, times(1)).updatePassport(eq(1L), any(PassportDto.class));
        verifyNoMoreInteractions(passportService);
    }

 
}