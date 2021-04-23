package br.com.everton.saude.controller;

import br.com.everton.saude.controller.contaRecorrente.dto.TreinoMapper;
import br.com.everton.saude.controller.contaRecorrente.dto.request.TreinoCreateRequestDTO;
import br.com.everton.saude.controller.contaRecorrente.dto.request.TreinoReplaceRequestDTO;
import br.com.everton.saude.controller.contaRecorrente.dto.request.TreinoUpdateRequestDTO;
import br.com.everton.saude.controller.contaRecorrente.dto.response.TreinoCreateResponseDTO;
import br.com.everton.saude.controller.contaRecorrente.dto.response.TreinoReplaceResponseDTO;
import br.com.everton.saude.controller.contaRecorrente.dto.response.TreinoResponseDTO;
import br.com.everton.saude.controller.contaRecorrente.dto.response.TreinoUpdateResponseDTO;
import br.com.everton.saude.model.treino.Treino;
import br.com.everton.saude.repository.TreinoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

@RequestMapping("/treino")
@RestController
public class TreinoController {

    @Autowired
    TreinoRepository treinoRepository;

    @Autowired
    TreinoMapper mapper;

    @GetMapping
    public List<TreinoResponseDTO> list(){
        return this.treinoRepository.findAll().stream()
                .map(mapper::toTreinoRespondeDTO)
                .collect(Collectors.toList());
    }

    @GetMapping(path = "/{id}")
    public TreinoResponseDTO findById(@PathVariable Long id){
        return this.treinoRepository.findById(id)
                .map(mapper::toTreinoRespondeDTO)
                .orElse(null);
    }

    @PostMapping
    public TreinoCreateResponseDTO create(@RequestBody TreinoCreateRequestDTO treinoCreateRequestDTO){
        Treino treino = this.treinoRepository.save(mapper.toTreino(treinoCreateRequestDTO));
        return mapper.toTreinoCreateResponseDTO(treino);
    }

    @PutMapping(path = "/{id}")
    public TreinoReplaceResponseDTO replace(@PathVariable Long id, @RequestBody TreinoReplaceRequestDTO treinoReplaceRequestDTO){
        Optional<Treino> optionalTreino = this.treinoRepository.findById(id);

        if(optionalTreino.isPresent()){
            Treino treino = mapper.toTreino(treinoReplaceRequestDTO);
            return mapper.toTreinoReplaceResponseDTO(this.treinoRepository.save(treino));
        } else {
            return null;
        }
    }

    @PatchMapping(path = "/{id}")
    public TreinoUpdateResponseDTO update(@PathVariable Long id, @RequestBody TreinoUpdateRequestDTO treinoUpdateRequestDTO){
        Optional<Treino> optionalTreino = this.treinoRepository.findById(id);

        if(optionalTreino.isPresent()){
            Treino treino = mapper.toTreino(treinoUpdateRequestDTO);
            return mapper.toTreinoUpdateRequestDTO(treino);
        } else
            return null;

    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id){
        this.treinoRepository.deleteById(id);
    }
}
