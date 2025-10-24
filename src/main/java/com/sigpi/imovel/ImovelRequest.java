package com.sigpi.imovel;

public record ImovelRequest(
        Long id,
        String titulo,
        String descricao,
        Boolean disponivel,
        String fotoBase64,       
        String fotoContentType,  
        String fotoNome          
) {}