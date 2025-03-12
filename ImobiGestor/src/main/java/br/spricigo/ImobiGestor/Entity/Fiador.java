package br.spricigo.ImobiGestor.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "fiad_fiador")
public class Fiador {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "fiad_id")
  private Long id;

  @Column(name = "fiad_nome")
  private String nome;

  @Column(name = "fiad_estado_civil")
  private String estadoCivil;

  @Column(name = "fiad_profissao")
  private String profissao;

  @Column(name = "fiad_documento_pdf_path")
  private String documentoPDFPath;

  @Column(name = "fiad_endereco")
  private String endereco;

  @Column(name = "fiad_telefone")
  private String telefone;

  @Column(name = "fiad_email")
  private String email;

  @Column(name = "fiad_comprovante_renda_path")
  private String comprovanteRendaPath;

  @Column(name = "fiad_certidao_imovel_path")
  private String certidaoImovelPath;

  public Fiador(String nome, String estadoCivil, String profissao, String documentoPDFPath, String endereco,
      String telefone, String email, String comprovanteRendaPath, String certidaoImovelPath) {
    this.nome = nome;
    this.estadoCivil = estadoCivil;
    this.profissao = profissao;
    this.documentoPDFPath = documentoPDFPath;
    this.endereco = endereco;
    this.telefone = telefone;
    this.email = email;
    this.comprovanteRendaPath = comprovanteRendaPath;
    this.certidaoImovelPath = certidaoImovelPath;
  }

  public Fiador(){ }

  public Long getId() {
    return id;
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

  public String getDocumentoPDFPath() {
    return documentoPDFPath;
  }

  public void setDocumentoPDFPath(String documentoPDFPath) {
    this.documentoPDFPath = documentoPDFPath;
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

  public String getComprovanteRendaPath() {
    return comprovanteRendaPath;
  }

  public void setComprovanteRendaPath(String comprovanteRendaPath) {
    this.comprovanteRendaPath = comprovanteRendaPath;
  }

  public String getCertidaoImovelPath() {
    return certidaoImovelPath;
  }

  public void setCertidaoImovelPath(String certidaoImovelPath) {
    this.certidaoImovelPath = certidaoImovelPath;
  }

  
}
