package grapservice.com.grapservice.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import grapservice.com.grapservice.entity.GrapUserEntity;

public interface GrapUserRepository extends JpaRepository<GrapUserEntity, Integer> {

	Optional<GrapUserEntity> findByGmailAndPassword(String gmail, String password);
	
	Page<GrapUserEntity> findAllByStatus(String status, Pageable page);
	Optional<GrapUserEntity> findById(Integer id);
	
}
