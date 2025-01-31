# TP1

Ce projet est une application basée sur **Spring Boot**, utilisant **Spring Data JPA** pour la gestion de la persistance, et **JUnit 5** pour les tests unitaires. Ce projet contient des fonctionnalités de base pour gérer des entités, avec un focus sur des exemples liés à un modèle de pays (`Country`).

## Fonctionnalités

- **Gestion des entités** : CRUD pour les entités telles que `Country`.
- **Tests unitaires** : Tests pour valider le comportement des repositories et respecter les contraintes d'intégrité.
- **Ajout de données spécifiques** : Utilisation de fichiers SQL pour insérer des données pour tester les scénarios.

## Configuration du projet

Ce projet utilise les technologies et dépendances suivantes configurées dans [`pom.xml`](pom.xml):

- **Spring Data JPA** : Gestion de la persistance.
- **JUnit 5** : Framework de test.
- **Lombok** : Génération automatique du code (loggers, getters/setters...).

### Prérequis

Avant de lancer ce projet, assurez-vous d'avoir :

1. **Java 21.x** installé
2. **Maven** pour gérer les dépendances

## Instructions d'installation et d'exécution

1. Clonez le dépôt :

   ```bash
   git clone https://github.com/bastide/cities_enonce.git
   cd monprojet
   ```

2. Examinez la configuration de la base de données dans le fichier [`application.properties`](src/main/resources/application.properties) :

   ```
   spring.datasource.url=jdbc:h2:file:~/h2/tp1
   spring.datasource.username=sa
   spring.datasource.password=
   spring.jpa.hibernate.ddl-auto=create
   ```

3. Lancez l'application avec Maven :

   ```bash
   mvn clean spring-boot:run
   ```

4. Exécutez les tests pour vérifier que tout fonctionne correctement :

   ```bash
   mvn test
   ```

## Tests importants

Ce projet inclut des [tests](src/test/java/monprojet/dao/CountryRepositoryTest.java) pour vérifier la bonne mise en œuvre du modèle de données :

- **Vérification de l'unicité des noms de pays** :
  Teste que deux pays ne peuvent pas avoir le même nom à travers une contrainte en base de données.

- **Comptage d'enregistrements dans la base** : 
  Teste le bon chargement des données initiales via [`data.sql`](src/main/resources/data.sql).

## Structure du projet
### package `entity`

Contient les entités principales utilisées dans l'application comme `Country`, qui représente les pays dans l'application.


### package `dao`

Contient les repositories pour interagir avec la base de données. 

### `test`

Vous trouverez ici les tests couvrant les contraintes et les comportements attendus.

## SQL de Test

Voici un exemple de fichier SQL utilisé pendant les tests pour insérer des données initiales dans [`data.sql`](src/main/resources/data.sql) :

```sql
INSERT INTO Country (code, name) VALUES ('FR', 'France');
INSERT INTO Country (code, name) VALUES ('US', 'United States');
INSERT INTO Country (code, name) VALUES ('JP', 'Japan');
```

