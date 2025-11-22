package com.ahorraVrt.ahorrovirtual.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MetaAhorroRequest {
    private String nombreMeta;
    private double objetivo;
}
