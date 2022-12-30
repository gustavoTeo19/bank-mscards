package io.github.gustavoteo19.mscartoes.application.DTOs;

import io.github.gustavoteo19.mscartoes.domain.BandeiraCartao;
import io.github.gustavoteo19.mscartoes.domain.Cartao;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class CartaoSaveRequestDTO {
    private String nome;
    private BandeiraCartao bandeira;
    private BigDecimal renda;
    private BigDecimal limite;

    public Cartao toModel(){
        return new Cartao(nome, bandeira, renda, limite);
    }
}
