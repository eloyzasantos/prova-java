package br.com.exercise3.stream;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import br.com.exercise3.stream.impl.StreamImpl;

@RunWith(MockitoJUnitRunner.class)
public class StreamTest {
	
	@Test(expected = NoSuchElementException.class)
	public void mustThrowNoSuchElementExceptionWhenIsEmpty() throws NoSuchElementException {
		new StreamImpl("");
	}

	@Test(expected = NoSuchElementException.class)
	public void mustThrowNoSuchElementExceptionWhenIsNull() throws NoSuchElementException {
		new StreamImpl(null);
	}
	
	@Test
	public void mustReadStream() throws NoSuchElementException {
		Stream stream = new StreamImpl("aBcD");
		
		List<Character> list = new ArrayList<Character>();
		while (stream.hasNext()) {
			list.add(stream.getNext());
		}
		
		assertEquals('a', list.get(0).charValue());
		assertEquals('B', list.get(1).charValue());
		assertEquals('c', list.get(2).charValue());
		assertEquals('D', list.get(3).charValue());
	}

}
