public abstract class Ingresso {
    Partida partida;
    TipoIngresso tipo;
    Assento assento;
    double preco;

    public Ingresso(Partida partida, TipoIngresso tipo, Assento assento, double preco) {
        this.partida = partida;
        this.tipo = tipo;
        this.assento = assento;
        this.preco = preco;
    }

    public double getPreco() {
        return this.preco;
    }

    @Override
    public String toString() {
        return "Partida: " + this.partida.getNome()
            + "\nAssento: " + this.assento
            + "\nTipo: " + this.tipo
            + "\nValor (R$): " + this.getPreco();      
    }
}