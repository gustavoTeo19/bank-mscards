package io.github.gustavoteo19.mscartoes.application;

import io.github.gustavoteo19.mscartoes.domain.Cartao;
import io.github.gustavoteo19.mscartoes.infra.repository.CartaoRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;

@Service
public class CartaoService {
    private final CartaoRepository repository;

    public CartaoService(CartaoRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public Cartao save(Cartao cartao){
        return repository.save(cartao);
    }

    public List<Cartao> getCartoesRendaMenorIgual(Long renda){
        BigDecimal bigDecimal = BigDecimal.valueOf(renda);
        return repository.findByRendaLessThanEqual(bigDecimal);

    }
}
