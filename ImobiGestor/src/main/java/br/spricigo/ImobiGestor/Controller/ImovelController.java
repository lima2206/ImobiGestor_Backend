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

import br.spricigo.ImobiGestor.DTO.ImovelUpdateDTO;
import br.spricigo.ImobiGestor.Entity.Imovel;
import br.spricigo.ImobiGestor.Interface.InterImovelService;
import br.spricigo.ImobiGestor.Service.ImovelService;

@RestController
@CrossOrigin
@RequestMapping(value = "/imovel")
public class ImovelController implements InterImovelService {

  @Autowired
  private ImovelService imovelService;

  @Override
  @DeleteMapping("/{id}")
  public void apagarImovelPorId(@PathVariable("id") Long id) {
    imovelService.apagarImovelPorId(id);
  }

  @Override
  @PatchMapping("/{id}")
  public Imovel atualizarImovel(
      @PathVariable("id") Long id,
      @RequestBody ImovelUpdateDTO novoImovel) {

    return imovelService.atualizarImovel(id, novoImovel);
  }

  @Override
  @GetMapping("/{id}")
  public Imovel buscarPorId(@PathVariable("id") Long id) {
    return imovelService.buscarPorId(id);
  }


  @GetMapping
  public List<Imovel> buscarTodos() {
    return imovelService.buscarTodos();
  }

  @Override
  @PostMapping
  public Imovel criarImovel(@RequestBody Imovel imovel) {
    return imovelService.criarImovel(imovel);
  }

}
