package com.bank.profile.service;


import com.bank.profile.dto.ProfileDto;
import com.bank.profile.entity.Profile;
import com.bank.profile.mapper.ProfileMapper;
import com.bank.profile.repository.ActualRegistrationRepository;
import com.bank.profile.repository.PassportRepository;
import com.bank.profile.repository.ProfileRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;


import javax.persistence.EntityNotFoundException;

import java.util.Optional;


import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.openMocks;


class ProfileServiceTest {


    private ProfileService profileService;

    @Mock
    private ProfileRepository profileRepository;

    @Mock
    private PassportRepository passportRepository;

    @Mock
    private ActualRegistrationRepository actualRegistrationRepository;

    @Mock
    private ProfileMapper profileMapper;

    @BeforeEach
    void setUp() {
        openMocks(this);
        profileService = new ProfileService(profileRepository, passportRepository, actualRegistrationRepository, profileMapper);
    }

    @Test
    void testGetProfileById() {
        Profile profile = new Profile();
        when(profileRepository.findById(any())).thenReturn(Optional.of(profile));
        when(profileMapper.toDto(any())).thenReturn(new ProfileDto());
        Assertions.assertNotNull(profileService.getProfileById(1L));
    }

    @Test
    void testGetProfileByIdThrowsException() {
        when(profileRepository.findById(any())).thenReturn(Optional.empty());
        Assertions.assertThrows(EntityNotFoundException.class, () -> profileService.getProfileById(1L));
    }

    @Test
    void testDeleteProfile() {
        profileService.deleteProfile(1L);
        verify(profileRepository, times(1)).deleteById(1L);
    }


}