package br.com.panacademy.bluebank.controle;

import br.com.panacademy.bluebank.config.security.TokenServico;
import br.com.panacademy.bluebank.dto.usuario.cliente.AtualizarClienteDTO;
import br.com.panacademy.bluebank.dto.usuario.cliente.AtualizarCredenciaisClienteDTO;
import br.com.panacademy.bluebank.dto.usuario.cliente.CadastrarClienteDTO;
import br.com.panacademy.bluebank.dto.usuario.cliente.ClienteDTO;
import br.com.panacademy.bluebank.servico.ClienteServico;
<<<<<<< HEAD
import io.swagger.annotations.ApiOperation;
import com.amazonaws.services.sns.AmazonSNSClient;
import com.amazonaws.services.sns.model.SubscribeRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
=======
import br.com.panacademy.bluebank.servico.ContaServico;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
>>>>>>> 9a9138dbca151b7ea0b75aa5cd3c64d9cd6c64b6
import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/clientes")
public class ClienteControle {

    private final ClienteServico clienteServico;
    private final TokenServico tokenServico;


    public ClienteControle(ClienteServico clienteServico, TokenServico tokenServico) {
        this.clienteServico = clienteServico;
        this.tokenServico = tokenServico;
    }

    @GetMapping
<<<<<<< HEAD
    @ApiOperation(("Lista todos os clientes"))
    public ResponseEntity<List<ClienteDTO>> listarTodosClientes(){
=======
    public ResponseEntity<List<ClienteDTO>> listarTodosClientes() {
>>>>>>> 9a9138dbca151b7ea0b75aa5cd3c64d9cd6c64b6
        List<ClienteDTO> listaClientesDTO = clienteServico.listarTodos();
        return ResponseEntity.ok(listaClientesDTO);
    }

    @GetMapping("/{id}")
<<<<<<< HEAD
    @ApiOperation("Busca e retorna um cliente, filtrando pelo ID")
    public ResponseEntity<ClienteDTO> filtrarPorId(@PathVariable Long id){
=======
    public ResponseEntity<ClienteDTO> filtrarPorId(@PathVariable Long id) {
>>>>>>> 9a9138dbca151b7ea0b75aa5cd3c64d9cd6c64b6
        ClienteDTO clienteDTO = clienteServico.filtrarPorId(id);
        return ResponseEntity.ok(clienteDTO);
    }

    @PostMapping
<<<<<<< HEAD
    @ApiOperation("Cadastra um cliente, com atribuição dinâmica de ID")
    public ResponseEntity<ClienteDTO> salvarCliente(@Valid @RequestBody CadastrarClienteDTO cliente){
=======
    public ResponseEntity<ClienteDTO> salvarCliente(@Valid @RequestBody CadastrarClienteDTO cliente) {
>>>>>>> 9a9138dbca151b7ea0b75aa5cd3c64d9cd6c64b6
        ClienteDTO clienteDTO = clienteServico.salvarCliente(cliente);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
                .buildAndExpand(clienteDTO.getId()).toUri();
        return ResponseEntity.created(uri).body(clienteDTO);
    }

    @DeleteMapping(value = "/{id}")
<<<<<<< HEAD
    @ApiOperation("Busca e deleta um cliente, filtrando pelo ID")
=======
>>>>>>> 9a9138dbca151b7ea0b75aa5cd3c64d9cd6c64b6
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        clienteServico.deletarCliente(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping()
    public ResponseEntity<AtualizarClienteDTO> atualizarCliente(HttpServletRequest request, @RequestBody AtualizarClienteDTO dto) {
        String token = recuperarToken(request);
        Long idUsuario = tokenServico.getIdUsuario(token);
        dto = clienteServico.atualizarCliente(idUsuario, dto);
        return ResponseEntity.ok().body(dto);
    }

    @PutMapping("/{id}")
    @ApiOperation("Atualização de telefone, email e senha do cliente, filtrando pelo ID")
    public ResponseEntity<AtualizarClienteDTO> atualizarCliente(@PathVariable Long id, @RequestBody AtualizarClienteDTO dto) {
        dto = clienteServico.atualizarCliente(id, dto);
        return ResponseEntity.ok().body(dto);
    }

    @PutMapping("/credenciais/{id}")
    @ApiOperation("Atualiza as credenciais do cliente, filtrando pelo ID")
    public ResponseEntity<AtualizarCredenciaisClienteDTO> atualizarCredenciais(@PathVariable Long id, @RequestBody AtualizarCredenciaisClienteDTO dto) {
        dto = clienteServico.atualizarCredenciaisCliente(id, dto);
        return ResponseEntity.ok().body(dto);
    }

    private String recuperarToken(HttpServletRequest request) {
        String token = request.getHeader("Authorization");
        if (token == null || token.isEmpty() || !token.startsWith("Bearer ")) {
            return null;
        }

        return token.substring(7, token.length());
    }
<<<<<<< HEAD
}
=======

}
>>>>>>> 9a9138dbca151b7ea0b75aa5cd3c64d9cd6c64b6
