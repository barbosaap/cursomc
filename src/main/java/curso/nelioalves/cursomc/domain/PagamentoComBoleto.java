package curso.nelioalves.cursomc.domain;

import java.util.Date;

import javax.persistence.Entity;

import curso.nelioalves.cursomc.domain.enums.EstadoPagamento;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = true)
@NoArgsConstructor
@Entity
public class PagamentoComBoleto extends Pagamento {

	private Date dataVencimento;
	private Date dataPagamento;
	
	public PagamentoComBoleto(Integer id, EstadoPagamento estado, Pedido pedido,
			Date dataVencimento, Date dataPagamento) {
		super(id, estado, pedido);
		this.dataVencimento = dataVencimento;
		this.dataPagamento = dataPagamento;
	}
	
	
}
