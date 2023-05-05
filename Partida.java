public class Partida {
    String nome;
    String data;
    String local;
    int ingressosInteira;
    int ingressosMeia;


    public Partida(String nome, String data, String local, int ingressosInteira, int ingressosMeia) {
        this.nome = nome;
        this.data = data;
        this.local = local;
        this.ingressosInteira = ingressosInteira;
        this.ingressosMeia = ingressosMeia;
    }

    public String getNome() {
        return this.nome;
    }

    public String getData() {
        return this.data;
    }

    public String getLocal() {
        return this.local;
    }

    public int getIngressos() {
        return this.ingressosInteira + this.ingressosMeia;
    }

    public boolean isIngressoDisponivel(TipoIngresso tipo, int quantidade) {
        if (tipo == TipoIngresso.INTEIRA) {
            return quantidade <= this.ingressosInteira;
        }

        return quantidade <= this.ingressosMeia;
    }

    public void venderIngresso(TipoIngresso tipo) {
        if (this.isIngressoDisponivel(tipo, 1)) {
            if (tipo == TipoIngresso.INTEIRA) {
                this.ingressosInteira--;
            } else {
                this.ingressosMeia--;
            }
            System.out.println("Ingresso vendido!");
        } else {
            System.out.println("Não há ingressos disponíveis!");
        }
    }

    @Override
    public String toString() {
        return "Partida " + this.getNome()
                + "\nData: " + this.getData()
                + "\nLocal: " + this.getLocal()
                + "\nIngressos disponíveis: " + this.getIngressos();
    }
}
