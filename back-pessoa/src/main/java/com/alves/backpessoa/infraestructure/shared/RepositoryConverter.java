package com.alves.backpessoa.infraestructure.shared;

import java.io.Serializable;

public interface RepositoryConverter<D extends Serializable, E extends Serializable> {

    default D mapToDomain(final E entity) {
        throw new UnsupportedOperationException();
    }

    default E mapToEntity(final D domain) {
        throw new UnsupportedOperationException();
    }
}
