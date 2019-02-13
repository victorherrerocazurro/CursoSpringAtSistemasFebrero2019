package com.curso.spring.homamundo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HolaMundoController {

    @RequestMapping("/")
    PersonaDto getMessage() {
        return new PersonaDto(1, "Victor");
    }
}
