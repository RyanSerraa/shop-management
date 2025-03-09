package shop_management.entity;

import java.math.BigDecimal;

public class ProdutoDTO {
    private BigDecimal preco;

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public ProdutoDTO() {
    }
    
}
