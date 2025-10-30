package com.sigpi.imovel;

import java.util.List;
import org.springframework.util.StringUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImovelService {
	
	private ImovelRepository imovelRepository;
	
	public ImovelService(ImovelRepository imovelRepository) {
		super();
		this.imovelRepository = imovelRepository;
	}

	public List<Imovel> listarTodas(){
		return imovelRepository.findAll();
	}
	
	public Imovel buscarPorId(Integer id){
		return imovelRepository.findById(id).get();
	}
	
	public Imovel salvar(ImovelRequest req) {
        Imovel entity = new Imovel();
        entity.setDescricao(req.descricao());
        entity.setRua(req.rua());
        entity.setNumero(req.numero());
        entity.setBairro(req.bairro());
        entity.setCidade(req.cidade());
        entity.setCep(req.cep());

        if (StringUtils.hasText(req.fotoBase64())) {
            entity.setFoto(sanitizeBase64(req.fotoBase64()));
        }

        return imovelRepository.save(entity);
	}
	
    private String sanitizeBase64(String base64) {
        String b64 = base64.trim();
        int idx = b64.indexOf(","); 
        if (b64.startsWith("data:") && idx > 0) {
            b64 = b64.substring(idx + 1);
        }

        b64 = b64.replaceAll("\\s", "");
        return b64;
    }
	
	public void deletar(Integer id) {
		Imovel imovel = imovelRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Imóvel inexistente"));
		
		imovelRepository.delete(imovel);
	}
	
}