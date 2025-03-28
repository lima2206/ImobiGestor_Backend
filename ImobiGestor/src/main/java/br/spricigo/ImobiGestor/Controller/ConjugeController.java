package br.spricigo.ImobiGestor.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.spricigo.ImobiGestor.DTO.ConjugeUpdateDTO;
import br.spricigo.ImobiGestor.Entity.Conjuge;
import br.spricigo.ImobiGestor.Interface.InterConjugeService;
import br.spricigo.ImobiGestor.Service.ConjugeService;

@RestController
@CrossOrigin
@RequestMapping(value = "/conjuge")
public class ConjugeController implements InterConjugeService {
  
  @Autowired
  private ConjugeService conjugeService;
  
  @Override
  @DeleteMapping("/{id}")
  public void apagarConjugePorId(@PathVariable("id") Long id) {
    conjugeService.apagarConjugePorId(id);
  }

  @Override
  @PatchMapping("/{id}")
  public Conjuge atualizarConjuge(
      @PathVariable("id") Long id,
      @RequestBody ConjugeUpdateDTO novoConjuge) {
    return conjugeService.atualizarConjuge(id, novoConjuge);
  }

  @Override
  @GetMapping("/{id}")
  public Conjuge buscarPorId(@PathVariable("id") Long id) {
    return conjugeService.buscarPorId(id);
  }

  @Override
  @GetMapping
  public List<Conjuge> buscarTodos() {
    return conjugeService.buscarTodos();
  }

  @Override
  @PostMapping
  public Conjuge criarConjuge(@RequestBody Conjuge conjuge) {
    return conjugeService.criarConjuge(conjuge);
  }


}
