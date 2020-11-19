package com.imtinene.bookstore.entities;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "nomB", types = { Book.class })
public interface BookProjection {
	public String getNomBook();

}
