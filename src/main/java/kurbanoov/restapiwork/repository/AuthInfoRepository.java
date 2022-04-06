package kurbanoov.restapiwork.repository;

import kurbanoov.restapiwork.entity.AuthInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface AuthInfoRepository extends JpaRepository<AuthInfo, Long> {
    Optional<AuthInfo> findByEmail(String email);
}
