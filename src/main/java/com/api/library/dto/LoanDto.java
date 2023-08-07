package com.api.library.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.math.BigInteger;
import java.util.Date;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper=false)
@ApiModel(value = "Loan", description = "Información del préstamo")
public class LoanDto {
    @ApiModelProperty(value = "ID")
    private BigInteger ID;
    @ApiModelProperty(value = "Título")
    private String BOOKTITLE;
    @ApiModelProperty(value = "Socio")
    private String MEMBERNAME;
    @ApiModelProperty(value = "Fecha Préstamo")
    private Date DATE;
    @ApiModelProperty(value = "Fecha Límite Devolución")
    private Date DATELIMIT;
    @ApiModelProperty(value = "Fecha Devolución")
    private Date DATERETURN;
    @ApiModelProperty(value = "Estado")
    private String STATE;
}
