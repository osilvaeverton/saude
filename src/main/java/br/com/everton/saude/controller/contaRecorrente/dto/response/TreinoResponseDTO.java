package br.com.everton.saude.controller.contaRecorrente.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.time.LocalDateTime;

@Data
public class TreinoResponseDTO {

    private Long id;
    private String tipo;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime data;
    private double distancia;
    private double tempo;

}
