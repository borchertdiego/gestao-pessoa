package gestao.pessoa.pessoa;

import jakarta.validation.constraints.NotBlank;

public record DadosCadastroPessoa(@NotBlank String nome,
                                  @NotBlank String identificador) {
}
