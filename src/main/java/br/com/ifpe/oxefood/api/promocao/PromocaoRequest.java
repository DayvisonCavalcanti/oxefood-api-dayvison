package br.com.ifpe.oxefood.api.promocao;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.ifpe.oxefood.modelo.promocao.Promocao;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // equivale ao getter e setter
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class PromocaoRequest {

    private String titulo;

    @JsonFormat(pattern = "dd/MM/yyyy") // armazenar só uma data (localdate) utilizar @JsonFormat(pattern = "dd/MM/yyyy"); armazenar hora e data (LocalDateTime) utilizar @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDate dataInicio;

    @JsonFormat(pattern = "dd/MM/yyyy") // armazenar só uma data (localdate) utilizar @JsonFormat(pattern = "dd/MM/yyyy"); armazenar hora e data (LocalDateTime) utilizar @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDate dataFim;

    private String regra;

    private Double valorDesconto;

    public Promocao build() {

        return Promocao.builder()
                .titulo(titulo)
                .dataInicio(dataInicio)
                .dataFim(dataFim)
                .regra(regra)
                .valorDesconto(valorDesconto)
                .build();
    }

}
