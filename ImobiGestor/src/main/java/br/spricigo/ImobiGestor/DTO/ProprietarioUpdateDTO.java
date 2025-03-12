package br.spricigo.ImobiGestor.DTO;

import jakarta.validation.constraints.Email;

public class ProprietarioUpdateDTO {

    private String nome;

    private String estadoCivil;

    private String profissao;

    private String documentoPDFPath;

    private String endereco;

    private String telefone;

    @Email(message = "Email inválido")
    private String email;

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