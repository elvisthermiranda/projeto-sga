package br.com.elvisther.sga.enums;

public enum Ativo {
	SIM('S'),
    NAO('N');

    private final Character valor;

    Ativo(Character valor) {
        this.valor = valor;
    }

    public Character getValor() {
        return valor;
    }

    public static Ativo valueOf(Character valor) {
        for (Ativo ativo : values()) {
            if (ativo.valor == valor) {
                return ativo;
            }
        }
        throw new IllegalArgumentException("Valor inválido para Ativo: " + valor);
    }
}
