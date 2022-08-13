package lk.ijse.inp_project.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author : hansakagaa
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MessageDTO {
    private String userName;
    private String userMessage;
}
