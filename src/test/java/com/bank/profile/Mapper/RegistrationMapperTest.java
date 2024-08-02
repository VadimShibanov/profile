package com.bank.profile.Mapper;

import com.bank.profile.dto.RegistrationDto;
import com.bank.profile.entity.RegistrationEntity;
import com.bank.profile.mapper.RegistrationMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RegistrationMapperTest {

    private final RegistrationMapper mapper = RegistrationMapper.INSTANCE;

    @Test
    public void testToEntity() {
        RegistrationDto dto = new RegistrationDto();
        dto.setId(1L);
        dto.setCountry("setCountry");
        dto.setRegion("setRegion");
        dto.setCity("setCity");
        dto.setDistrict("setDistrict");
        dto.setLocality("setLocality");
        dto.setStreet("setStreet");
        dto.setHouseNumber("123");
        dto.setHouseBlock("A");
        dto.setFlatNumber("456");
        dto.setIndex(12345L);
        dto.setColumn(1);

        RegistrationEntity entity = mapper.toEntity(dto);

        Assertions.assertEquals(dto.getId(), entity.getId());
        Assertions.assertEquals(dto.getCountry(), entity.getCountry());
        Assertions.assertEquals(dto.getRegion(), entity.getRegion());
        Assertions.assertEquals(dto.getCity(), entity.getCity());
        Assertions.assertEquals(dto.getDistrict(), entity.getDistrict());
        Assertions.assertEquals(dto.getLocality(), entity.getLocality());
        Assertions.assertEquals(dto.getStreet(), entity.getStreet());
        Assertions.assertEquals(dto.getHouseNumber(), entity.getHouseNumber());
        Assertions.assertEquals(dto.getHouseBlock(), entity.getHouseBlock());
        Assertions.assertEquals(dto.getFlatNumber(), entity.getFlatNumber());
        Assertions.assertEquals(dto.getIndex(), entity.getIndex());
        Assertions.assertEquals(dto.getColumn(), entity.getColumn());
    }

    @Test
    public void testToDto() {
        RegistrationEntity entity = new RegistrationEntity();
        entity.setId(1L);
        entity.setCountry("setCountry");
        entity.setRegion("setRegion");
        entity.setCity("setCity");
        entity.setDistrict("setDistrict");
        entity.setLocality("setLocality");
        entity.setStreet("setStreet");
        entity.setHouseNumber("123");
        entity.setHouseBlock("A");
        entity.setFlatNumber("456");
        entity.setIndex(12345L);
        entity.setColumn(1);

        RegistrationDto dto = mapper.toDto(entity);

        Assertions.assertEquals(entity.getId(), dto.getId());
        Assertions.assertEquals(entity.getCountry(), dto.getCountry());
        Assertions.assertEquals(entity.getRegion(), dto.getRegion());
        Assertions.assertEquals(entity.getCity(), dto.getCity());
        Assertions.assertEquals(entity.getDistrict(), dto.getDistrict());
        Assertions.assertEquals(entity.getLocality(), dto.getLocality());
        Assertions.assertEquals(entity.getStreet(), dto.getStreet());
        Assertions.assertEquals(entity.getHouseNumber(), dto.getHouseNumber());
        Assertions.assertEquals(entity.getHouseBlock(), dto.getHouseBlock());
        Assertions.assertEquals(entity.getFlatNumber(), dto.getFlatNumber());
        Assertions.assertEquals(entity.getIndex(), dto.getIndex());
        Assertions.assertEquals(entity.getColumn(), dto.getColumn());
    }
}