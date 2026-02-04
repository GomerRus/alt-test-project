package ru.alt.linux.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "packages")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PackageEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Long id;

    @Column(name = "branch", nullable = false, length = 255)
    String branch;

    @Column(name = "arch", nullable = false, length = 255)
    String arch;

    @Column(name = "name", nullable = false, length = 255)
    String name;

    @Column(name = "epoch", nullable = false)
    int epoch = 0;

    @Column(name = "version", nullable = false, length = 255)
    String version;

    @Column(name = "release", nullable = false, length = 255)
    String release;

    @Column(name = "disttag", nullable = false, length = 255)
    String disttag;

    @Column(name = "buildtime", nullable = false)
    long buildtime = 0L;

    @Column(name = "source", nullable = false, length = 255)
    String source;
}
