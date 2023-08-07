package com.api.library.controller;

import com.api.library.dto.LoanDto;
import io.swagger.annotations.*;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import java.math.BigInteger;
import java.util.List;

@Controller
@Api(value = "/loan",
        tags = "loan",
        produces = MediaType.APPLICATION_JSON_VALUE)
public interface LoanController {
    @ApiOperation(value = "Buscar datos del prestamo por su numero de id",
            response = LoanDto.class,
            httpMethod = "GET",
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses(value = {
            @ApiResponse(code = 200,
                    message = "Busqueda Exitosa",
                    response = LoanDto.class
            ),
            @ApiResponse(code = 404,
                    message = "El numero de prestamo no existe"
            ),
            @ApiResponse(code = 500,
                    message = "No se pudo conectar a la BD"
            )
    })
    LoanDto getLoanById(HttpServletRequest request,
                        @ApiParam(value = "Numero ID del prestamo")
                        BigInteger id);



    @ApiOperation(value = "Buscar listado del prestamos por socio",
            response = LoanDto.class,
            httpMethod = "GET",
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses(value = {
            @ApiResponse(code = 200,
                    message = "Busqueda Exitosa",
                    response = LoanDto.class
            ),
            @ApiResponse(code = 404,
                    message = "El numero de prestamo no existe"
            ),
            @ApiResponse(code = 500,
                    message = "No se pudo conectar a la BD"
            )
    })
    List<LoanDto> getLoanByMember(HttpServletRequest request,
                                  @ApiParam(value = "Numero ID del socio")
                                  BigInteger id);
}