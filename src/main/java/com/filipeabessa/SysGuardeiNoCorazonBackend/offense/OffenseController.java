package com.filipeabessa.SysGuardeiNoCorazonBackend.offense;

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

    @PostMapping("/{disaffectionId}")
    public ResponseEntity<OffenseEntity> create(@PathVariable long disaffectionId, @RequestBody CreateOffenseDto createOffenseDto) {
        try {
            return ResponseEntity.ok(offenseService.create(disaffectionId, createOffenseDto));
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
    public ResponseEntity<OffenseEntity> update(@PathVariable long offenseId, @RequestBody UpdateOffenseDto updateOffenseDto) {
        return ResponseEntity.ok(offenseService.update(offenseId, updateOffenseDto));
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