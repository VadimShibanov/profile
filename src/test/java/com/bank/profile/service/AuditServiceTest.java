
package com.bank.profile.service;

import com.bank.profile.dto.AuditDto;
import com.bank.profile.entity.AuditEntity;
import com.bank.profile.mapper.AuditMapper;
import com.bank.profile.repository.AuditRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.openMocks;

public class AuditServiceTest {

    private AuditService auditService;

    @Mock
    private AuditRepository auditRepository;

    @Mock
    private AuditMapper auditMapper;

    @BeforeEach
    void setUp() {
        openMocks(this);
        auditService = new AuditService(auditRepository, auditMapper);
    }

    @Test
    void testGetAllAudits() {
        AuditEntity entity1 = new AuditEntity();
        entity1.setId(1L);
        entity1.setEntityJson("setEntityJson1");

        AuditEntity entity2 = new AuditEntity();
        entity2.setId(2L);
        entity2.setEntityJson("setEntityJson2");

        List<AuditEntity> entities = Arrays.asList(entity1, entity2);

        AuditDto dto1 = new AuditDto();
        dto1.setId(1L);
        dto1.setEntityJson("setEntityJson1");

        AuditDto dto2 = new AuditDto();
        dto2.setId(2L);
        dto2.setEntityJson("setEntityJson2");

        List<AuditDto> dtos = Arrays.asList(dto1, dto2);

        when(auditRepository.findAll()).thenReturn(entities);
        when(auditMapper.toDtoList(entities)).thenReturn(dtos);

        List<AuditDto> actualDtos = auditService.getAllAudits();

        assertEquals(dtos, actualDtos);
    }

    @Test
    void testGetAuditById() {
        AuditEntity entity = new AuditEntity();
        entity.setId(1L);
        entity.setEntityJson("setEntityJson1");

        AuditDto dto = new AuditDto();
        dto.setId(1L);
        dto.setEntityJson("setEntityJson1");

        when(auditRepository.findById(1L)).thenReturn(Optional.of(entity));
        when(auditMapper.toDto(entity)).thenReturn(dto);

        AuditDto actualDto = auditService.getAuditById(1L);

        assertEquals(dto, actualDto);
    }

    @Test
    void testCreateAudit() {
        AuditDto dto = new AuditDto();
        dto.setId(1L);
        dto.setEntityJson("setEntityJson1");

        AuditEntity entity = new AuditEntity();
        entity.setId(1L);
        entity.setEntityJson("setEntityJson2");

        when(auditMapper.toEntity(dto)).thenReturn(entity);
        when(auditRepository.save(entity)).thenReturn(entity);

        auditService.createAudit(dto);

        assertEquals(entity, auditRepository.save(entity));
    }
}
