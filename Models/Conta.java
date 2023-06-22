package Models;

// declarando a class conta
public class Conta {
     // Atributos que toda conta terá
    private String titularDaConta; // Uma string para armazenar o nome do titular da conta
    private long cpfDoTitular; // Um long para armazenar o cpf do titular da conta
    private int numeroDaConta; // Um inteiro para armazenar o número da conta
    private double saldoDaConta; // Um número de ponto flutuante para armazenar o saldo da conta

    // Construtor da classe Conta
    public Conta(int numeroDaConta, String titularDaConta, double saldoDaConta, long cpfDoTitular) {
        this.titularDaConta = titularDaConta;
        this.cpfDoTitular = cpfDoTitular;
        this.numeroDaConta = numeroDaConta;
        this.saldoDaConta = saldoDaConta;
    }

    // Criação do método get
        
        public String getTitularDaConta() {
            return titularDaConta;
        }
        
        public long getCpfDoTitular(){
            return cpfDoTitular;
        }
        
        public int getNumeroDaConta() {
        return numeroDaConta;
        }
        
        public double getSaldoDaConta() {
            return saldoDaConta;
        }
        
    // Método depositar
    public void depositar(double valor) {
        saldoDaConta += valor;
    } // fim do método depositar
    
    // Método sacar
    public void sacar(double valor) {
        if (saldoDaConta >= valor) {
            saldoDaConta -= valor;
        } else {
        System.out.println("Saldo insuficiente!");
        }
    } // fim do método de sacar.
    
    // Classe ContaCorrente que estende a classe Conta
        public class ContaCorrente extends Conta {
        
        private double chequeEspecial;
        
        public ContaCorrente(String titularDaConta, long cpfDoTitular, int numeroDaConta, double saldoDaConta) {
            super(numeroDaConta, titularDaConta, saldoDaConta, cpfDoTitular );
            this.chequeEspecial = 500.0;
        }
        
        public double getChequeEspecial() {
        return chequeEspecial;
        }
        
    } // fim da ContaCorrente extends Conta

    public class ContaPoupanca extends Conta {
    private double taxaJuros;

    public ContaPoupanca(int numeroDaConta, String titularDaConta, double saldoDaConta, long cpfDoTitular) {
        super(numeroDaConta, titularDaConta, saldoDaConta, cpfDoTitular);
        this.taxaJuros = 0.005;
    }


    public double getTaxaJuros() {
        return taxaJuros;
    }

    public void aumentarTaxaJuros() {
        taxaJuros += 0.005;
    }
}

} // fim da class conta
