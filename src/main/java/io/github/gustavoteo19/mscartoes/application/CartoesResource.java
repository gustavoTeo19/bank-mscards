package io.github.gustavoteo19.mscartoes.application;

import io.github.gustavoteo19.mscartoes.application.DTOs.CartaoSaveRequestDTO;
import io.github.gustavoteo19.mscartoes.application.DTOs.CartoesPorClienteResponse;
import io.github.gustavoteo19.mscartoes.domain.Cartao;
import io.github.gustavoteo19.mscartoes.domain.ClienteCartao;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("cartoes")
public class CartoesResource {

    private final CartaoService cartaoService;
    private final ClienteCartaoService clienteCartaoService;

    public CartoesResource(CartaoService service, ClienteCartaoService clienteCartaoService) {
        this.cartaoService = service;
        this.clienteCartaoService = clienteCartaoService;
    }

    @GetMapping
    public String status(){
        return "Ok";
    }

    @PostMapping
    public ResponseEntity cadastra(@RequestBody CartaoSaveRequestDTO request){
        Cartao cartao = request.toModel();
        cartaoService.save(cartao);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping(params = "renda")
    public ResponseEntity<List<Cartao>> getCartoesRendaAteh(@RequestParam("renda") Long renda){
        System.out.println(renda);
        List<Cartao> list = cartaoService.getCartoesRendaMenorIgual(renda);
        return ResponseEntity.ok(list);
    }

    @GetMapping(params = "cpf")
    public ResponseEntity<List<CartoesPorClienteResponse>> getCartoesByCliente(@RequestParam("cpf") String cpf){
        List<ClienteCartao> list = clienteCartaoService.listCartoesByCpf(cpf);
        return ResponseEntity.ok(list.stream().map(CartoesPorClienteResponse::fromModel).collect(Collectors.toList()));
    }


}
