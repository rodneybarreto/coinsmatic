docker network create --driver bridge coinsmatic-net

docker run --name coinsmaticdb-serv \
    --network=coinsmatic-net \
    -e MARIADB_DATABASE=coinsmaticdb \
    -e MARIADB_USER=${MARIADB_USER} \
    -e MARIADB_PASSWORD=${MARIADB_PASS} \
    -e MARIADB_ROOT_PASSWORD=${MARIADB_ROOT_PASS} \
    -p 3306:3306 \
    -v ${HOST_MARIADB_VOLUME}:/var/lib/mysql \
    -d mariadb:10.11