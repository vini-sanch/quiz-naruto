package greysanatomy.com.br.appquiznaruto.Model;

public class Jogador {
    //Atributos
    private int id;
    private String nome;
    private int pontos;

    public Jogador(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getPontos() {
        return pontos;
    }

    public void setPontos(int pontos) {
        this.pontos = pontos;
    }
}
