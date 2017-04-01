package br.com.exercise3;

import static org.junit.Assert.assertEquals;

import java.util.NoSuchElementException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class MainTest {
	
	@Test(expected = NoSuchElementException.class)
	public void mustThrowNoSuchElementExceptionWhenNotFound() throws NoSuchElementException {
		Main.firstChar("AabBABacafa");
	}

	@Test
	public void mustReturnE() throws NoSuchElementException {
		assertEquals('e', Main.firstChar("aAbBABacafe").charValue());
	}

	@Test
	public void mustReturnA() throws NoSuchElementException {
		assertEquals('a', Main.firstChar("AAbBABacafe").charValue());
	}

	@Test
	public void mustReturnI() throws NoSuchElementException {
		assertEquals('i', Main.firstChar("aAbBABacafweCi").charValue());
	}

}
