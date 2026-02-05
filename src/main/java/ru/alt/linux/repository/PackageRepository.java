package ru.alt.linux.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.alt.linux.model.PackageEntity;

import java.util.List;

@Repository
public interface PackageRepository extends JpaRepository<PackageEntity, Long> {
    List<PackageEntity> findByBranchAndArch(String branch, String arch);

    List<PackageEntity> findByBranch(String branch);

    Page<PackageEntity> findByBranch(String branch, Pageable pageable);
}
