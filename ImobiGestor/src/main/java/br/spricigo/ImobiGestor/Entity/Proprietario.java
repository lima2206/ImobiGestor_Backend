package br.spricigo.ImobiGestor.Entity;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "pro_proprietario")
public class Proprietario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pro_id")
    private Long id;

    @Column(name = "pro_nome")
    private String nome;

    @Column(name = "pro_estado_civil")
    private String estadoCivil;

    @Column(name = "pro_profissao")
    private String profissao;

    @Column(name = "pro_documento_pdf_path")
    private String documentoPDFPath;

    @Column(name = "pro_endereco")
    private String endereco;

    @Column(name = "pro_telefone")
    private String telefone;

    @Column(name = "pro_email")
    private String email;
    
    @ManyToMany
    @JoinTable(name="proprietario_imovel",
        joinColumns = {@JoinColumn(name="pro_id")},
        inverseJoinColumns = {@JoinColumn(name="imv_id")}
    )
    private Set<Imovel> imoveis;    


    public Proprietario(String nome, String estadoCivil, String profissao, String documentoPDFPath, String endereco, String telefone, String email) {
        this.nome = nome;
        this.estadoCivil = estadoCivil;
        this.profissao = profissao;
        this.documentoPDFPath = documentoPDFPath;
        this.endereco = endereco;
        this.telefone = telefone;
        this.email = email;
    }

    public Proprietario() { }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getProfissao() {
        return profissao;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDocumentoPDFPath() {
      return documentoPDFPath;
    }

    public void setDocumentoPDFPath(String documentoPDFPath) {
      this.documentoPDFPath = documentoPDFPath;
    }

}
