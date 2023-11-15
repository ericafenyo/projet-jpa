# Projet Internet Movie DataBase

## Objectifs

1. Réaliser un document de conception avec diagramme de classes et Modèle Physique de Données.
2. Mettre en base de données des informations concernant le cinéma,
3. Mettre au point une petite application permettant d’effectuer des recherches dans les données en fonction de demandes d’un utilisateur.

## Description

Des éléments présents dans le fichier [JSON](assets/films.json) :

- **acteurs** : Des informations sur les acteurs impliqués dans le film.
- **rôles** : Les personnages ou rôles joués par chaque acteur.
- **castingPrincipal** : Les rôles principaux ou principaux du film.
- **genres** : Liste les genres ou catégories auxquels le film appartient.
- **pays** : Spécifie le ou les pays où le film a été tourné, produit ou où se déroule principalement l'histoire.

Le fichier contient également des informations sur le film, notamment le titre, l'année de sortie, etc.

## Tâches

- [ ] Analyser le fichier afin d’en comprendre la structure

- [ ] Réaliser un document de conception contenant le diagramme de classes et le modèle physique de données. Ce document sera comité dans un répertoire appelé « conception » et situé à la racine du projet.

- [ ] Réaliser l’application permettant de parser les fichiers et de mettre en BDD les données (en utilisant JPA).

- [ ] Réaliser une seconde application dotée d’un menu et permettant à l’utilisateur de réaliser des recherches dans les données. Voici le menu proposé :

1. Affichage de la filmographie d’un acteur donné
2. Affichage du casting d’un film donné
3. Affichage des films sortis entre 2 années données
4. Affichage des films communs à 2 acteurs/actrices donnés.
5. Affichage des acteurs communs à 2 films donnés
6. Affichage des films sortis entre 2 années données et qui ont un acteur/actrice donné au casting
7. Fin de l’application

Les interactions avec l’utilisateur peuvent se faire avec le Scanner.

## Exigences

- [ ] Qualité de code
- Renseigner la Javadoc

- [ ] Pas de duplication des données en base

Les données suivantes sont des entités : Lieu de naissance, pays, langue, genre.

- Les lieux de naissance doivent être uniques
- Les pays doivent être uniques
- Les langues doivent être uniques
- Les genres doivent être uniques
- Les dates de naissance doivent être de type DATE en base de données

## License

Ce projet est soumis à la licence MIT - voir le fichier [LICENSE](LICENSE) pour plus de détails.

Les données utilisées dans ce projet proviennent de [Kaggle](https://www.kaggle.com). Lire les [conditions d'utilisation](https://www.kaggle.com/terms).
