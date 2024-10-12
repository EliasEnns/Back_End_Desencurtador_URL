package com.desencurtador.desencurtador.Controllers;
import com.desencurtador.desencurtador.Services.DesencurtadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class DesencurtadorController {

    @Autowired
    private DesencurtadorService Desencurtador;

    @GetMapping("/sobre")
    public ResponseEntity<Map<String, String>> sobre() {
        Map<String, String> response = new HashMap<>();
        response.put("estudante", "Elias Enns e Michel Almeida da Rosa");
        response.put("projeto", "Desencurtador de Links");
        return ResponseEntity.ok(response);
    }

    @PostMapping("/desencurtar")
    public ResponseEntity<String> desencurtar(@RequestBody Map<String, String> request) {
        String shortUrl = request.get("shortUrl");
        Desencurtador.setShortUrl(shortUrl);
        String longUrl = Desencurtador.getLongUrl();
        return ResponseEntity.ok(longUrl);
    }

    @GetMapping("/consulta")
    public ResponseEntity<List<String>> consulta() {
        List<String> links = Desencurtador.getAllLinks();
        return ResponseEntity.ok(links);
    }
}
