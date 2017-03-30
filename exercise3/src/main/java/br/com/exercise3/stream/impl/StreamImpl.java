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

	public char getNext() {
		return stream[index++];
	}

	public boolean hasNext() {
		return index < stream.length;
	}

}
