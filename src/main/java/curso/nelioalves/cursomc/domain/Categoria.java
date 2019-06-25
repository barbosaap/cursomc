package curso.nelioalves.cursomc.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Categoria {

	@Id
	@GeneratedValue(
		strategy = GenerationType.IDENTITY)
	@Column(name = "id_cat")
	@EqualsAndHashCode.Include
	private Integer id;
	
	@Column(name = "nm_cat", length = 150)
	private String nome;
}
