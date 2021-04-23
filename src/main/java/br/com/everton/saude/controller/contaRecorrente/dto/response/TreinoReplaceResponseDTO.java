package br.com.everton.saude.controller.contaRecorrente.dto.response;

import br.com.everton.saude.model.treino.TipoDeTreino;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TreinoReplaceResponseDTO {

    private Long id;
    private TipoDeTreino tipo;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime data;
    private double distancia;
    private double tempo;

}
