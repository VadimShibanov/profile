package com.bank.profile.service;

import com.bank.profile.dto.PassportDto;
import com.bank.profile.entity.Passport;
import com.bank.profile.entity.RegistrationEntity;
import com.bank.profile.mapper.PassportMapper;
import com.bank.profile.repository.PassportRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.openMocks;

class PassportServiceTest {

    @Mock
    PassportRepository passportRepository;

    @Mock
    PassportMapper passportMapper;

    @InjectMocks
    PassportService passportService;

    @BeforeEach
    void setUp() {
        openMocks(this);
    }

    @Test
    void testGetAllPassports() {
        List<Passport> passportList = new ArrayList<>();
        Passport passport = new Passport();
        passport.setId(1L);
        passportList.add(passport);
        when(passportRepository.findAll()).thenReturn(passportList);

        PassportDto passportDto = new PassportDto();
        passportDto.setId(1L);
        when(passportMapper.toDto(passport)).thenReturn(passportDto);

        List<PassportDto> passportDtoList = passportService.getAllPassports();

        Assertions.assertEquals(1, passportDtoList.size());
        verify(passportRepository, times(1)).findAll();
        verify(passportMapper, times(1)).toDto(passport);
    }

    @Test
    void testGetPassportById() {
        Passport passport = new Passport();
        passport.setId(1L);
        when(passportRepository.findById(1L)).thenReturn(Optional.of(passport));

        PassportDto passportDto = new PassportDto();
        passportDto.setId(1L);
        when(passportMapper.toDto(passport)).thenReturn(passportDto);

        PassportDto found = passportService.getPassportById(1L);

        Assertions.assertEquals(passportDto.getId(), found.getId());
        verify(passportRepository, times(1)).findById(1L);
        verify(passportMapper, times(1)).toDto(passport);
    }

    @Test
    void testCreatePassport() {
        PassportDto passportDto = new PassportDto();
        passportDto.setId(1L);
        Passport passport = new Passport();
        when(passportMapper.toEntity(passportDto)).thenReturn(passport);

        passportService.createPassport(passportDto);

        verify(passportRepository, times(1)).save(passport);
    }

    @Test
    void testUpdatePassport() {
        PassportDto passportDto = new PassportDto();
        passportDto.setId(1L);
        Passport passport = new Passport();
        RegistrationEntity registration = new RegistrationEntity();
        registration.setId(1L);
        passportDto.setRegistrationId(1L);
        when(passportRepository.findById(1L)).thenReturn(Optional.of(passport));
        when(passportMapper.toEntity(passportDto)).thenReturn(passport);

        passportService.updatePassport(1L, passportDto);

        verify(passportRepository, times(1)).findById(1L);
        verify(passportRepository, times(1)).save(passport);
        Assertions.assertEquals(registration.getId(), passport.getRegistration().getId());
    }

    @Test
    void testDeletePassport() {
        passportService.deletePassport(1L);
        verify(passportRepository, times(1)).deleteById(1L);
    }

    @Test
    void testGetPassportByIdThrowsException() {
        when(passportRepository.findById(any())).thenReturn(Optional.empty());
        Assertions.assertThrows(EntityNotFoundException.class, () -> passportService.getPassportById(1L));
    }

}