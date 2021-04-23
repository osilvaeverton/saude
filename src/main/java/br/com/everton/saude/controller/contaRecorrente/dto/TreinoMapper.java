package br.com.everton.saude.controller.contaRecorrente.dto;

import br.com.everton.saude.controller.contaRecorrente.dto.request.TreinoCreateRequestDTO;
import br.com.everton.saude.controller.contaRecorrente.dto.request.TreinoReplaceRequestDTO;
import br.com.everton.saude.controller.contaRecorrente.dto.request.TreinoUpdateRequestDTO;
import br.com.everton.saude.controller.contaRecorrente.dto.response.TreinoCreateResponseDTO;
import br.com.everton.saude.controller.contaRecorrente.dto.response.TreinoReplaceResponseDTO;
import br.com.everton.saude.controller.contaRecorrente.dto.response.TreinoResponseDTO;
import br.com.everton.saude.controller.contaRecorrente.dto.response.TreinoUpdateResponseDTO;
import br.com.everton.saude.model.treino.Treino;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TreinoMapper {

    Treino toTreino(TreinoCreateRequestDTO treinoCreateRequestDTO);
    Treino toTreino(TreinoReplaceRequestDTO treinoReplaceRequestDTO);
    Treino toTreino(TreinoUpdateRequestDTO treinoUpdateRequestDTO);

    TreinoResponseDTO toTreinoRespondeDTO(Treino treino);
    TreinoCreateResponseDTO toTreinoCreateResponseDTO(Treino treino);
    TreinoReplaceResponseDTO toTreinoReplaceResponseDTO(Treino treino);
    TreinoUpdateResponseDTO toTreinoUpdateRequestDTO(Treino treino);
}
