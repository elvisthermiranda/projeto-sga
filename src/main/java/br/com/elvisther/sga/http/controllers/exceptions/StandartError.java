package br.com.elvisther.sga.http.controllers.exceptions;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class StandartError
{
	private String message;
	private int code;
    private String error;
    private String describle;

    @JsonFormat(pattern = "dd/MM/yyyy hh:MM:ss")
    private LocalDateTime instant;
    private String path;
}
