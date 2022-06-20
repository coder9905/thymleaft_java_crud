package uz.baxtiyor.thymleaft_java.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.baxtiyor.thymleaft_java.entity.Admin;

import java.util.UUID;
@Repository
public interface AdminRepository extends JpaRepository<Admin, UUID> {
}
