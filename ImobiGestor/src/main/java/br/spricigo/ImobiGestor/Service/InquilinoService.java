package br.spricigo.ImobiGestor.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.spricigo.ImobiGestor.DTO.InquilinoUpdateDTO;
import br.spricigo.ImobiGestor.Entity.Inquilino;
import br.spricigo.ImobiGestor.Interface.InterInquilinoService;
import br.spricigo.ImobiGestor.Repository.InquilinoRepository;
import jakarta.transaction.Transactional;

@Service
public class InquilinoService implements InterInquilinoService {

  @Autowired
  private InquilinoRepository inquilinoRepository;

  @Override
  @Transactional
  public void apagarInquilinoPorId(Long id) {
    if (inquilinoRepository.existsById(id)) {
      inquilinoRepository.deleteById(id);
    } else {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "O Id " + id + " é inválido! Proprietário não existe!");
    }
  }

  @Override
  @Transactional
  public Inquilino atualizarInquilino(Long id, InquilinoUpdateDTO novoInquilino) {
    if (inquilinoRepository.existsById(id)) {
      Inquilino inquilino = this.buscarPorId(id);

      // Checagem do Update para garantir que se possa atualizar valores individuais
      if (novoInquilino.getComprovanteRendaPath() != null) {
        inquilino.setComprovanteRendaPath(novoInquilino.getComprovanteRendaPath());
      }
      if (novoInquilino.getDocumentoPDFPath() != null) {
        inquilino.setDocumentoPDFPath(novoInquilino.getDocumentoPDFPath());
      }
      if (novoInquilino.getEmail() != null) {
        inquilino.setEmail(novoInquilino.getEmail());
      }
      if (novoInquilino.getEndereco() != null) {
        inquilino.setEndereco(novoInquilino.getEndereco());
      }
      if (novoInquilino.getEstadoCivil() != null) {
        inquilino.setEstadoCivil(novoInquilino.getEstadoCivil());
      }
      if (novoInquilino.getNome() != null) {
        inquilino.setNome(novoInquilino.getNome());
      }
      if (novoInquilino.getProfissao() != null) {
        inquilino.setProfissao(novoInquilino.getProfissao());
      }
      if (novoInquilino.getTelefone() != null) {
        inquilino.setTelefone(novoInquilino.getTelefone());
      }
      return inquilinoRepository.save(inquilino);
    }
    throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "O Id " + id + " é inválido! Inquilino não existe.");
  }

  @Override
  public Inquilino buscarPorId(Long id) {
    Optional<Inquilino> inquilinoOp = inquilinoRepository.findById(id);
    if (inquilinoOp.isPresent()) {
      return inquilinoOp.get();
    }
    throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "O Id " + id + " é inválido ou não foi encontrado!");
  }

  @Override
  public List<Inquilino> buscarTodos() {
    return inquilinoRepository.findAll();
  }

  @Override
  @Transactional
  public Inquilino criarInquilino(Inquilino inquilino) {
    if (inquilino == null ||
        inquilino.getComprovanteRendaPath() == null ||
        inquilino.getDocumentoPDFPath() == null ||
        inquilino.getEmail() == null ||
        inquilino.getEndereco() == null ||
        inquilino.getEstadoCivil() == null ||
        inquilino.getNome() == null ||
        inquilino.getProfissao() == null ||
        inquilino.getTelefone() == null) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Dados Inválidos ou insuficiêntes!");
    }
    return inquilinoRepository.save(inquilino);
  }

}
