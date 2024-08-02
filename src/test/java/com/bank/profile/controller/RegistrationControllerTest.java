package com.bank.profile.controller;

import com.bank.profile.dto.RegistrationDto;
import com.bank.profile.service.RegistrationService;
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

public class RegistrationControllerTest {

    private MockMvc mockMvc;

    @Mock
    private RegistrationService registrationService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        RegistrationController registrationController = new RegistrationController(registrationService);
        mockMvc = MockMvcBuilders.standaloneSetup(registrationController).build();
    }

    @Test
    public void testGetAllRegistrations() throws Exception {

        RegistrationDto registration1 = new RegistrationDto();
        registration1.setId(1L);
        RegistrationDto registration2 = new RegistrationDto();
        registration2.setId(2L);
        List<RegistrationDto> registrations = Arrays.asList(registration1, registration2);
        when(registrationService.getAllRegistrations()).thenReturn(registrations);

        mockMvc.perform(get("/registrations"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[1].id").value(2));


        verify(registrationService, times(1)).getAllRegistrations();
        verifyNoMoreInteractions(registrationService);
    }

    @Test
    public void testGetRegistrationById() throws Exception {

        RegistrationDto registration = new RegistrationDto();
        registration.setId(1L);
        when(registrationService.getRegistrationById(1L)).thenReturn(registration);


        mockMvc.perform(get("/registrations/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1));


        verify(registrationService, times(1)).getRegistrationById(1L);
        verifyNoMoreInteractions(registrationService);
    }

    @Test
    public void testCreateRegistration() throws Exception {

        RegistrationDto registration = new RegistrationDto();
        registration.setId(1L);


        mockMvc.perform(post("/registrations")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"id\": 1}"))
                .andExpect(status().isCreated());


        verify(registrationService, times(1)).createRegistration(any(RegistrationDto.class));
        verifyNoMoreInteractions(registrationService);
    }

    @Test
    public void testUpdateRegistration() throws Exception {

        RegistrationDto registration = new RegistrationDto();
        registration.setId(1L);


        mockMvc.perform(put("/registrations/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"id\": 1}"))
                .andExpect(status().isOk());


        verify(registrationService, times(1)).updateRegistration(eq(1L), any(RegistrationDto.class));
        verifyNoMoreInteractions(registrationService);
    }
    @Test
    public void testDeleteRegistration() throws Exception {

        RegistrationDto registration = new RegistrationDto();
        registration.setId(1L);


        mockMvc.perform(delete("/registrations/1"))
                .andExpect(status().isOk());


        verify(registrationService, times(1)).deleteRegistration(eq(1L));
        verifyNoMoreInteractions(registrationService);
    }
}