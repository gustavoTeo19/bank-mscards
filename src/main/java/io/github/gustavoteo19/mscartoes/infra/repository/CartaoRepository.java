package io.github.gustavoteo19.mscartoes.infra.repository;

import io.github.gustavoteo19.mscartoes.domain.Cartao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartaoRepository extends JpaRepository<Cartao, Long> {
}
