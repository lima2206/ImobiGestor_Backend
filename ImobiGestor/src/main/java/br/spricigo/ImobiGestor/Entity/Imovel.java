package br.spricigo.ImobiGestor.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "imv_imovel")
public class Imovel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "imv_id")
    private Long id;

    @Column(name = "imv_endereco")
    private String endereco;

    @Column(name = "imv_descricao")
    private String descricao;

    @Column(name = "imv_iptu_pdf_path")
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
