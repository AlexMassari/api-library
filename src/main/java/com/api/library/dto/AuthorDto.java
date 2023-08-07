package com.api.library.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.math.BigInteger;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper=false)
@ApiModel(value = "Author", description = "Informacion de libro")
public class AuthorDto {
    @ApiModelProperty(value = "ID")
    private BigInteger ID;
    @ApiModelProperty(value = "NAME")
    private String NAME;
    @ApiModelProperty(value = "BOOK")
    private String BOOK;
}
