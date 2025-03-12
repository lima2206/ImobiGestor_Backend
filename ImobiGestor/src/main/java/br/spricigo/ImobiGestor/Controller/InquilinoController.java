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

import br.spricigo.ImobiGestor.DTO.InquilinoUpdateDTO;
import br.spricigo.ImobiGestor.Entity.Inquilino;
import br.spricigo.ImobiGestor.Interface.InterInquilinoService;
import br.spricigo.ImobiGestor.Service.InquilinoService;

@RestController
@CrossOrigin
@RequestMapping(value = "/inquilino")
public class InquilinoController implements InterInquilinoService {

  @Autowired
  private InquilinoService inquilinoService;

  @Override
  @DeleteMapping(value = "/{id}")
  public void apagarInquilinoPorId(@PathVariable("id") Long id) {
    inquilinoService.apagarInquilinoPorId(id);
  }

  @Override
  @PatchMapping("/{id}")
  public Inquilino atualizarInquilino(
      @PathVariable("id") Long id,
      @RequestBody InquilinoUpdateDTO novoInquilino) {
    return inquilinoService.atualizarInquilino(id, novoInquilino);
  }

  @Override
  @GetMapping("/{id}")
  public Inquilino buscarPorId(@PathVariable("id") Long id) {
    return inquilinoService.buscarPorId(id);
  }

  @Override
  @GetMapping
  public List<Inquilino> buscarTodos() {
    return inquilinoService.buscarTodos();
  }

  @Override
  @PostMapping
  public Inquilino criarInquilino(@RequestBody Inquilino inquilino) {
    return inquilinoService.criarInquilino(inquilino);
  }

}
