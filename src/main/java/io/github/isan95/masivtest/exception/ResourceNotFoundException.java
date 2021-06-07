package io.github.isan95.masivtest.exception;

public class ResourceNotFoundException extends RuntimeException{
	private static final long serialVersionUID = -7866742162440519185L;
	public ResourceNotFoundException() {
		super();
	}
	public ResourceNotFoundException(final String message) {
		super(message);
	}
}
