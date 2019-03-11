package br.com.springboot.base.core.bean;

import lombok.*;

@AllArgsConstructor @NoArgsConstructor @Getter @Setter @ToString
public class Messages {

    private String tipo;
    private String texto;
    private String key;
}
