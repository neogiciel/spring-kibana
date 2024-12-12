﻿## <h1>Application Spring Boot Kibana</h1>
***
<table>
  <tr>
    <td><img src="https://blog.mossroy.fr/wp-content/uploads/2019/09/spring-boot-logo.png" alt="drawing" height="280px"/></td>
    <td><img src="https://iconape.com/wp-content/files/ef/351194/svg/351194.svg" alt="drawing" height="280px"/></td>
    
  </tr>
</table>

## Informations Générales
***
Exemple de Visualisation de Logs via Kibana.
Les logs géneré par une applcation Spring-boot sont adressé au moteur de recherche ELK via un fournisseur Logstash

## Technologies
***
Technologies utilisées:
* Java 17 
* Maven 3.6
* Spring-boot: 3.2
## Instalation
***
Docker-compose
```
version: '3'
 
services:
  elasticsearch:
    image: docker.elastic.co/elasticsearch/elasticsearch:7.12.0
    container_name: elasticsearch
    environment:
      - discovery.type=single-node
      - bootstrap.memory_lock=true
      - "ES_JAVA_OPTS=-Xms512m -Xmx512m"
      - ELASTIC_PASSWORD=test
      - xpack.security.enabled=true
    volumes:
      - elasticsearch-data:/usr/share/elasticsearch/data
    ports:
      - 9200:9200
    networks:
      - elastic
  logstash:
    image: docker.elastic.co/logstash/logstash:7.12.0
    networks:
      - elastic
    depends_on:
      - elasticsearch
    ports:
      - 5000:5000
    volumes:
      - ./logstash/pipeline:/usr/share/logstash/pipeline
  kibana:
    image: docker.elastic.co/kibana/kibana:7.12.0
    container_name: kibana
    environment:
      - ELASTICSEARCH_USERNAME=elastic
      - ELASTICSEARCH_PASSWORD=test
      - ELASTICSEARCH_URL=http://elasticsearch:9200
      - ELASTICSEARCH_HOSTS=http://elasticsearch:9200
    ports:
      - 5601:5601
    depends_on:
      - elasticsearch
    networks:
      - elastic
volumes:
  elasticsearch-data:
    driver: local
networks:
  elastic:
    driver: bridge
```
Lancement du Docker-compose
docker-compose up -d

Lancement de l'application Spring-boot<br>
```
$ mvn  clean
$ mvn spring-boot:run
```
Le service est accessible sur http://localhost:8080

## FAQs
***
La Visualisation des Logs se fait dans Kibana:
http://localhost:5601/app/home#/

Créer une collection 
Stack Management > Crée un nouvel Index patterns 
myapplication-*
puis selectionner timestamp

Aller dans :
Observabilty>Logs>Selectionne Kibana Logs 


