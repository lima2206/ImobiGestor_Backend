package br.spricigo.ImobiGestor.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.spricigo.ImobiGestor.DTO.ProprietarioUpdateDTO;
import br.spricigo.ImobiGestor.Entity.Proprietario;
import br.spricigo.ImobiGestor.Interface.InterProprietarioService;
import br.spricigo.ImobiGestor.Service.ProprietarioService;

@RestController
@CrossOrigin
@RequestMapping(value = "/proprietario")
public class ProprietarioController implements InterProprietarioService {

    @Autowired
    private ProprietarioService proprietarioService;

    @DeleteMapping(value = "/{id}")
    public void apagarProprietarioPorId(@PathVariable("id") Long id) {
        proprietarioService.apagarProprietarioPorId(id);
    }

    @PatchMapping(value = "/{id}")
    public Proprietario atualizarProprietario(
            @PathVariable("id") Long id,
            @RequestBody ProprietarioUpdateDTO novoProprietario) {

        return proprietarioService.atualizarProprietario(id, novoProprietario);
    }

    @GetMapping(value = "/{id}")
    public Proprietario buscarPorId(@PathVariable("id") Long id) {
        return proprietarioService.buscarPorId(id);
    }

    @GetMapping
    public List<Proprietario> buscarTodos() {
        return proprietarioService.buscarTodos();
    }

    @PostMapping
    public Proprietario criarProprietario(@RequestBody Proprietario proprietario) {
        return proprietarioService.criarProprietario(proprietario);
    }

    @PatchMapping(value = "/{pro_id}/imovel/{imv_id}")
    public Proprietario vincularImovel(
        @PathVariable("pro_id") Long pro_id,
        @PathVariable("imv_id") Long imv_id){
            return proprietarioService.vincularImovel(pro_id, imv_id);
        }

}
