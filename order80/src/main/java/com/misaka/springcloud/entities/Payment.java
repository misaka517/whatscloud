package com.misaka.springcloud.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author 517
 * @date 2021-08-16 - 23:24
 */

@Data
@NoArgsConstructor
public class Payment implements Serializable {
    private Long id;
    private String Serial;
}
