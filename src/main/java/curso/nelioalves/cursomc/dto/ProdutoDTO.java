package curso.nelioalves.cursomc.dto;

import curso.nelioalves.cursomc.domain.Produto;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
public class ProdutoDTO {

	private Integer id;
	
	private String nome;
	
	private Double preco;
	
	public ProdutoDTO(Produto obj) {
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.preco = obj.getPreco();
	}
}
