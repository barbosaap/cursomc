package curso.nelioalves.cursomc.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Categoria {

	@Id
	@GeneratedValue(
		strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private Integer id;
	
	private String nome;
	
	@ManyToMany(mappedBy = "categorias")
	private List<Produto> produtos = new ArrayList<Produto>();

	public Categoria(Integer id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}
}
