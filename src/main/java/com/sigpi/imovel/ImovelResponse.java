package com.sigpi.imovel;

public record ImovelResponse(
        Integer id,
        String descricao,
        String rua,
        Integer numero,
        String bairro,
        String cidade,
        String cep,
        String foto 
) {
    public static ImovelResponse from(Imovel e) {
        return new ImovelResponse(
                e.getId(),
                e.getDescricao(),
                e.getRua(),
                e.getNumero(),
                e.getBairro(),
                e.getCidade(),
                e.getCep(),
                e.getFoto()
        );
    }
}
