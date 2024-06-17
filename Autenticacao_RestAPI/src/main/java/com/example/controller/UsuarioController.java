package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.service.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/salvar")
    public Object salvarUsuario(@RequestParam("idUsuario") String idUsuario, @RequestParam("nomeUsuario") String nomeUsuario, @RequestParam("senha") String senha, @RequestParam("identificadorTipoUsuario") long identificadorTipoUsuario) {
        try{
            return this.usuarioService.cadastraUsuario(idUsuario, nomeUsuario, senha, identificadorTipoUsuario);
        } catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro não tratado: " + e.getMessage());
        }
    }

    @DeleteMapping("/deletar")
    public Object deletarUsuario(@RequestParam("idUsuario") String idUsuario){
        try{
            return this.usuarioService.deletarUsuario(idUsuario);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro não tratado: " + e.getMessage());
        }
    }

    @GetMapping("/obtemTodos")
    public Object obtemTodos(){
        try{
            return this.usuarioService.obtemTodos();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro não tratado: " + e.getMessage());
        }
    }

    @GetMapping("/obtemUsuarioPorId")
    public Object obtemUsuarioPorId(@RequestParam("idUsuario") String idUsuario){
        try{
            return this.usuarioService.findUsuarioById(idUsuario);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro não tratado: " + e.getMessage());
        }
    }

}
