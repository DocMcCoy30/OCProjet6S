# OCP6S : Les amis de l'escalade

## Base de données
- les backup pour la base de données sont dans le répertoire ScriptSQL/
- 
- Créer une nouvelle base de données dans pgAdmin : owner => POSTGRES
![](README_images/database_backup1.png)

- Copier/Coller le contenu du fichier structure.sql dans le QueryEditor et executer le script
![](README_images/database_backup2.png)

- Copier/Coller le contenu du fichier data.sql dans le QueryEditor et executer le script
![](README_images/database_backup3.png)

- Modifier url, username et password dans le fichier META-INF/context.xml si nécessaire
![](README_images/context_settings.png)

## Paramétrage du projet

![](README_images/settings_project.png)
![](README_images/settings_module.png)
![](README_images/settings_facets1.png)
![](README_images/settings_facets2.png)
![](README_images/settings_artifacts.png)

## Paramétrage de l'application web

- Ajouter une nouvelle configuration
![](README_images/webapp_server_newConfig.png)
![](README_images/webapp_server_settings.png)
![](README_images/webapp_deploy_settings.png)