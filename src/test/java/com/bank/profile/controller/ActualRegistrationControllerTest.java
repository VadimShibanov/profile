package com.bank.profile.controller;


import com.bank.profile.dto.ActualRegistrationDTO;
import com.bank.profile.service.ActualRegistrationService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


import java.util.Arrays;
import java.util.List;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class ActualRegistrationControllerTest {


    @Mock
    private ActualRegistrationService service;

    @InjectMocks
    private ActualRegistrationController controller;

    @Test
    public void testFindAll() {
        ActualRegistrationDTO dto1 = new ActualRegistrationDTO();
        dto1.setId(1L);
        ActualRegistrationDTO dto2 = new ActualRegistrationDTO();
        dto2.setId(2L);
        List<ActualRegistrationDTO> dtos = Arrays.asList(dto1, dto2);
        when(service.getAllActualRegistration()).thenReturn(dtos);

        ResponseEntity<List<ActualRegistrationDTO>> response = controller.getAllActualRegistration();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(dtos, response.getBody());
    }

}

