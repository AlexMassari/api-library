package com.api.library.controller;

import com.api.library.entity.BookEntity;
import com.api.library.entity.MemberEntity;
import io.swagger.annotations.*;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import java.math.BigInteger;
import java.util.List;

@Controller
@Api(value = "/member",
        tags = "members",
        produces = MediaType.APPLICATION_JSON_VALUE)
public interface MemberController {
    @ApiOperation(value = "Buscar los datos del socio por su numero de id",
            response = MemberEntity.class,
            httpMethod = "GET",
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses(value = {
            @ApiResponse(code = 200,
                    message = "Busqueda Exitosa",
                    response = MemberEntity.class
            ),
            @ApiResponse(code = 404,
                    message = "El numero de socio no existe"
            ),
            @ApiResponse(code = 500,
                    message = "No se pudo conectar a la BD"
            )
    })
    MemberEntity getMemberById(HttpServletRequest request,
                               @ApiParam(value = "Id de socio")
                               BigInteger memberId);

    @ApiOperation(value = "Buscar los datos del socio por su nombre",
            response = MemberEntity.class,
            httpMethod = "GET",
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses(value = {
            @ApiResponse(code = 200,
                    message = "Busqueda Exitosa",
                    response = MemberEntity.class
            ),
            @ApiResponse(code = 404,
                    message = "El numero de socio no existe"
            ),
            @ApiResponse(code = 500,
                    message = "No se pudo conectar a la BD"
            )
    })
    MemberEntity getMemberByName(HttpServletRequest request,
                                 @ApiParam(value = "Nombre de socio")
                                 String Name);

    @ApiOperation(value = "Listar socios",
            response = MemberEntity.class,
            httpMethod = "GET",
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses(value = {
            @ApiResponse(code = 200,
                    message = "Busqueda Exitosa",
                    response = MemberEntity.class
            ),
            @ApiResponse(code = 404,
                    message = "Error !!!"
            ),
            @ApiResponse(code = 500,
                    message = "No se pudo conectar a la BD"
            )
    })
    List<MemberEntity> getMemberList(HttpServletRequest request);

    @ApiOperation(value = "Registrar un nuevo socio")
    @ApiResponses(value = {
            @ApiResponse(code = 200,
                    message = "Busqueda Exitosa",
                    response = MemberEntity.class
            ),
            @ApiResponse(code = 404,
                    message = "Error en parametros ingresados"
            ),
            @ApiResponse(code = 500,
                    message = "No se pudo conectar a la BD"
            )
    })
    ResponseEntity<String> createMember(MemberEntity member);

    @ApiOperation(value = "Modificar datos de un socio")
    @ApiResponses(value = {
            @ApiResponse(code = 200,
                    message = "Busqueda Exitosa",
                    response = MemberEntity.class
            ),
            @ApiResponse(code = 404,
                    message = "Error en parametros ingresados"
            ),
            @ApiResponse(code = 500,
                    message = "No se pudo conectar a la BD"
            )
    })
    ResponseEntity<String> updateMember(BigInteger memberId, MemberEntity member);

    @ApiOperation(value = "Eliminar un socio")
    @ApiResponses(value = {
            @ApiResponse(code = 200,
                    message = "Busqueda Exitosa",
                    response = MemberEntity.class
            ),
            @ApiResponse(code = 404,
                    message = "El numero de socio no existe"
            ),
            @ApiResponse(code = 500,
                    message = "No se pudo conectar a la BD"
            )
    })
    ResponseEntity<String> deleteMember(BigInteger memberId);
}
