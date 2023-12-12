package com.example.capstone.Controller;

import com.example.capstone.Model.Certificate;
import com.example.capstone.Model.Language;
import com.example.capstone.Service.CertificateService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/v1/Certificate")
@RequiredArgsConstructor
public class CertificateController {
    private final CertificateService certificateService;
    Logger logger= LoggerFactory.getLogger(Certificate.class);
    @GetMapping("/getCertificate")
    public ResponseEntity getCertificate(){
        logger.info("you are in get Certificate Controller");
        return ResponseEntity.status(HttpStatus.OK).body(certificateService.getCertificate());
    }
    @PostMapping("/addCertificate")
    public ResponseEntity addCertificate(@RequestBody @Valid Certificate certificate){
        logger.info("you are in add Certificate Controller");

        certificateService.addCertificate(certificate);
        return ResponseEntity.status(HttpStatus.OK).body("Certificate add");
    }
    @PutMapping("/updateCertificate/{id}")
    public ResponseEntity updateCertificate(@PathVariable Integer id,@RequestBody@Valid Certificate certificate){
        logger.info("you are in update Certificate Controller");
        certificateService.updateCertificate(id, certificate);
        return ResponseEntity.status(HttpStatus.OK).body("Certificate updated");
    }
    @DeleteMapping("/deleteCertificate/{id}")
    public ResponseEntity deleteCertificate(@PathVariable Integer id){
        logger.info("you are in delete Certificate Controller");
        certificateService.delteCertificate(id);
        return ResponseEntity.status(HttpStatus.OK).body("Certificate deleted");
    }
    @GetMapping("/getDate/{start}/{end}")
    public ResponseEntity getDate(@PathVariable LocalDate start,@PathVariable LocalDate end){
        logger.info("you are in get Certificate by specific date range Controller");
        return ResponseEntity.status(HttpStatus.OK).body(certificateService.getDate(start, end));
    }
    @GetMapping("/name/{name}")
    public ResponseEntity getByname(@PathVariable String name){
        logger.info("you are in get Certificate by name Controller");
        return ResponseEntity.status(HttpStatus.OK).body(certificateService.getByName(name));
    }
}
