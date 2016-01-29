package org.clael.poc.ws.jettyws.service;

import java.util.GregorianCalendar;

import javax.jws.WebService;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;

import org.clael.poc.ws.jettyws.BookListingInterface;
import org.clael.poc.ws.jettyws.BookListingRequestType;
import org.clael.poc.ws.jettyws.BookListingResponseType;
import org.clael.poc.ws.jettyws.BookType;

@WebService
public class BookListing implements BookListingInterface {

	@Override
	public BookListingResponseType fetchBooks(BookListingRequestType bookServiceRequest) {
		final BookListingResponseType response = new BookListingResponseType();
		
		for (int i = 0 ; i < bookServiceRequest.getLimit() ; i++) {
			final BookType book = new BookType();
			book.setAuthor("Nietzsche");
			try {
				book.setPublished(DatatypeFactory.newInstance().newXMLGregorianCalendar(new GregorianCalendar(1891, 12, 11)));
			} catch (DatatypeConfigurationException e) {				
			}
			book.setTitle("Thus Spake Zarathustra " + i);
			response.getBook().add(book);
		}
		return response;
	}

}
