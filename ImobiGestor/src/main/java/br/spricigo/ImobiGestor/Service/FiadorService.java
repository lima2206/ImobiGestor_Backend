package br.spricigo.ImobiGestor.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.spricigo.ImobiGestor.DTO.FiadorUpdateDTO;
import br.spricigo.ImobiGestor.Entity.Fiador;
import br.spricigo.ImobiGestor.Interface.InterFiadorService;
import br.spricigo.ImobiGestor.Repository.FiadorRepository;
import jakarta.transaction.Transactional;

@Service
public class FiadorService implements InterFiadorService {

  @Autowired
  private FiadorRepository fiadorRepository;

  @Override
  @Transactional
  public void apagarFiadorPorId(Long id) {
    if (fiadorRepository.existsById(id)) {
      fiadorRepository.deleteById(id);
    } else {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "O Id " + id + " é inválido! Fiador não existe!");
    }
  }

  @Override
  @Transactional
  public Fiador atualizarFiador(Long id, FiadorUpdateDTO novoFiador) {
    if (fiadorRepository.existsById(id)) {
      Fiador fiador = this.buscarPorId(id);

      // Checagem do Update para garantir que se possa atualizar valores individuais
      if (novoFiador.getComprovanteRendaPath() != null) {
        fiador.setComprovanteRendaPath(novoFiador.getComprovanteRendaPath());
      }
      if (novoFiador.getCertidaoImovelPath() != null) {
        fiador.setCertidaoImovelPath(novoFiador.getCertidaoImovelPath());
      }
      if (novoFiador.getDocumentoPDFPath() != null) {
        fiador.setDocumentoPDFPath(novoFiador.getDocumentoPDFPath());
      }
      if (novoFiador.getEmail() != null) {
        fiador.setEmail(novoFiador.getEmail());
      }
      if (novoFiador.getEndereco() != null) {
        fiador.setEndereco(novoFiador.getEndereco());
      }
      if (novoFiador.getEstadoCivil() != null) {
        fiador.setEstadoCivil(novoFiador.getEstadoCivil());
      }
      if (novoFiador.getNome() != null) {
        fiador.setNome(novoFiador.getNome());
      }
      if (novoFiador.getProfissao() != null) {
        fiador.setProfissao(novoFiador.getProfissao());
      }
      if (novoFiador.getTelefone() != null) {
        fiador.setTelefone(novoFiador.getTelefone());
      }
      return fiadorRepository.save(fiador);
    }
    throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "O Id " + id + " é inválido! Fiador não existe.");
  }

  @Override
  public Fiador buscarPorId(Long id) {
    Optional<Fiador> fiadorOp = fiadorRepository.findById(id);
    if (fiadorOp.isPresent()) {
      return fiadorOp.get();
    }
    throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "O Id " + id + " é inválido ou não foi encontrado!");
  }

  @Override
  public List<Fiador> buscarTodos() {
    return fiadorRepository.findAll();
  }

  @Override
  @Transactional
  public Fiador criarFiador(Fiador fiador) {
    if (fiador == null ||
        fiador.getComprovanteRendaPath() == null ||
        fiador.getCertidaoImovelPath() == null ||
        fiador.getDocumentoPDFPath() == null ||
        fiador.getEmail() == null ||
        fiador.getEndereco() == null ||
        fiador.getEstadoCivil() == null ||
        fiador.getNome() == null ||
        fiador.getProfissao() == null ||
        fiador.getTelefone() == null) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Dados Inválidos ou insuficiêntes!");
    }
    return fiadorRepository.save(fiador);
  }

}
