package br.spricigo.ImobiGestor.Interface;

import java.util.List;

import br.spricigo.ImobiGestor.DTO.ProprietarioUpdateDTO;
import br.spricigo.ImobiGestor.Entity.Proprietario;

public interface InterProprietarioService {

    public Proprietario buscarPorId(Long id);

    public List<Proprietario> buscarTodos();

    public Proprietario criarProprietario(Proprietario proprietario);

    public void apagarProprietarioPorId(Long id);

    public Proprietario atualizarProprietario(Long id, ProprietarioUpdateDTO novoProprietario);
}
