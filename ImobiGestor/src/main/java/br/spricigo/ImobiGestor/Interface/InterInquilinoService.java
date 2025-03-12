package br.spricigo.ImobiGestor.Interface;

import java.util.List;

import br.spricigo.ImobiGestor.DTO.InquilinoUpdateDTO;
import br.spricigo.ImobiGestor.Entity.Inquilino;

public interface InterInquilinoService {

  public Inquilino buscarPorId(Long id);

  public List<Inquilino> buscarTodos();

  public Inquilino criarInquilino(Inquilino inquilino);

  public void apagarInquilinoPorId(Long id);

  public Inquilino atualizarInquilino(Long id, InquilinoUpdateDTO novoInquilino);

}
