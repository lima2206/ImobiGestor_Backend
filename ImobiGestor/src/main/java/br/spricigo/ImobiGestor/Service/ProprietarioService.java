package br.spricigo.ImobiGestor.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.spricigo.ImobiGestor.DTO.ProprietarioUpdateDTO;
import br.spricigo.ImobiGestor.Entity.Proprietario;
import br.spricigo.ImobiGestor.Interface.InterProprietarioService;
import br.spricigo.ImobiGestor.Repository.ProprietarioRepository;
import jakarta.transaction.Transactional;

@Service
public class ProprietarioService implements InterProprietarioService {

  @Autowired
  private ProprietarioRepository proprietarioRepository;

  @Override
  public Proprietario buscarPorId(Long id) {
    Optional<Proprietario> proprietarioOp = proprietarioRepository.findById(id);
    if (proprietarioOp.isPresent()) {
      return proprietarioOp.get();
    }
    throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "O Id " + id +" é inválido ou não foi encontrado!");
  }

  @Override
  public List<Proprietario> buscarTodos() {
    return proprietarioRepository.findAll();
  }

  @Transactional
  @Override
  public Proprietario criarProprietario(Proprietario proprietario) {

    if (proprietario == null ||
        proprietario.getNome() == null ||
        proprietario.getEstadoCivil() == null ||
        proprietario.getProfissao() == null ||
        proprietario.getRg() == null ||
        proprietario.getCpf() == null ||
        proprietario.getEndereco() == null ||
        proprietario.getTelefone() == null ||
        proprietario.getEmail() == null) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Dados Inválidos ou insuficiêntes!");
    }
    return proprietarioRepository.save(proprietario);
  }

  @Transactional
  @Override
  public void apagarProprietarioPorId(Long id) {
    if (proprietarioRepository.existsById(id)) {
      proprietarioRepository.deleteById(id);
    } else {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
          "O Id " + id + " é inválido! Proprietário não existe.");
    }
  }

  @Transactional
  @Override
  public Proprietario atualizarProprietario(Long id, ProprietarioUpdateDTO novoProprietario) {
    if (proprietarioRepository.existsById(id)) {
      Proprietario proprietario = this.buscarPorId(id);

      // Checagem do Update para garantir que se possa atualizar valores individuais
      if (novoProprietario.getNome() != null) {
        proprietario.setNome(novoProprietario.getNome());
      }
      if (novoProprietario.getEstadoCivil() != null) {
        proprietario.setEstadoCivil(novoProprietario.getEstadoCivil());
      }
      if (novoProprietario.getProfissao() != null) {
        proprietario.setProfissao(novoProprietario.getProfissao());
      }
      if (novoProprietario.getRg() != null) {
        proprietario.setRg(novoProprietario.getRg());
      }
      if (novoProprietario.getCpf() != null) {
        proprietario.setCpf(novoProprietario.getCpf());
      }
      if (novoProprietario.getEndereco() != null) {
        proprietario.setEndereco(novoProprietario.getEndereco());
      }
      if (novoProprietario.getTelefone() != null) {
        proprietario.setTelefone(novoProprietario.getTelefone());
      }
      if (novoProprietario.getEmail() != null) {
        proprietario.setEmail(novoProprietario.getEmail());
      }

      return proprietarioRepository.save(proprietario);

    } else {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
          "O Id " + id + " é inválido! Proprietário não existe.");
    }
  }

}
