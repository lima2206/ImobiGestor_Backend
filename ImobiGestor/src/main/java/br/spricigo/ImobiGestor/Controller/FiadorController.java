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

import br.spricigo.ImobiGestor.DTO.FiadorUpdateDTO;
import br.spricigo.ImobiGestor.Entity.Fiador;
import br.spricigo.ImobiGestor.Interface.InterFiadorService;
import br.spricigo.ImobiGestor.Service.FiadorService;


@RestController
@CrossOrigin
@RequestMapping(value = "/fiador")
public class FiadorController implements InterFiadorService{

  @Autowired
  private FiadorService fiadorService;
  
  @Override
  @DeleteMapping("/{id}")
  public void apagarFiadorPorId(@PathVariable("id") Long id) {
    fiadorService.apagarFiadorPorId(id);
  }

  @Override
  @PatchMapping("/{id}")
  public Fiador atualizarFiador(
      @PathVariable("id") Long id,
      @RequestBody FiadorUpdateDTO novoFiador) {
    return fiadorService.atualizarFiador(id, novoFiador);
  }

  @Override
  @GetMapping("/{id}")
  public Fiador buscarPorId(@PathVariable("id") Long id) {
    return fiadorService.buscarPorId(id);
  }

  @Override
  @GetMapping
  public List<Fiador> buscarTodos() {
    return fiadorService.buscarTodos();
  }

  @Override
  @PostMapping
  public Fiador criarFiador(@RequestBody Fiador fiador) {
    return fiadorService.criarFiador(fiador);
  }





}
