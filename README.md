# TP01-ENSAO-GI4
Realisation du tp1 du spring : dependency Injection
Mohamed El kadir - Ahmed Eddehby

structure du projet:
/beans : contien les fichiers context du projet 
          -app-context-dao : contient tous les beans dao
          -app-context : contient les differents beans du service, controllers ...
/com.ensa.gi4.modele: contient les modeles de l'application : chaise et livre qui heritent de la meme classe materiel
/com.ensa.gi4.service.api : contient les interfaces de differents services de l'applications
/com.ensa.gi4.service.impl : contient les implementation des interfaces mentionees
/com.ensa.gi4.controller : contient une seul controlleur qui fait l'appelle des services
/com.ensa.gi4.database : contient les dao qui fait les operation CRUD sur la base de donnees
AppGestionMateriel : fichier main de l'application
