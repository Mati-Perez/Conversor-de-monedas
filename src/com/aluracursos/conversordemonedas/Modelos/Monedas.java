package com.aluracursos.conversordemonedas.Modelos;

public record Monedas(String base_code,
                      String target_code,
                      double conversion_rate) {
}
