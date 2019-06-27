package curso.nelioalves.cursomc.dto;

import curso.nelioalves.cursomc.domain.Categoria;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
public class CategoriaDTO {

	private Integer id;
	
	private String nome;
	
	public CategoriaDTO(Categoria cat) {
		this.id = cat.getId();
		this.nome = cat.getNome();
	}
}
