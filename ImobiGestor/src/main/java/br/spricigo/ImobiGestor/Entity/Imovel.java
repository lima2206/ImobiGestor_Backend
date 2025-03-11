package br.spricigo.ImobiGestor.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "imov_imovel")
public class Imovel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "imov_id")
    private Long id;

    @Column(name = "imov_endereco")
    private String endereco;

    @Column(name = "imov_descricao")
    private String descricao;

    @Column(name = "imov_iptu_pdf_path")
    private String iptuPDFPath;

    public Imovel(String endereco, String descricao, String iptuPDFPath) {
        this.endereco = endereco;
        this.descricao = descricao;
        this.iptuPDFPath = iptuPDFPath;
    }

    public Imovel() {}

    public Long getId() {
        return id;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getIptuPDFPath() {
        return iptuPDFPath;
    }

    public void setIptuPDFPath(String iptuPDFPath) {
        this.iptuPDFPath = iptuPDFPath;
    }

}
