// ================= CLASSE BASE =================
class Produto {
    protected String nome;
    protected float preco;
    protected int estoque;

    public Produto(String nome, float preco, int estoque) {
        this.nome = nome;
        this.preco = preco;

        // impede começar com estoque negativo
        if (estoque >= 0) {
            this.estoque = estoque;
        } else {
            this.estoque = 0;
        }
    }

    public void adicionarEstoque(int qtd) {
        if (qtd > 0) {
            estoque += qtd;
        }
    }

    public void vender(int qtd) {
        if (qtd > 0 && qtd <= estoque) {
            estoque -= qtd;
            System.out.println("Vendido: " + qtd + " unidades de " + nome + ".");
        } else {
            System.out.println("Estoque insuficiente ou quantidade inválida.");
        }
    }
}

// ================= SUBCLASSE =================
class Perecivel extends Produto {
    protected String dataValidade;

    public Perecivel(String nome, float preco, int estoque, String dataValidade) {
        super(nome, preco, estoque);
        this.dataValidade = dataValidade;
    }

    @Override
    public void vender(int qtd) {
        System.out.println("Verificando validade do produto...");

        if (estoque > 0) {
            super.vender(qtd);
            System.out.println("Produto perecível vendido. Validade: " + dataValidade);
        } else {
            System.out.println("Produto sem estoque.");
        }
    }
}

// ================= EXECUÇÃO =================
public class Supermercado {
    public static void main(String[] args) {

        Produto p1 = new Produto("Arroz", 25.50f, 10);
        p1.preco = 30.0f; // permitido

        Perecivel leite = new Perecivel("Leite", 5.0f, 10, "10/05/2026");
        leite.vender(2);
    }
}