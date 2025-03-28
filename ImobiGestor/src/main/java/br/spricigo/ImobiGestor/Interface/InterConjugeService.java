package br.spricigo.ImobiGestor.Interface;

import java.util.List;

import br.spricigo.ImobiGestor.DTO.ConjugeUpdateDTO;
import br.spricigo.ImobiGestor.Entity.Conjuge;

public interface InterConjugeService {
  public Conjuge buscarPorId(Long id);

  public List<Conjuge> buscarTodos();

  public Conjuge criarConjuge(Conjuge Conjuge);

  public void apagarConjugePorId(Long id);

  public Conjuge atualizarConjuge(Long id, ConjugeUpdateDTO novoConjuge);

}
