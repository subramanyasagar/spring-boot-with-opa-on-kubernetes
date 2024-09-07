package com.springboot.opa.dto;


import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.util.Map;

@AllArgsConstructor
@Data
public class OPARequest implements Serializable {

    Map<String, Object> input;

}
