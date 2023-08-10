package com.api.library.controller;

import com.api.library.dto.BookDto;
import com.api.library.entity.BookEntity;
import io.swagger.annotations.*;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import java.math.BigInteger;
import java.util.List;

@Controller
@Api(value = "/book",
        tags = "book",
        produces = MediaType.APPLICATION_JSON_VALUE)
public interface BookController {
    @ApiOperation(value = "Buscar datos del libro por su numero de id",
            response = BookDto.class,
            httpMethod = "GET",
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses(value = {
            @ApiResponse(code = 200,
                    message = "Busqueda Exitosa",
                    response = BookDto.class
            ),
            @ApiResponse(code = 404,
                    message = "El numero de socio no existe"
            ),
            @ApiResponse(code = 500,
                    message = "No se pudo conectar a la BD"
            )
    })
    BookDto getBookById(HttpServletRequest request,
                        @ApiParam(value = "Numero ID del libro")
                        BigInteger id);


    @ApiOperation(value = "Buscar datos del libro por su titulo",
            response = BookDto.class,
            httpMethod = "GET",
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses(value = {
            @ApiResponse(code = 200,
                    message = "Busqueda Exitosa",
                    response = BookDto.class
            ),
            @ApiResponse(code = 404,
                    message = "El numero de socio no existe"
            ),
            @ApiResponse(code = 500,
                    message = "No se pudo conectar a la BD"
            )
    })
    BookDto getBookByName(HttpServletRequest request,
                          @ApiParam(value = "Titulo del libro")
                          String title);


    @ApiOperation(value = "Buscar libros por su autor",
            response = BookDto.class,
            httpMethod = "GET",
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses(value = {
            @ApiResponse(code = 200,
                    message = "Busqueda Exitosa",
                    response = BookDto.class
            ),
            @ApiResponse(code = 404,
                    message = "El autor no existe"
            ),
            @ApiResponse(code = 500,
                    message = "No se pudo conectar a la BD"
            )
    })
    List<BookDto> getBooksByAuthor(HttpServletRequest request,
                                   @ApiParam(value = "Numero ID del autor")
                                   BigInteger id);

    @ApiOperation(value = "Registrar un nuevo libro")
    @ApiResponses(value = {
            @ApiResponse(code = 200,
                    message = "Busqueda Exitosa",
                    response = BookEntity.class
            ),
            @ApiResponse(code = 404,
                    message = "Error en parametros ingresados"
            ),
            @ApiResponse(code = 500,
                    message = "No se pudo conectar a la BD"
            )
    })
    ResponseEntity<String> createBook(BookEntity book);

    @ApiOperation(value = "Modificar un libro")
    @ApiResponses(value = {
            @ApiResponse(code = 200,
                    message = "Busqueda Exitosa",
                    response = BookEntity.class
            ),
            @ApiResponse(code = 404,
                    message = "No se encontró un libro con el ID ingresado"
            ),
            @ApiResponse(code = 500,
                    message = "No se pudo conectar a la BD"
            )
    })
    ResponseEntity<String> updateBook(BigInteger bookId, BookEntity book);

    @ApiOperation(value = "Eliminar un libro")
    @ApiResponses(value = {
            @ApiResponse(code = 200,
                    message = "Busqueda Exitosa",
                    response = BookEntity.class
            ),
            @ApiResponse(code = 404,
                    message = "No se encontró un libro con el ID ingresado"
            ),
            @ApiResponse(code = 500,
                    message = "No se pudo conectar a la BD"
            )
    })
    ResponseEntity<String> deleteBook(BigInteger bookId);
}
