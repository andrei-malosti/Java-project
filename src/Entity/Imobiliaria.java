package Entity;

import Enum.Type;

public class Imobiliaria{

    private Integer codigo;
    private Type tipo;
    private Double aluguel;

    public Imobiliaria(Integer codigo, Double aluguel, Type tipo) {
        this.codigo = codigo;
        this.aluguel = aluguel;
        this.tipo = tipo;
    }

    public Integer getCodigo() {
        return codigo;
    }

    private void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public Type getTipo() {
        return tipo;
    }

    public void setTipo(Type tipo) {
        this.tipo = tipo;
    }

    public Double getAluguel() {
        return aluguel;
    }

    public void setAluguel(Double aluguel) {
        this.aluguel = aluguel;
    }

    @Override
    public String toString() {
        return String.format("%d   %12.2f   %14s",codigo, aluguel, tipo);
    }
}
