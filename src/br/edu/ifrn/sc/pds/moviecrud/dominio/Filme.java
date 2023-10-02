package br.edu.ifrn.sc.pds.moviecrud.dominio;

public class Filme {
    private int id;
    private String titulo;
    private int duracao;
    private int ano;
    private double avaliacao;
    
    public Filme() {
        
    }

    public Filme(String titulo, int duracao, int ano, double avaliacao) {
        this.titulo = titulo;
        this.duracao = duracao;
        this.ano = ano;
        this.avaliacao = avaliacao;
    }

    public Filme(int id, String titulo, int duracao, int ano, double avaliacao) {
        this.id = id;
        this.titulo = titulo;
        this.duracao = duracao;
        this.ano = ano;
        this.avaliacao = avaliacao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public double getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(double avaliacao) {
        this.avaliacao = avaliacao;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Filme{");
        sb.append("id=").append(id);
        sb.append(", titulo=").append(titulo);
        sb.append(", duracao=").append(duracao);
        sb.append(", ano=").append(ano);
        sb.append(", avaliacao=").append(avaliacao);
        sb.append('}');
        return sb.toString();
    }
    
}
