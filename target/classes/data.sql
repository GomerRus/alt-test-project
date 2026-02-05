INSERT INTO packages (branch, arch, name, epoch, version, release, disttag, buildtime, source)
VALUES
    ('sisyphus', 'x86_64', 'bash', 0, '5.2.15', '1.alt1', 'altlinux/Sisyphus', 1700000000, 'bash-5.2.15.src.rpm'),
    ('sisyphus', 'aarch64', 'systemd', 3, '253.9', '2.alt1', 'altlinux/Sisyphus', 1710000000, 'systemd-253.9.src.rpm'),
    ('sisyphus', 'i586', 'util-linux', 1, '2.37.2', '4.alt1', 'altlinux/Sisyphus', 1690000000, 'util-linux-2.37.2.src.rpm'),
    ('sisyphus', 'armhf', 'nginx', 0, '1.23.0', '1.alt1', 'altlinux/Sisyphus', 1720000000, 'nginx-1.23.0.src.rpm'),
    ('sisyphus', 'x86_64', 'python3', 2, '3.10.6', '7.alt1', 'altlinux/Sisyphus', 1730000000, 'python3-3.10.6.src.rpm'),
    ('sisyphus', 'noarch', 'firefox', 0, '111.0.5563.110', '1.alt1', 'altlinux/Sisyphus', 1740000000, 'firefox-111.0.5563.110.src.rpm');

INSERT INTO packages (branch, arch, name, epoch, version, release, disttag, buildtime, source)
VALUES
    ('p10', 'x86_64', 'bash', 0, '5.1.16', '3.alt1', 'p10', 1680000000, 'bash-5.1.16.src.rpm'),
    ('p10', 'armhf', 'nginx', 0, '1.22.1', '1.p10', 'p10', 1672531200, 'nginx-1.22.1.src.rpm'),
    ('p10', 'noarch', 'python3', 2, '3.9.13', '5.alt1', 'p10', 1660000000, 'python3-3.9.13.src.rpm'),
    ('p10', 'x86_64', 'postgresql', 0, '14.5', '3.p10', 'p10', 1650000000, 'postgresql-14.5.src.rpm'),
    ('p10', 'aarch64', 'curl', 0, '7.82.0', '2.p10', 'p10', 1640000000, 'curl-7.82.0.src.rpm'),
    ('p10', 'i586', 'openssh', 2, '8.9.1', '3.p10', 'p10', 1630000000, 'openssh-8.9.1.src.rpm'),
    ('p10', 'x86_64', 'vim', 0, '9.0.1234', '1.p10', 'p10', 1620000000, 'vim-9.0.1234.src.rpm'),
    ('p10', 'armhf', 'git', 0, '2.34.1', '2.p10', 'p10', 1610000000, 'git-2.34.1.src.rpm'),
    ('p10', 'aarch64', 'openssl', 1, '3.0.7', '1.p10', 'p10', 1600000000, 'openssl-3.0.7.src.rpm'),
    ('p10', 'noarch', 'java-11-openjdk', 0, '11.0.17', '1.p10', 'p10', 1590000000, 'java-11-openjdk-11.0.17.src.rpm'),
    ('p10', 'i586', 'glibc', 0, '2.33', '4.p10', 'p10', 1580000000, 'glibc-2.33.src.rpm'),
    ('p10', 'x86_64', 'zlib', 0, '1.2.12', '1.p10', 'p10', 1570000000, 'zlib-1.2.12.src.rpm'),
    ('p10', 'armhf', 'sqlite', 0, '3.36.0', '1.p10', 'p10', 1560000000, 'sqlite-3.36.0.src.rpm'),
    ('p10', 'aarch64', 'libxml2', 0, '2.9.12', '2.p10', 'p10', 1550000000, 'libxml2-2.9.12.src.rpm'),
    ('p10', 'noarch', 'perl', 5, '5.34.0', '1.p10', 'p10', 1540000000, 'perl-5.34.0.src.rpm'),
    ('p10', 'i586', 'grep', 0, '3.7', '1.p10', 'p10', 1530000000, 'grep-3.7.src.rpm'),
    ('p10', 'x86_64', 'tar', 0, '1.34', '1.p10', 'p10', 1520000000, 'tar-1.34.src.rpm'),
    ('p10', 'armhf', 'wget', 0, '1.21.3', '1.p10', 'p10', 1510000000, 'wget-1.21.3.src.rpm'),
    ('p10', 'aarch64', 'bzip2', 0, '1.0.8', '1.p10', 'p10', 1500000000, 'bzip2-1.0.8.src.rpm'),
    ('p10', 'noarch', 'cpio', 0, '2.13', '1.p10', 'p10', 1490000000, 'cpio-2.13.src.rpm');

INSERT INTO packages (branch, arch, name, epoch, version, release, disttag, buildtime, source)
VALUES
    ('testing', 'x86_64', 'firefox', 0, '110.0.1', '1.alt1', 'altlinux/Testing', 1720000000, 'firefox-110.0.1.src.rpm'),
    ('testing', 'aarch64', 'postgresql', 0, '15.3', '2.alt1', 'altlinux/Testing', 1730000000, 'postgresql-15.3.src.rpm'),
    ('testing', 'armhf', 'bash', 0, '5.2.16', '2.alt1', 'altlinux/Testing', 1750000000, 'bash-5.2.16.src.rpm'),
    ('testing', 'x86_64', 'nginx', 0, '1.24.0', '1.alt1', 'altlinux/Testing', 1760000000, 'nginx-1.24.0.src.rpm'),
    ('testing', 'noarch', 'util-linux', 1, '2.38.0', '5.alt1', 'altlinux/Testing', 1770000000, 'util-linux-2.38.0.src.rpm'),
    ('testing', 'aarch64', 'python3', 2, '3.11.1', '7.alt1', 'altlinux/Testing', 1780000000, 'python3-3.11.1.src.rpm');

INSERT INTO packages (branch, arch, name, epoch, version, release, disttag, buildtime, source)
VALUES
    ('p11', 'x86_64', 'bash', 0, '5.3.0', '1.p11', 'p11', 1800000000, 'bash-5.3.0.src.rpm'),
    ('p11', 'aarch64', 'systemd', 3, '254.0', '2.p11', 'p11', 1810000000, 'systemd-254.0.src.rpm'),
    ('p11', 'i586', 'util-linux', 1, '2.38.1', '6.p11', 'p11', 1820000000, 'util-linux-2.38.1.src.rpm'),
    ('p11', 'armhf', 'nginx', 0, '1.25.0', '3.p11', 'p11', 1830000000, 'nginx-1.25.0.src.rpm'),
    ('p11', 'noarch', 'python3', 2, '3.12.0', '8.p11', 'p11', 1840000000, 'python3-3.12.0.src.rpm'),
    ('p11', 'x86_64', 'firefox', 0, '112.0.5563.115', '2.p11', 'p11', 1850000000, 'firefox-112.0.5563.115.src.rpm'),
    ('p11', 'aarch64', 'postgresql', 0, '15.5', '4.p11', 'p11', 1860000000, 'postgresql-15.5.src.rpm'),
    ('p11', 'armhf', 'curl', 0, '7.83.0', '5.p11', 'p11', 1870000000, 'curl-7.83.0.src.rpm'),
    ('p11', 'x86_64', 'vim', 0, '9.0.1235', '1.p11', 'p11', 1890000000, 'vim-9.0.1235.src.rpm'),
    ('p11', 'aarch64', 'openssl', 1, '3.0.8', '2.p11', 'p11', 1900000000, 'openssl-3.0.8.src.rpm'),
    ('p11', 'i586', 'glibc', 0, '2.35', '5.p11', 'p11', 1910000000, 'glibc-2.35.src.rpm'),
    ('p11', 'armhf', 'sqlite', 0, '3.37.0', '3.p11', 'p11', 1920000000, 'sqlite-3.37.0.src.rpm'),
    ('p11', 'noarch', 'perl', 5, '5.35.0', '2.p11', 'p11', 1930000000, 'perl-5.35.0.src.rpm'),
    ('p11', 'x86_64', 'zlib', 0, '1.2.13', '1.p11', 'p11', 1940000000, 'zlib-1.2.13.src.rpm'),
    ('p11', 'aarch64', 'libxml2', 0, '2.9.13', '3.p11', 'p11', 1950000000, 'libxml2-2.9.13.src.rpm'),
    ('p11', 'i586', 'grep', 0, '3.8', '2.p11', 'p11', 1960000000, 'grep-3.8.src.rpm'),
    ('p11', 'armhf', 'wget', 0, '1.22.0', '4.p11', 'p11', 1970000000, 'wget-1.22.0.src.rpm'),
    ('p11', 'noarch', 'cpio', 0, '2.14', '1.p11', 'p11', 1980000000, 'cpio-2.14.src.rpm'),
    ('p11', 'x86_64', 'tar', 0, '1.35', '2.p11', 'p11', 1990000000, 'tar-1.35.src.rpm'),
    ('p11', 'aarch64', 'bzip2', 0, '1.0.9', '3.p11', 'p11', 2000000000, 'bzip2-1.0.9.src.rpm'),
    ('p11', 'i586', 'less', 0, '590', '1.p11', 'p11', 2010000000, 'less-590.src.rpm'),
    ('p11', 'armhf', 'mariadb', 0, '10.6.12', '1.p11', 'p11', 2020000000, 'mariadb-10.6.12.src.rpm'),
    ('p11', 'noarch', 'java-17-openjdk', 0, '17.0.5', '1.p11', 'p11', 2030000000, 'java-17-openjdk-17.0.5.src.rpm'),
    ('p11', 'i586', 'openssh', 2, '9.0.0', '7.p11', 'p11', 1880000000, 'openssh-9.0.0.src.rpm');