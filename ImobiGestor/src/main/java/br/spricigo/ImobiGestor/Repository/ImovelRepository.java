package br.spricigo.ImobiGestor.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.spricigo.ImobiGestor.Entity.Imovel;

public interface ImovelRepository extends JpaRepository<Imovel, Long> {
    
}
