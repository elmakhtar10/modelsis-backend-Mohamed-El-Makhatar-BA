# modelsis-backend-Mohamed-El-Makhatar-BA
Le README commence juste après le bloc de code avec les trois petits accents (```markdown) et se termine juste avant la fermeture de ce bloc.

Voici le texte **exact** que tu dois copier. Commence la copie à partir de `# Test Technique` et arrête-toi après le dernier bloc de code (après `ddl-auto=update`).

---

# Test Technique : Gestion de Produits - Modelsis

Ce projet consiste en la réalisation d'une API Backend pour la gestion de produits et de leurs types, réalisée dans le cadre d'un test technique pour **Modelsis**.

## 👤 Auteur

**Mohamed El Makhatar BA**

## 🚀 Technologies utilisées

* **Java 21**
* **Spring Boot 2.7.18**
* **Spring Data JPA** (Hibernate)
* **PostgreSQL**
* **Lombok**
* **Maven**

## ⚙️ Configuration de la Base de Données

Le projet utilise **PostgreSQL**. Avant de lancer l'application, veuillez suivre ces étapes :

1. Créer une base de données nommée `products` dans votre instance PostgreSQL.
2. L'application est configurée pour utiliser des variables d'environnement afin de sécuriser les accès (conformément aux consignes). 

## 🛠️ Installation et Lancement

1. **Cloner le dépôt :**
```bash
git clone <https://github.com/elmakhtar10/modelsis-backend-Mohamed-El-Makhatar-BA>
cd modelsis-backend-Mohamed-El-Makhatar-BA

```


2. **Compiler le projet :**
```bash
mvn clean install

```


3. **Lancer l'application :**
```bash
mvn spring-boot:run

```



L'application sera accessible sur : `http://localhost:8080`

## 📡 Endpoints de l'API

### 1. Types de Produits (`ProductType`)

* **POST** `/productType` : Créer un nouveau type.
* *Corps (JSON)* : `{"name": "Électronique"}`
* *Validation* : Le nom est unique. Une erreur 400 est renvoyée s'il existe déjà.



### 2. Produits (`Product`)

* **GET** `/product` : Récupérer la liste de tous les produits (avec détails du type).
* **POST** `/product` : Ajouter un produit.
* *Corps (JSON)* :
```json
{
  "name": "Ordinateur Dell",
  "type": { "id": 1 }
}

```


* *Validation* : Vérification de l'unicité du nom avant l'insertion.


* **PUT** `/product` : Mettre à jour un produit existant (via l'ID fourni dans le JSON).

## 📝 Choix Techniques

* **Persistance** : Utilisation de Spring Data JPA .
* **Sécurité** : Gestion des accès BDD via des placeholders Spring `${VAR}` pour éviter les accès en dur.
* **Auto-Génération** : Les tables sont générées automatiquement par Hibernate au démarrage (`spring.jpa.hibernate.ddl-auto=update`).

---
