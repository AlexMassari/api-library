package com.api.library.controller;

import com.api.library.entity.AuthorEntity;
import com.api.library.entity.BookEntity;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

@Controller
@Api(value = "/author",
        tags = "author",
        produces = MediaType.APPLICATION_JSON_VALUE)
public interface AuthorController {
    @ApiOperation(value = "Registrar un nuevo autor")
    @ApiResponses(value = {
            @ApiResponse(code = 200,
                    message = "Busqueda Exitosa",
                    response = AuthorEntity.class
            ),
            @ApiResponse(code = 404,
                    message = "Error en parametros ingresados"
            ),
            @ApiResponse(code = 500,
                    message = "No se pudo conectar a la BD"
            )
    })
    ResponseEntity<String> createAuthor(AuthorEntity author);
}
