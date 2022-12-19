package gestao.pessoa.controller;

import gestao.pessoa.PessoaApplication;
import gestao.pessoa.pessoa.*;
import io.swagger.annotations.ApiOperation;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RequestMapping("/pessoas")
@RestController
public class PessoaController {

  private final PessoaRepository pessoaRepository;

  public PessoaController(PessoaRepository pessoaRepository) {
    this.pessoaRepository = pessoaRepository;
  }

  @ApiOperation(value = "Cadastra uma pessoa com um identificador (CPF ou CNPJ).")
  @PostMapping
  @Transactional
  public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroPessoa dadosCadastroPessoa, UriComponentsBuilder uriComponentsBuilder) {
    Pessoa pessoa = new Pessoa(dadosCadastroPessoa);
    pessoaRepository.save(pessoa);

    URI uri = uriComponentsBuilder.path("/pessoas/{id}").buildAndExpand(pessoa.getId()).toUri();

    return ResponseEntity.created(uri).body(new DadosDetalhamentoPessoa(pessoa));
  }
}
