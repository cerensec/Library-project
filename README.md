# Library-project

## Setup

-   Launch db :
    Creation de la BDD: Dans le dossier ressources du dossier backend on trouve 3 scripts différents:

```bash
create.sql
insert.sql
drop.sql
```

Nous avons utilisé xampp pour la bdd mais il suffit d'exécuter les deux premiers scripts faire fonctionner la BDD.
Configuration Spring:
Dans le fichier applications.propreties on trouve trois variables différentes a modifier pour accèder a la BDD:

```
spring.datasource.url= Lien vers votre BDD
spring.datasource.username= Utilisateur de la BDD
spring.datasource.password= MDP de la BDD
```

-   Launch back :

```bash
mvn spring-boot:run
```

-   Launch front:

```bash
npm i
npm run dev
```
