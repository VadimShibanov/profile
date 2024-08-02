package com.bank.profile.Mapper;

import com.bank.profile.dto.ProfileDto;
import com.bank.profile.entity.ActualRegistrationEntity;
import com.bank.profile.entity.Passport;
import com.bank.profile.entity.Profile;
import com.bank.profile.mapper.ProfileMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;



public class ProfileMapperTest {

    private ProfileMapper profileMapper;

    @BeforeEach
    void setUp() {
        profileMapper = Mappers.getMapper(ProfileMapper.class);
    }

    @Test
    @DisplayName("Mapping Profile to ProfileDto")
    void toDto() {
        Profile profile = new Profile();
        profile.setId(1L);
        profile.setPhoneNumber(1234567890L);
        profile.setEmail("setEmail");
        profile.setNameOnCard("setNameOnCard");
        profile.setInn(1234L);
        profile.setSnils(5678L);

        ProfileDto profileDto = profileMapper.toDto(profile);

        Assertions.assertEquals(profile.getId(), profileDto.getId());
        Assertions.assertEquals(profile.getPhoneNumber(), profileDto.getPhoneNumber());
        Assertions.assertEquals(profile.getEmail(), profileDto.getEmail());
        Assertions.assertEquals(profile.getNameOnCard(), profileDto.getNameOnCard());
        Assertions.assertEquals(profile.getInn(), profileDto.getInn());
        Assertions.assertEquals(profile.getSnils(), profileDto.getSnils());

    }

    @Test
    @DisplayName("Mapping ProfileDto to Profile")
    void toEntity() {
        ProfileDto profileDto = new ProfileDto();
        profileDto.setId(1L);
        profileDto.setPhoneNumber(1234567890L);
        profileDto.setEmail("setEmail");
        profileDto.setNameOnCard("setNameOnCard");
        profileDto.setInn(1234L);
        profileDto.setSnils(5678L);

        Profile profile = profileMapper.toEntity(profileDto);

        Assertions.assertEquals(profileDto.getId(), profile.getId());
        Assertions.assertEquals(profileDto.getPhoneNumber(), profile.getPhoneNumber());
        Assertions.assertEquals(profileDto.getEmail(), profile.getEmail());
        Assertions.assertEquals(profileDto.getNameOnCard(), profile.getNameOnCard());
        Assertions.assertEquals(profileDto.getInn(), profile.getInn());
        Assertions.assertEquals(profileDto.getSnils(), profile.getSnils());


        }
}