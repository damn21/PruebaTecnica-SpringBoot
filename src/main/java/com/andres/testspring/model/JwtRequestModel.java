package com.andres.testspring.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Table;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class JwtRequestModel implements Serializable {

    private static final long serialVersionUID = 2636936156391265891L;
    private String username;
    private String password;

}
