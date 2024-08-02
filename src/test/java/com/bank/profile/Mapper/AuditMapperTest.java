package com.bank.profile.Mapper;

import com.bank.profile.dto.AuditDto;
import com.bank.profile.entity.AuditEntity;

import com.bank.profile.mapper.AuditMapper;
import com.bank.profile.mapper.AuditMapperImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Timestamp;
import java.time.Instant;

public class AuditMapperTest {

    private AuditMapper auditMapper;

    @BeforeEach
    public void setUp() {
        auditMapper = new AuditMapperImpl();
    }

    @Test
    public void testToDto() {

        AuditEntity entity = new AuditEntity();
        entity.setId(1L);
        entity.setEntityType("setEntityType");
        entity.setOperationType("setOperationType");
        entity.setCreatedBy("setCreatedBy");
        entity.setModifiedBy("setModifiedBy");
        Timestamp timestamp = Timestamp.from(Instant.now());



        AuditDto dto = auditMapper.toDto(entity);

        Assertions.assertEquals(dto.getId(), entity.getId());
        Assertions.assertEquals(dto.getEntityType(), entity.getEntityType());
        Assertions.assertEquals(dto.getOperationType(), entity.getOperationType());
        Assertions.assertEquals(dto.getCreatedBy(), entity.getCreatedBy());
        Assertions.assertEquals(dto.getModifiedBy(), entity.getModifiedBy());
        Assertions.assertEquals(dto.getCreatedAt(), entity.getCreatedAt());
        Assertions.assertEquals(dto.getModifiedAt(), entity.getModifiedAt());
        Assertions.assertEquals(dto.getNewEntityJson(), entity.getNewEntityJson());
        Assertions.assertEquals(dto.getEntityJson(), entity.getEntityJson());
    }

    @Test
    public void testToEntity() {

        AuditDto dto = new AuditDto();
        dto.setId(1L);
        dto.setEntityType("setEntityType");
        dto.setOperationType("setOperationType");
        dto.setCreatedBy("setCreatedBy");
        dto.setModifiedBy("setModifiedBy");
        Timestamp timestamp = Timestamp.from(Instant.now());


        AuditEntity entity = auditMapper.toEntity(dto);

        Assertions.assertEquals(dto.getId(), entity.getId());
        Assertions.assertEquals(dto.getEntityType(), entity.getEntityType());
        Assertions.assertEquals(dto.getOperationType(), entity.getOperationType());
        Assertions.assertEquals(dto.getCreatedBy(), entity.getCreatedBy());
        Assertions.assertEquals(dto.getModifiedBy(), entity.getModifiedBy());
        Assertions.assertEquals(dto.getCreatedAt(), entity.getCreatedAt());
        Assertions.assertEquals(dto.getModifiedAt(), entity.getModifiedAt());
        Assertions.assertEquals(dto.getNewEntityJson(), entity.getNewEntityJson());
        Assertions.assertEquals(dto.getEntityJson(), entity.getEntityJson());
    }

}