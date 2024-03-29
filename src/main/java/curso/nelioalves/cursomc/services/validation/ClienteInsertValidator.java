package curso.nelioalves.cursomc.services.validation;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import curso.nelioalves.cursomc.domain.Cliente;
import curso.nelioalves.cursomc.domain.enums.TipoCliente;
import curso.nelioalves.cursomc.dto.ClienteNewDTO;
import curso.nelioalves.cursomc.repositories.ClienteRepository;
import curso.nelioalves.cursomc.resources.exceptions.FieldMessage;
import curso.nelioalves.cursomc.services.validation.utils.BR;

public class ClienteInsertValidator implements ConstraintValidator<ClienteInsert, ClienteNewDTO> {

	@Autowired
	private ClienteRepository repo;
	
	@Override
	public void initialize(ClienteInsert ann) {
	};	
	
	@Override
	public boolean isValid(ClienteNewDTO objDto, ConstraintValidatorContext context) {
	
		List<FieldMessage> list = new ArrayList<FieldMessage>();

		if (objDto.getTipo().equals(TipoCliente.PESSOAFISICA.getCod())
				&& !BR.isValidCPF(objDto.getCpfOuCnpj())) {
			list.add(new FieldMessage("CpfOuCnpj", "CPF Inválido"));
		}
		
		if (objDto.getTipo().equals(TipoCliente.PESSOAJURIDICA.getCod())
				&& !BR.isValidCNPJ(objDto.getCpfOuCnpj())) {
			list.add(new FieldMessage("cpfOuCnpj", "CNPJ Inválido"));
		}
		
		Cliente cli = repo.findByEmail(objDto.getEmail());
		if (cli != null) {
			list.add(new FieldMessage("email", "Email já existente"));
		}
		
		for (FieldMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage())
				.addPropertyNode(e.getFieldName()).addConstraintViolation();
		}
		
		return list.isEmpty();
	}
	
}
