package com.br.produto.apirest.Controller.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StandarError implements Serializable {

    private Instant timestamp;

    private Integer status;

    private String error;

    private String message;

    private String path;
}
