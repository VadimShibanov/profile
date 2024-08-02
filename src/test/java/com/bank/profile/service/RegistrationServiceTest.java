package com.bank.profile.service;

import com.bank.profile.dto.RegistrationDto;
import com.bank.profile.entity.RegistrationEntity;
import com.bank.profile.mapper.RegistrationMapper;
import com.bank.profile.repository.RegistrationRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.openMocks;

public class RegistrationServiceTest {

    @Mock
    private RegistrationRepository registrationRepository;

    @Mock
    private RegistrationMapper registrationMapper;

    @InjectMocks
    private RegistrationService registrationService;

    private final Long id = 1L;

    private RegistrationDto registrationDto;
    private RegistrationEntity registrationEntity;

    @BeforeEach
    public void setup() {
        openMocks(this);

        registrationDto = new RegistrationDto();
        registrationDto.setCountry("setCountry");
        registrationDto.setRegion("setRegion");
        registrationDto.setCity("Moscow");
        registrationDto.setDistrict("Central");
        registrationDto.setLocality("Arbat");
        registrationDto.setStreet("Old Arbat");
        registrationDto.setHouseNumber("1");
        registrationDto.setFlatNumber("10");
        registrationDto.setIndex(123456L);
        registrationDto.setColumn(1);

        registrationEntity = new RegistrationEntity();
        registrationEntity.setId(id);
        registrationEntity.setCountry("setCountry");
        registrationEntity.setRegion("setRegion");
        registrationEntity.setCity("Moscow");
        registrationEntity.setDistrict("Central");
        registrationEntity.setLocality("Arbat");
        registrationEntity.setStreet("Old Arbat");
        registrationEntity.setHouseNumber("1");
        registrationEntity.setFlatNumber("10");
        registrationEntity.setIndex(123456L);
        registrationEntity.setColumn(1);
    }

    @Test
    @DisplayName("Get all registrations test")
    public void getAllRegistrationsTest() {
        List<RegistrationEntity> registrationEntities = new ArrayList<>();
        registrationEntities.add(registrationEntity);

        when(registrationRepository.findAll()).thenReturn(registrationEntities);
        when(registrationMapper.toDto(registrationEntity)).thenReturn(registrationDto);

        List<RegistrationDto> registrations = registrationService.getAllRegistrations();

        Assertions.assertNotNull(registrations);
        Assertions.assertEquals(1, registrations.size());
        Assertions.assertEquals(registrationDto, registrations.get(0));

        verify(registrationRepository, times(1)).findAll();
        verify(registrationMapper, times(1)).toDto(registrationEntity);
    }

    @Test
    @DisplayName("Get registration by id test")
    public void getRegistrationByIdTest() {
        when(registrationRepository.findById(id)).thenReturn(Optional.of(registrationEntity));
        when(registrationMapper.toDto(registrationEntity)).thenReturn(registrationDto);

        RegistrationDto registration = registrationService.getRegistrationById(id);

        Assertions.assertNotNull(registration);
        Assertions.assertEquals(registrationDto, registration);

        verify(registrationRepository, times(1)).findById(id);
        verify(registrationMapper, times(1)).toDto(registrationEntity);
    }

    @Test
    @DisplayName("Create registration test")
    public void createRegistrationTest() {
        when(registrationMapper.toEntity(registrationDto)).thenReturn(registrationEntity);

        registrationService.createRegistration(registrationDto);

        verify(registrationRepository, times(1)).save(registrationEntity);
        verify(registrationMapper, times(1)).toEntity(registrationDto);
    }

    @Test
    @DisplayName("Update registration test")
    public void updateRegistrationTest() {
        when(registrationRepository.findById(id)).thenReturn(Optional.of(registrationEntity));

        registrationDto.setCity("Saint Petersburg");
        registrationDto.setStreet("Nevsky Prospekt");
        registrationDto.setFlatNumber("20");

        registrationService.updateRegistration(id, registrationDto);

        verify(registrationRepository, times(1)).findById(id);
        verify(registrationRepository, times(1)).save(registrationEntity);
        Assertions.assertEquals("Saint Petersburg", registrationEntity.getCity());
        Assertions.assertEquals("Nevsky Prospekt", registrationEntity.getStreet());
        Assertions.assertEquals("20", registrationEntity.getFlatNumber());
    }

    @Test
    @DisplayName("Delete registration test")
    public void deleteRegistrationTest() {
        registrationService.deleteRegistration(id);

        verify(registrationRepository, times(1)).deleteById(id);
    }
}