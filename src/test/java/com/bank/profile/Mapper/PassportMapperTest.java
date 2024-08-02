package com.bank.profile.Mapper;

import com.bank.profile.dto.PassportDto;
import com.bank.profile.entity.Passport;
import com.bank.profile.entity.RegistrationEntity;
import com.bank.profile.mapper.PassportMapper;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PassportMapperTest {

    private final PassportMapper mapper = Mappers.getMapper(PassportMapper.class);

    @Test
    void testToDto() {

        Passport passport = new Passport();
        passport.setId(1L);
        passport.setSeries(1234);
        passport.setNumber(56789L);
        passport.setLastName("setLastName");
        passport.setFirstName("setFirstName");
        passport.setMiddleName("setMiddleName");
        passport.setGender("setMiddleName");
        passport.setBirthDate(LocalDate.of(1, 1, 1));
        passport.setBirthPlace("setBirthPlace");
        passport.setIssuedBy("setIssuedBy");
        passport.setDateOfIssue(LocalDate.now());
        passport.setDivisionCode(123456);
        passport.setExpirationDate(LocalDate.of(2, 2, 2));
        passport.setRegistration(new RegistrationEntity());

        PassportDto dto = mapper.toDto(passport);

        assertEquals(passport.getId(), dto.getId());
        assertEquals(passport.getSeries(), dto.getSeries());
        assertEquals(passport.getNumber(), dto.getNumber());
        assertEquals(passport.getLastName(), dto.getLastName());
        assertEquals(passport.getFirstName(), dto.getFirstName());
        assertEquals(passport.getMiddleName(), dto.getMiddleName());
        assertEquals(passport.getGender(), dto.getGender());
        assertEquals(passport.getBirthDate(), dto.getBirthDate());
        assertEquals(passport.getBirthPlace(), dto.getBirthPlace());
        assertEquals(passport.getIssuedBy(), dto.getIssuedBy());
        assertEquals(passport.getDateOfIssue(), dto.getDateOfIssue());
        assertEquals(passport.getDivisionCode(), dto.getDivisionCode());
        assertEquals(passport.getExpirationDate(), dto.getExpirationDate());
    }

    @Test
    void testToEntity() {

        PassportDto dto = new PassportDto();
        dto.setId(1L);
        dto.setSeries(1234);
        dto.setNumber(56789L);
        dto.setLastName("setLastName");
        dto.setFirstName("setFirstName");
        dto.setMiddleName("setMiddleName");
        dto.setGender("setMiddleName");
        dto.setBirthDate(LocalDate.of(1, 1, 1));
        dto.setBirthPlace("setBirthPlace");
        dto.setIssuedBy("setIssuedBy");
        dto.setDateOfIssue(LocalDate.now());
        dto.setDivisionCode(123456);
        dto.setExpirationDate(LocalDate.of(2, 2, 2));
        dto.setRegistrationId(1L);

        Passport passport = mapper.toEntity(dto);

        assertEquals(dto.getId(), passport.getId());
        assertEquals(dto.getSeries(), passport.getSeries());
        assertEquals(dto.getNumber(), passport.getNumber());
        assertEquals(dto.getLastName(), passport.getLastName());
        assertEquals(dto.getFirstName(), passport.getFirstName());
        assertEquals(dto.getMiddleName(), passport.getMiddleName());
        assertEquals(dto.getGender(), passport.getGender());
        assertEquals(dto.getBirthDate(), passport.getBirthDate());
        assertEquals(dto.getBirthPlace(), passport.getBirthPlace());
        assertEquals(dto.getIssuedBy(), passport.getIssuedBy());
        assertEquals(dto.getDateOfIssue(), passport.getDateOfIssue());
        assertEquals(dto.getDivisionCode(), passport.getDivisionCode());
        assertEquals(dto.getExpirationDate(), passport.getExpirationDate());

    }
}