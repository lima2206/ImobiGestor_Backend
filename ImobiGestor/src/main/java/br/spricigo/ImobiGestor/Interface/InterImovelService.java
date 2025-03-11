package br.spricigo.ImobiGestor.Interface;

import java.util.List;

import br.spricigo.ImobiGestor.DTO.ImovelUpdateDTO;
import br.spricigo.ImobiGestor.Entity.Imovel;

public interface InterImovelService {
    
    public Imovel buscarPorId(Long id);

    public List<Imovel> buscarTodos();
    
    public void apagarImovelPorId(Long id);

    public Imovel atualizarImovel(Long id, ImovelUpdateDTO novoImovel);

    public Imovel criarImovel(Imovel imovel);



}
