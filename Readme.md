# 🏦 API Bancaire

API REST développée avec **Java et Spring Boot** permettant de gérer les fonctionnalités principales d'un système bancaire.

 🚧 **Projet actuellement en cours de développement.**
Certaines fonctionnalités sont encore en cours d'implémentation.

## 🎯 Objectif

L'objectif de ce projet est de développer une API bancaire moderne permettant notamment de gérer les utilisateurs, les comptes bancaires et les opérations associées.

Le projet me permet également de mettre en pratique les concepts de développement backend avec **Spring Boot, Spring Security, JWT, JPA/Hibernate et PostgreSQL**.

## 🛠️ Technologies

* Java
* Spring Boot
* Spring Security
* JWT
* Spring Data JPA
* Hibernate
* PostgreSQL
* Maven
* REST API
* Postman
* Git / GitHub

## 🔐 Sécurité

L'API utilise **Spring Security** pour sécuriser les endpoints.

L'authentification repose sur :

* Authentification utilisateur
* Mot de passe chiffré avec BCrypt
* Génération d'un token JWT
* Vérification du token pour les endpoints protégés
* Gestion des rôles et autorisations

## ✅ Fonctionnalités réalisées

*  Création d'un utilisateur
*  Connexion utilisateur
*  Vérification des identifiants
*  Hashage des mots de passe avec BCrypt
*  Génération d'un JWT
*  Authentification avec Spring Security
*  Connexion à PostgreSQL
*  Gestion des utilisateurs avec JPA/Hibernate
*  Tests des endpoints avec Postman
*  Création d'un compte bancaire
*  Consultation d'un compte
*  Gestion du solde

## 🚧 En cours de développement


*  Virements entre comptes
*  Historique des transactions
*  Gestion complète des autorisations
*  Tests unitaires et d'intégration

## 📂 Architecture

Le projet suit une architecture en plusieurs couches :

```text
Controller
    ↓
Service
    ↓
Repository
    ↓
Database
```

Avec notamment :

```text
src/main/java/
├── controller/
├── service/
├── repository/
├── entity/
├── dto/
├── security/
└── config/
```

## ▶️ Installation

### 1. Cloner le projet


git clone https://github.com/ILYAS403/API_bancaire.git


### 2. Configurer PostgreSQL

Créer une base de données PostgreSQL puis configurer les informations de connexion dans :

```text
src/main/resources/application.properties
```

Exemple :

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/api_bancaire
spring.datasource.username=postgres
spring.datasource.password=YOUR_PASSWORD
```

> ⚠️ Les informations sensibles ne sont pas présentes dans le repository.

### 3. Lancer l'application

Avec Maven :

```bash
./mvnw spring-boot:run
```

ou depuis IntelliJ IDEA / Eclipse.

## 🧪 Tests avec Postman

Exemple de connexion :

```http
POST /api/users/login
```

```json
{
  "email": "user@example.com",
  "password": "********"
}
```

Une fois authentifié, le serveur génère un **JWT** permettant d'accéder aux endpoints protégés.


## 👨‍💻 Auteur

**Ilyas Dahir Houssein**

Développeur Full-Stack / Backend Java