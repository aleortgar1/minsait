package com.prueba.minsait.exception;

import java.io.Serial;

public class RepositoryException extends Exception {

@Serial
private static final long serialVersionUID = -1861833952375251263L;

	public RepositoryException(String message) {
		super(message);
	}

}
