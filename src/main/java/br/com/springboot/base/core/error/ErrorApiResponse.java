package br.com.springboot.base.core.error;

import br.com.springboot.base.core.bean.Messages;
import lombok.*;
import java.io.Serializable;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class ErrorApiResponse implements Serializable {

    private String status;
    private List<Messages> messages;

}
