package com.example.repository;

import com.example.entity.Usuario;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends MongoRepository <Usuario, String> {

    @Query(value = "select user from Usuario user where user.id = :idUsuario")
    Usuario buscaUsuarioPorId(@Param("idUsuario") String idUsuario);

}
