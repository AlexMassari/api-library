package com.api.library.controller;

import com.api.library.entity.AuthorEntity;
import com.api.library.entity.PublisherEntity;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.math.BigInteger;

@Controller
@Api(value = "/publisher",
        tags = "publisher",
        produces = MediaType.APPLICATION_JSON_VALUE)
public interface PublisherController {
    @ApiOperation(value = "Registrar una nueva editorial")
    @ApiResponses(value = {
            @ApiResponse(code = 200,
                    message = "Busqueda Exitosa",
                    response = PublisherEntity.class
            ),
            @ApiResponse(code = 404,
                    message = "Error en parametros ingresados"
            ),
            @ApiResponse(code = 500,
                    message = "No se pudo conectar a la BD"
            )
    })
    ResponseEntity<String> createPublisher(PublisherEntity publisher);

    @ApiOperation(value = "Modificar una editorial")
    @ApiResponses(value = {
            @ApiResponse(code = 200,
                    message = "Busqueda Exitosa",
                    response = PublisherEntity.class
            ),
            @ApiResponse(code = 404,
                    message = "No se encontró el autor con ese ID"
            ),
            @ApiResponse(code = 500,
                    message = "No se pudo conectar a la BD"
            )
    })
    ResponseEntity<String> updatePublisher(BigInteger publisherId, PublisherEntity publisher);

    @ApiOperation(value = "ELiminar una editorial")
    @ApiResponses(value = {
            @ApiResponse(code = 200,
                    message = "Busqueda Exitosa",
                    response = PublisherEntity.class
            ),
            @ApiResponse(code = 404,
                    message = "No se encontró el autor con ese ID"
            ),
            @ApiResponse(code = 500,
                    message = "No se pudo conectar a la BD"
            )
    })
    ResponseEntity<String> deletePublisher(BigInteger publisherId);
}
