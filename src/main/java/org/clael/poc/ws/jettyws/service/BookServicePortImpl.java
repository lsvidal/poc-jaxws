package org.clael.poc.ws.jettyws.service;

import java.util.GregorianCalendar;

import javax.jws.WebService;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;

import org.clael.poc.ws.jettyws.BookServicePortType;
import org.clael.poc.ws.jettyws.BookServiceRequestType;
import org.clael.poc.ws.jettyws.BookServiceResponseType;
import org.clael.poc.ws.jettyws.BookType;

@WebService
public class BookServicePortImpl implements BookServicePortType {

	@Override
	public BookServiceResponseType fetchBooks(BookServiceRequestType bookServiceRequest) {
		final BookServiceResponseType response = new BookServiceResponseType();
		
		for (int i = 0 ; i < bookServiceRequest.getLimit() ; i++) {
			final BookType book = new BookType();
			book.setAuthor("Nietzsche" + i);
			try {
				book.setPublished(DatatypeFactory.newInstance().newXMLGregorianCalendar(new GregorianCalendar(1891, 12, 11)));
			} catch (DatatypeConfigurationException e) {				
			}
			book.setTitle("Thus Spake Zarathustra");
			response.getBook().add(book);
		}
		return response;
	}

}
