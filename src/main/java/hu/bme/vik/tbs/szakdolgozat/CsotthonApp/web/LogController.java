package hu.bme.vik.tbs.szakdolgozat.CsotthonApp.web;

import hu.bme.vik.tbs.szakdolgozat.CsotthonApp.dto.LogDTO;
import hu.bme.vik.tbs.szakdolgozat.CsotthonApp.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping(value = "/logs")
public class LogController {
    @Autowired
    private LogService logService;

    @GetMapping
    public List<LogDTO> getAll() {
        return logService.getAll();
    }

    @PostMapping
    public LogDTO createLog(@RequestBody LogDTO log, Principal principal) {
        return logService.createLog(log, principal);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Integer> deleteLog(@PathVariable Integer id) {
        Boolean isRemoved = logService.delete(id);

        if (!isRemoved) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(id);
    }
}
