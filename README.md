[README.txt](https://github.com/user-attachments/files/24963582/README.txt)
Pour cloner le projet :
	aller sur <> Code
	choisir "Download ZIP"
	aller dans votre dossier Download
	extraire l'archive
	ouvrir Eclipse
	importer un projet gradle
	choisir le dossier core dans l'archive extraite

Compilation et Exécution
Par IDE Eclipse :
	Pour la compilation :
		créer une configuration Gradle Task
		Ajouter la tâche build
		Mettre en working directory : ${workspace_loc:/RPGASTRAL-parent}
Ainsi, un fichier .jar de notre projet est créé et est ajouté en tant que librairie dans le LaucherLwjgl3 de LibGdx
	Pour l'exécution : 
		créer une configuration Java Application
		Mettre en Projet : RPGASTRAL-lwjgl3
		Mettre en Main class : fr.rpgastral.lwjgl3.Lwjgl3Launcher
		Dans Arguments mettre en working directory : ${workspace_loc:RPGASTRAL-lwjgl3/assets}
Le Laucher de LibGdx exécute notre librairie qui lui est fournie sous forme de fichier .jar
