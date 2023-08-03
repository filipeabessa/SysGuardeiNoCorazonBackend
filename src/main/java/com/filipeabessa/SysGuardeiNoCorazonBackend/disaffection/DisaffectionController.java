package com.filipeabessa.SysGuardeiNoCorazonBackend.disaffection;

import com.filipeabessa.SysGuardeiNoCorazonBackend.common.exceptions.NotFoundException;
import com.filipeabessa.SysGuardeiNoCorazonBackend.disaffection.dtos.CreateDisaffectionDto;
import com.filipeabessa.SysGuardeiNoCorazonBackend.disaffection.dtos.ReadAllDisaffectionsDto;
import com.filipeabessa.SysGuardeiNoCorazonBackend.disaffection.dtos.UpdateDisaffectionDto;
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
@RequestMapping("/disaffection")
public class DisaffectionController {
    private DisaffectionService disaffectionService;

    public DisaffectionController(DisaffectionService disaffectionService) {
        this.disaffectionService = disaffectionService;
    }

    @PostMapping("")
    public ResponseEntity<DisaffectionEntity> create(@RequestBody CreateDisaffectionDto createDisaffectionDto) {
        try {
            return ResponseEntity.ok(disaffectionService.create(createDisaffectionDto));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping("/{disaffectionId}")
    public ResponseEntity<DisaffectionEntity> read(@PathVariable long disaffectionId) {
        try {
            return ResponseEntity.ok(disaffectionService.findById(disaffectionId));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
    @GetMapping()
    public ResponseEntity<ReadAllDisaffectionsDto> readAll() {
        try {
            return ResponseEntity.ok(disaffectionService.findAll());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @PatchMapping("/{disaffectionId}")
    public ResponseEntity<Object> update(@PathVariable long disaffectionId, @RequestBody UpdateDisaffectionDto updateDisaffectionDto) {
        try {
            return ResponseEntity.ok(disaffectionService.update(disaffectionId, updateDisaffectionDto));
        } catch (Exception e) {
            if (e instanceof NotFoundException) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
            }

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @DeleteMapping("/{disaffectionId}")
    public ResponseEntity<Void> delete(@PathVariable Long disaffectionId) {
        try {
            disaffectionService.delete(disaffectionId);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

}
