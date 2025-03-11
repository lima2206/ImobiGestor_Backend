package br.spricigo.ImobiGestor.DTO;


public class ImovelUpdateDTO {
    
    private String endereco;
    private String descricao;
    private String iptuPDFPath;

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
