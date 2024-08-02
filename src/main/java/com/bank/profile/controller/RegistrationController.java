package com.bank.profile.controller;


import com.bank.profile.dto.RegistrationDto;
import com.bank.profile.service.RegistrationService;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@RestController
@Tag(name = "registrations", description = "registrations API")
@RequestMapping("/registrations")
public class RegistrationController {
    private final RegistrationService registrationService;
    private static final Logger logger = LoggerFactory.getLogger(RegistrationController.class);

    @Autowired
    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @Operation(summary = "View a list of all registrations")
    @GetMapping
    public List<RegistrationDto> getAllRegistrations() {
        logger.info("Received request to get all registrations");
        return registrationService.getAllRegistrations();
    }

    @Operation(summary = "View a registration by ID")
    @GetMapping("/{id}")
    public RegistrationDto getRegistrationById(@PathVariable Long id) {
        logger.info("Received request to get registration with id {}", id);
        return registrationService.getRegistrationById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Create a new registration")
    public void createRegistration(@RequestBody RegistrationDto registrationDto) {
        logger.info("Received request to create a new registration");
        registrationService.createRegistration(registrationDto);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update a registration by ID")
    public void updateRegistration(@PathVariable Long id, @RequestBody RegistrationDto registrationDto) {
        logger.info("Received request to update registration with id {}", id);
        registrationService.updateRegistration(id, registrationDto);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a registration by ID")
    public void deleteRegistration(@PathVariable Long id) {
        logger.info("Received request to delete registration with id {}", id);
        registrationService.deleteRegistration(id);
    }
}