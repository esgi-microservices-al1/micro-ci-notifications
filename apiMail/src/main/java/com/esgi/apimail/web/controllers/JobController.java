package com.esgi.apimail.web.controllers;

import com.esgi.apimail.domain.models.Message;
import com.esgi.apimail.domain.sendmail.MailService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/job")
public class JobController {
    private final MailService mailService;

    public JobController(MailService mailService) {
        this.mailService = mailService;
    }

    @PostMapping
    ResponseEntity<?> postMessage(@RequestBody @Valid Message message){
        boolean result = mailService.transfertMessage(message);

        if(result)
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .build();
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .build();
    }
}
