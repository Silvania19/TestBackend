package com.testBackend.testBackend.repository;

import com.testBackend.testBackend.models.TipoDocumento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TipoDocumentoRepository extends JpaRepository<TipoDocumento, Integer> {
}
