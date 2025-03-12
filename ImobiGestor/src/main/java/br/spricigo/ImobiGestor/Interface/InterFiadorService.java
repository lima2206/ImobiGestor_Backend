package br.spricigo.ImobiGestor.Interface;

import java.util.List;

import br.spricigo.ImobiGestor.DTO.FiadorUpdateDTO;
import br.spricigo.ImobiGestor.Entity.Fiador;

public interface InterFiadorService {

  public Fiador buscarPorId(Long id);

  public List<Fiador> buscarTodos();

  public Fiador criarFiador(Fiador fiador);

  public void apagarFiadorPorId(Long id);

  public Fiador atualizarFiador(Long id, FiadorUpdateDTO novoFiador);

}
