package com.mudi.mvc.repository;

import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mudi.mvc.model.Pedido;
import com.mudi.mvc.model.StatusPedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {

	@Cacheable("books")
	List<Pedido> findByStatus(StatusPedido aguardando, Pageable sort);

	@Query("select p from Pedido p join p.user u where u.username = :username")
	List<Pedido> findAllByUsuario(@Param("username") String username);

	@Query("select p from Pedido p join p.user u where p.status = :status and u.username = :username")
	List<Pedido> findByStatusEUsuario(@Param("status") StatusPedido status, @Param("username") String username);

}
