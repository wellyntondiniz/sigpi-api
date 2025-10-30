package com.sigpi.imovel;

public record ImovelRequest(
        Long id,
        String titulo,
        String descricao,
        Boolean disponivel,
        String fotoBase64,       
        String fotoContentType,  
        String fotoNome,     
        String rua,
        Integer numero,
        String bairro,
        String cidade,
        String cep
) {}