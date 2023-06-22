package Models;

import java.util.ArrayList;
import java.util.List;

public class Pessoa {

    private long cpf;
    private String nome;
    private List<Conta> contas;

    public Pessoa(long cpf, String nome) {
        this.cpf = cpf;
        this.nome = nome;
        this.contas = new ArrayList<>();
    }

    public void adicionarConta(Conta conta) {
        contas.add(conta);
    }

    public void removerConta(Conta conta) {
        contas.remove(conta);
    }

    public List<Conta> getContas() {
        return contas;
    }

    public long getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

} // fim da class pessoa
