package br.spricigo.ImobiGestor.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.spricigo.ImobiGestor.DTO.ConjugeUpdateDTO;
import br.spricigo.ImobiGestor.Entity.Conjuge;
import br.spricigo.ImobiGestor.Interface.InterConjugeService;
import br.spricigo.ImobiGestor.Repository.ConjugeRepository;
import jakarta.transaction.Transactional;

@Service
public class ConjugeService implements InterConjugeService {

  @Autowired
  private ConjugeRepository conjugeRepository;

  @Override
  @Transactional
  public void apagarConjugePorId(Long id) {
    if (conjugeRepository.existsById(id)) {
      conjugeRepository.deleteById(id);
    } else {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "O Id " + id + " é inválido! Conjuge não existe!");
    }
  }

  @Override
  @Transactional
  public Conjuge atualizarConjuge(Long id, ConjugeUpdateDTO novoConjuge) {
    if (conjugeRepository.existsById(id)) {
      Conjuge conjuge = this.buscarPorId(id);

      // Checagem do Update para garantir que se possa atualizar valores individuais
      if (novoConjuge.getComprovanteRendaPath() != null) {
        conjuge.setComprovanteRendaPath(novoConjuge.getComprovanteRendaPath());
      }
      if (novoConjuge.getCertidaoImovelPath() != null) {
        conjuge.setCertidaoImovelPath(novoConjuge.getCertidaoImovelPath());
      }
      if (novoConjuge.getDocumentoPDFPath() != null) {
        conjuge.setDocumentoPDFPath(novoConjuge.getDocumentoPDFPath());
      }
      if (novoConjuge.getEmail() != null) {
        conjuge.setEmail(novoConjuge.getEmail());
      }
      if (novoConjuge.getEndereco() != null) {
        conjuge.setEndereco(novoConjuge.getEndereco());
      }
      if (novoConjuge.getEstadoCivil() != null) {
        conjuge.setEstadoCivil(novoConjuge.getEstadoCivil());
      }
      if (novoConjuge.getNome() != null) {
        conjuge.setNome(novoConjuge.getNome());
      }
      if (novoConjuge.getProfissao() != null) {
        conjuge.setProfissao(novoConjuge.getProfissao());
      }
      if (novoConjuge.getTelefone() != null) {
        conjuge.setTelefone(novoConjuge.getTelefone());
      }
      return conjugeRepository.save(conjuge);
    }
    throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "O Id " + id + " é inválido! Conjuge não existe.");
  }

  @Override
  public Conjuge buscarPorId(Long id) {
    Optional<Conjuge> conjugeOp = conjugeRepository.findById(id);
    if (conjugeOp.isPresent()) {
      return conjugeOp.get();
    }
    
    throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "O Id " + id + " é inválido ou não foi encontrado!");
  }

  @Override
  public List<Conjuge> buscarTodos() {
    return conjugeRepository.findAll();
  }

  @Override
  @Transactional
  public Conjuge criarConjuge(Conjuge conjuge) {
    if (conjuge == null ||
        conjuge.getComprovanteRendaPath() == null ||
        conjuge.getCertidaoImovelPath() == null ||
        conjuge.getDocumentoPDFPath() == null ||
        conjuge.getEmail() == null ||
        conjuge.getEndereco() == null ||
        conjuge.getEstadoCivil() == null ||
        conjuge.getNome() == null ||
        conjuge.getProfissao() == null ||
        conjuge.getTelefone() == null) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Dados Inválidos ou insuficiêntes!");
    }
    return conjugeRepository.save(conjuge);
  }
}
