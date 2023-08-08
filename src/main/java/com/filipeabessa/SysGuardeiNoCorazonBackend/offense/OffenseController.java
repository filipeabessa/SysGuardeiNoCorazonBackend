package com.filipeabessa.SysGuardeiNoCorazonBackend.offense;

import com.filipeabessa.SysGuardeiNoCorazonBackend.common.exceptions.NotFoundException;
import com.filipeabessa.SysGuardeiNoCorazonBackend.offense.dtos.CreateOffenseDto;
import com.filipeabessa.SysGuardeiNoCorazonBackend.offense.dtos.ReadAllOffensesDto;
import com.filipeabessa.SysGuardeiNoCorazonBackend.offense.dtos.UpdateOffenseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/offenses")
public class OffenseController {
    private final OffenseService offenseService;
    OffenseController(OffenseService offenseService) {
        this.offenseService = offenseService;
    }

    @PostMapping()
    public ResponseEntity<OffenseEntity> create(@RequestBody CreateOffenseDto createOffenseDto) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(offenseService.create(createOffenseDto));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping("/{offenseId}")
    public ResponseEntity<OffenseEntity> read(@PathVariable long offenseId) {
        try {
            return ResponseEntity.ok(offenseService.findById(offenseId));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping()
    public ResponseEntity<ReadAllOffensesDto> readAll() {
        try {
            return ResponseEntity.ok(offenseService.findAll());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @PatchMapping("/{offenseId}")
    public ResponseEntity<Object> update(@PathVariable long offenseId, @RequestBody UpdateOffenseDto updateOffenseDto) {
        try {
            return ResponseEntity.ok(offenseService.update(offenseId, updateOffenseDto));
        } catch (Exception e) {
            if (e instanceof NotFoundException) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
            }

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @DeleteMapping("/{offenseId}")
    public ResponseEntity<Void> delete(@PathVariable Long offenseId) {
        try {
            offenseService.delete(offenseId);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}