package gestao.pessoa.pessoa;

import gestao.pessoa.identificador.TipoIdentificador;

public record DadosDetalhamentoPessoa(Long id, String nome, String identificador, TipoIdentificador tipoIdentificador) {
  public DadosDetalhamentoPessoa(Pessoa pessoa) {
    this(pessoa.getId(), pessoa.getNome(), pessoa.getIdentificador(), pessoa.getTipoIdentificador());
  }
}
