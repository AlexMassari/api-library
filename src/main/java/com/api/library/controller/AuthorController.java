package com.api.library.controller;

import com.api.library.dto.BookDto;
import com.api.library.entity.AuthorEntity;
import com.api.library.entity.BookEntity;
import io.swagger.annotations.*;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import java.math.BigInteger;
import java.util.List;

@Controller
@Api(value = "/author",
        tags = "author",
        produces = MediaType.APPLICATION_JSON_VALUE)
public interface AuthorController {

    @ApiOperation(value = "Listar autores",
            response = AuthorEntity.class,
            httpMethod = "GET",
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses(value = {
            @ApiResponse(code = 200,
                    message = "Busqueda Exitosa",
                    response = AuthorEntity.class
            ),
            @ApiResponse(code = 404,
                    message = "Error !!!"
            ),
            @ApiResponse(code = 500,
                    message = "No se pudo conectar a la BD"
            )
    })
    List<AuthorEntity> getAuthorsList(HttpServletRequest request);


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

    @ApiOperation(value = "Modificar un autor")
    @ApiResponses(value = {
            @ApiResponse(code = 200,
                    message = "Busqueda Exitosa",
                    response = AuthorEntity.class
            ),
            @ApiResponse(code = 404,
                    message = "No se encontró el autor con ese ID"
            ),
            @ApiResponse(code = 500,
                    message = "No se pudo conectar a la BD"
            )
    })
    ResponseEntity<String> updateAuthor(BigInteger authorId, AuthorEntity author);

    @ApiOperation(value = "ELiminar un autor")
    @ApiResponses(value = {
            @ApiResponse(code = 200,
                    message = "Busqueda Exitosa",
                    response = AuthorEntity.class
            ),
            @ApiResponse(code = 404,
                    message = "No se encontró el autor con ese ID"
            ),
            @ApiResponse(code = 500,
                    message = "No se pudo conectar a la BD"
            )
    })
    ResponseEntity<String> deleteAuthor(BigInteger authorId);
}
