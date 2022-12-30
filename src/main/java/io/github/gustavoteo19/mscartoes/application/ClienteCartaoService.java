package io.github.gustavoteo19.mscartoes.application;

import io.github.gustavoteo19.mscartoes.domain.ClienteCartao;
import io.github.gustavoteo19.mscartoes.infra.repository.ClienteCartaoRpository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClienteCartaoService {
    private final ClienteCartaoRpository repository;

    public List<ClienteCartao> listCartoesByCpf(String cpf){
        return repository.findByCpf(cpf);
    }
}
