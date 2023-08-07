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
@ApiModel(value = "Book", description = "Informacion de libro")
public class BookDto {
    @ApiModelProperty(value = "ID")
    private BigInteger ID;
    @ApiModelProperty(value = "Título")
    private String TITLE;
    @ApiModelProperty(value = "Autor")
    private String AUTHOR;
    @ApiModelProperty(value = "Editorial")
    private String PUBLISHER;
    @ApiModelProperty(value = "Año")
    private String YEAR;
    @ApiModelProperty(value = "Género")
    private String GENRE;
    @ApiModelProperty(value = "Cantidad")
    private int AMOUNT;
}
