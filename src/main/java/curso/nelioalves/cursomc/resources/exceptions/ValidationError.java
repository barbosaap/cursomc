package curso.nelioalves.cursomc.resources.exceptions;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;

public class ValidationError extends StandardError {

	@Getter
	private List<FieldMessage> errors = new ArrayList<FieldMessage>();

	public ValidationError(Integer status, String msg, Long timeStamp) {
		super(status, msg, timeStamp);
	}
	
	public void addError(String fieldName, String message) {
		errors.add(new FieldMessage(fieldName, message));
	}
	
}
