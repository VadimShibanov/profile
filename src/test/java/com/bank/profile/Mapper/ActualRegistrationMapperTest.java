package com.bank.profile.Mapper;

import com.bank.profile.dto.ActualRegistrationDTO;
import com.bank.profile.entity.ActualRegistrationEntity;
import com.bank.profile.mapper.ActualRegistrationMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

class ActualRegistrationMapperTest {

    private final ActualRegistrationMapper mapper = Mappers.getMapper(ActualRegistrationMapper.class);

    @Test
    void toDto() {
        ActualRegistrationEntity entity = new ActualRegistrationEntity();
        entity.setId(1L);
        entity.setCountry("Russia");
        entity.setRegion("Saratov");
        entity.setCity("Saratov");
        entity.setDistrict("Saratov");
        entity.setLocality("Saratov");
        entity.setStreet("Stepnaya");
        entity.setHouseNumber("1");
        entity.setHouseBlock("2");
        entity.setFlatNumber("3");
        entity.setIndex(413100L);

        ActualRegistrationDTO dto = mapper.toDTO(entity);

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
    }

    @Test
    void toEntity() {
        ActualRegistrationDTO dto = new ActualRegistrationDTO();
        dto.setId(1L);
        dto.setCountry("Russia");
        dto.setRegion("Saratov");
        dto.setCity("City");
        dto.setDistrict("Saratov");
        dto.setLocality("Saratov");
        dto.setStreet("Stepnaya");
        dto.setHouseNumber("1");
        dto.setHouseBlock("2");
        dto.setFlatNumber("3");
        dto.setIndex(413100L);

        ActualRegistrationEntity entity = mapper.toEntity(dto);

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
    }
}