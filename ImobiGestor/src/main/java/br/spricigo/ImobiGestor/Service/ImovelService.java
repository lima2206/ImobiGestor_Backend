package br.spricigo.ImobiGestor.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.spricigo.ImobiGestor.DTO.ImovelUpdateDTO;
import br.spricigo.ImobiGestor.Entity.Imovel;
import br.spricigo.ImobiGestor.Interface.InterImovelService;
import br.spricigo.ImobiGestor.Repository.ImovelRepository;
import jakarta.transaction.Transactional;

@Service
public class ImovelService implements InterImovelService {

  @Autowired
  public ImovelRepository imovelRepository;

  @Override
    public Imovel buscarPorId(Long id) {
        Optional<Imovel> imovelOp = imovelRepository.findById(id);
        if (imovelOp.isPresent()){
            return imovelOp.get();
        }
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "O Id " + id +" é inválido ou não foi encontrado!");
    }

  @Override
  public List<Imovel> buscarTodos() {
    return imovelRepository.findAll();
  }

  @Transactional
  @Override
  public Imovel criarImovel(Imovel imovel) {

    if (imovel == null ||
        imovel.getEndereco() == null ||
        imovel.getDescricao() == null ||
        imovel.getIptuPDFPath() == null) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Dados Inválidos ou insuficiêntes!");
    }
    return imovelRepository.save(imovel);
  }

  @Transactional
  @Override
  public void apagarImovelPorId(Long id) {
    if(imovelRepository.existsById(id)){
      imovelRepository.deleteById(id);
    } else {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "O Id " + id + " é inválido! o Imóvel não existe.");
    }
  }

  @Transactional
  @Override
  public Imovel atualizarImovel(Long id, ImovelUpdateDTO novoImovel) {
    if(imovelRepository.existsById(id)){
      Imovel imovel = this.buscarPorId(id);

      // Checagem do Update para garantir que se possa atualizar valores individuais
      if(novoImovel.getDescricao() != null) {
        imovel.setDescricao(novoImovel.getDescricao());
      }
      if(novoImovel.getEndereco() != null) {
        imovel.setEndereco(novoImovel.getEndereco());
      }
      if(novoImovel.getIptuPDFPath() != null) {
        imovel.setIptuPDFPath(novoImovel.getIptuPDFPath());
      }

      return imovelRepository.save(imovel);

    } else {
      throw new ResponseStatusException(HttpStatus.BAD_GATEWAY,  "O Id " + id + " é inválido! Imóvel não existe.");
    }
    
  }

}
