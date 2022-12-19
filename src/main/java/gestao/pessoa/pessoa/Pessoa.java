package gestao.pessoa.pessoa;

import gestao.pessoa.identificador.TipoIdentificador;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;

@Entity
@Table(name = "pessoas")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Pessoa {
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String nome;
  private String identificador;
  @Enumerated(EnumType.STRING)
  private TipoIdentificador tipoIdentificador;

  public Pessoa(DadosCadastroPessoa dadosCadastroPessoa) {
    this.nome = dadosCadastroPessoa.nome();
    this.identificador = dadosCadastroPessoa.identificador();
    verificaCPFouCPNJ(this.identificador);
  }

  /*
   * Como o escopo do projeto é pequeno, ficou como responsabilidade da entidade verificar
   * se o identificador é CPF ou CNPJ.
   */
  private void verificaCPFouCPNJ(String identificador) {
    if (identificador.length() == 14) {
      this.tipoIdentificador = TipoIdentificador.CNPJ;
    } else {
      this.tipoIdentificador = TipoIdentificador.CPF;
    }
  }
}
