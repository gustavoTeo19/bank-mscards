package io.github.gustavoteo19.mscartoes.infra.repository;

import io.github.gustavoteo19.mscartoes.domain.ClienteCartao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClienteCartaoRpository extends JpaRepository<ClienteCartao,Long> {
    List<ClienteCartao> findByCpf(String cpf);
}
