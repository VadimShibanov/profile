package com.bank.profile.controller;

import com.bank.profile.dto.ProfileDto;
import com.bank.profile.dto.RegistrationDto;
import com.bank.profile.service.ProfileService;
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

public class ProfileControllerTest {

    private MockMvc mockMvc;

    @Mock
    private ProfileService profileService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        ProfileController profileController = new ProfileController(profileService);
        mockMvc = MockMvcBuilders.standaloneSetup(profileController).build();
    }

    @Test
    public void testGetAllProfile() throws Exception {

        ProfileDto registration1 = new ProfileDto();
        registration1.setId(1L);
        ProfileDto registration2 = new ProfileDto();
        registration2.setId(2L);
        List<ProfileDto> registrations = Arrays.asList(registration1, registration2);
        when(profileService.getAllProfiles()).thenReturn(registrations);

        mockMvc.perform(get("/profiles"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[1].id").value(2));


        verify(profileService, times(1)).getAllProfiles();
        verifyNoMoreInteractions(profileService);
    }

   @Test
    public void testGetProfileById() throws Exception {

        ProfileDto registration = new ProfileDto();
        registration.setId(1L);
        when(profileService.getProfileById(1L)).thenReturn(registration);


        mockMvc.perform(get("/profiles/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1));


        verify(profileService, times(1)).getProfileById(1L);
        verifyNoMoreInteractions(profileService);
    }


    @Test
    public void testCreateProfile() throws Exception {

        ProfileDto registration = new ProfileDto();
        registration.setId(1L);


        mockMvc.perform(post("/profiles")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"id\": 1}"))
                .andExpect(status().isCreated());


        verify(profileService, times(1)).createProfile(any(ProfileDto.class));
        verifyNoMoreInteractions(profileService);
    }


    @Test
    public void testUpdateProfile() throws Exception {

        ProfileDto registration = new ProfileDto();
        registration.setId(1L);


        mockMvc.perform(put("/profiles/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"id\": 1}"))
                .andExpect(status().isOk());


        verify(profileService, times(1)).updateProfile(eq(1L), any(ProfileDto.class));
        verifyNoMoreInteractions(profileService);
    }
    @Test
    public void testDeleteProfile() throws Exception {

        ProfileDto registration = new ProfileDto();
        registration.setId(1L);


        mockMvc.perform(delete("/profiles/1"))
                .andExpect(status().isOk());


        verify(profileService, times(1)).deleteProfile(eq(1L));
        verifyNoMoreInteractions(profileService);
    }
}