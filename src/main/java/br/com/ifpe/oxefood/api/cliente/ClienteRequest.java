package br.com.ifpe.oxefood.api.cliente;

import java.time.LocalDate;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.ifpe.oxefood.modelo.cliente.Cliente;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // equivale ao getter e setter
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class ClienteRequest {

    @NotNull(message = "O Nome é de preenchimento obrigatório")
    @NotBlank(message = "O Nome é de preenchimento obrigatório")
    @Length(max = 100, message = "O Nome deverá ter no máximo {max} caracteres")
    private String nome;

    @JsonFormat(pattern = "dd/MM/yyyy") // armazenar só uma data (localdate) utilizar @JsonFormat(pattern =
                                        // "dd/MM/yyyy"); armazenar hora e data (LocalDateTime) utilizar
                                        // @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDate dataNascimento;

    @NotNull(message = "O CPF é de preenchimento obrigatório")
    @NotBlank(message = "O CPF é de preenchimento obrigatório")
    @CPF
    private String cpf;

    @Length(min = 8, max = 20, message = "O campo Fone tem que ter entre {min} e {max} caracteres")
    @Pattern(regexp = "^81", message = "Telefone celular deve começar com o prefixo 81")
    private String foneCelular;

    @Length(min = 8, max = 20, message = "O campo Fone tem que ter entre {min} e {max} caracteres")
    @Pattern(regexp = "^81", message = "Telefone celular deve começar com o prefixo 81")
    private String foneFixo;

    public Cliente build() {

        return Cliente.builder()
                .nome(nome)
                .dataNascimento(dataNascimento)
                .cpf(cpf)
                .foneCelular(foneCelular)
                .foneFixo(foneFixo)
                .build();
    }

}
