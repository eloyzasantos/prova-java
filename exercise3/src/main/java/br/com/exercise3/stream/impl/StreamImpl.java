package br.com.exercise3.stream.impl;

import java.util.NoSuchElementException;

import br.com.exercise3.stream.Stream;

/**
 * @author ebenedito
 *
 */
public class StreamImpl implements Stream {

	private final char[] stream;
	private int index;
	
	public StreamImpl(String value) {
		if(value == null || value.isEmpty()){
			throw new NoSuchElementException("Stream is empty");
		}
		this.stream = value.toCharArray();
		this.index = 0;
	}

	/**
	 * Get next char
	 * 
	 * @return next char
	 */
	public char getNext() {
		return stream[index++];
	}

	/**
	 * Verify if has a next char
	 * 
	 * @return if has a next char
	 */
	public boolean hasNext() {
		return index < stream.length;
	}

}
