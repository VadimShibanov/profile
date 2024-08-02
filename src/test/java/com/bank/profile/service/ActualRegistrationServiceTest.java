package com.bank.profile.service;

import com.bank.profile.dto.ActualRegistrationDTO;
import com.bank.profile.entity.ActualRegistrationEntity;
import com.bank.profile.mapper.ActualRegistrationMapper;
import com.bank.profile.repository.ActualRegistrationRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class ActualRegistrationServiceTest {

    @Mock
    private ActualRegistrationRepository repository;

    @Mock
    private ActualRegistrationMapper mapper;

    @InjectMocks
    private ActualRegistrationService service;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllActualRegistration() {
        List<ActualRegistrationEntity> entities = new ArrayList<>();
        ActualRegistrationEntity entity1 = new ActualRegistrationEntity();
        entity1.setId(1L);
        entity1.setCountry("USA");
        entity1.setRegion("California");
        entity1.setCity("Los Angeles");
        entity1.setDistrict("Downtown");
        entity1.setLocality("Hollywood");
        entity1.setStreet("Sunset Blvd");
        entity1.setHouseNumber("123");
        entity1.setHouseBlock("A");
        entity1.setFlatNumber("456");
        entity1.setIndex(90001L);
        entities.add(entity1);

        when(repository.findAll()).thenReturn(entities);

        ActualRegistrationDTO dto1 = new ActualRegistrationDTO();
        dto1.setId(1L);
        dto1.setCountry("setCountry");
        dto1.setRegion("setRegion");
        dto1.setCity("setCity");
        dto1.setDistrict("setCity");
        dto1.setLocality("setLocality");
        dto1.setStreet("setLocality");
        dto1.setHouseNumber("setHouseNumber");
        dto1.setHouseBlock("setHouseBlock");
        dto1.setFlatNumber("setFlatNumber");
        dto1.setIndex(90001L);

        List<ActualRegistrationDTO> expected = new ArrayList<>();
        expected.add(dto1);

        when(mapper.toDTO(entity1)).thenReturn(dto1);

        List<ActualRegistrationDTO> actual = service.getAllActualRegistration();
        assertEquals(expected, actual);
    }
}