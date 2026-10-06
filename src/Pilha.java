public class Pilha {

    private String[] elementos;
    private int topo;

    // Construtor da pilha
    public Pilha(int tamanho) {
        elementos = new String[tamanho];
        topo = -1;
    }

    // Empilha um elemento
    public void empilhar(String elemento) {

        if (topo == elementos.length - 1) {
            System.out.println("Pilha cheia!");
            return;
        }

        topo++;
        elementos[topo] = elemento;

        System.out.println("Veículo adicionado à pilha.");
    }

    // Desempilha o elemento do topo
    public String desempilhar() {

        if (topo == -1) {
            System.out.println("Pilha vazia!");
            return null;
        }

        String elemento = elementos[topo];

        elementos[topo] = null;
        topo--;

        return elemento;
    }

    // Consulta o elemento do topo
    public String consultarTopo() {

        if (topo == -1) {
            return null;
        }

        return elementos[topo];
    }

    // Verifica se a pilha está vazia
    public boolean estaVazia() {
        return topo == -1;
    }
}