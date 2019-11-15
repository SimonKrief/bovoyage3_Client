package fr.gtm;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import fr.gtm.bo.Destination;
import fr.gtm.bo.Voyage;
import fr.gtm.bo.Voyageur;
import fr.gtm.bo.ClientDTO;
import fr.gtm.bo.DatesVoyages;


public class Test {
	
	/**
	 * La racine de l'url de l'API est "http://localhost:9080/bovoyages3/rest"
	 * 
	 */

//	constante definissant la partie fixe de l'uri vers le web service
	private static final String WEB_APPLI = "http://localhost:9080/bovoyages3/rest";
	
	/**
	 * @see Destination
	 * Test de la recuperation de toutes les destinations
	 * les destinations sont recuperees sous forme de tableaux
	 * Il faut ajouter "/destinations/all" à la racine de l'URL.
	 * 
	 */
	
//	test permettant de savoir si la recuperation des destinations s'effectue bien
	@org.junit.Test
	public void test_all() {
//		
		String uri = WEB_APPLI+"/destinations/all";//		ajout de la partie manquante de l'uri permettant de chercher le bon web service
		Client client = ClientBuilder.newClient();//		creation d'un client pour interroger le serveur
		WebTarget target = client.target(uri);//            creation de la cible du client à travers l'uri definie precedemment
		Destination[] destinations = target.request("application/json;charset=utf-8").get(Destination[].class);// requete au web service puis recuperation du resultat
		assertTrue("test 1", destinations.length > 0);//                     test si des destinations ont ete recuperees
		assertEquals("test 2", "Birmanie", destinations[0].getRegion());//   test si le premier element est bien celui que l'on attend
	}
	
	/**
	 * Test de la recuperation de toutes les regions
	 * les regions sont recuperees sous forme de tableaux
	 * Il faut ajouter "/destinations/allRegions" à la racine de l'URL.
	 * 
	 */
	
//	test permettant de savoir si la recuperation des regions s'effectue bien
	@org.junit.Test
	public void test_allRegions() {
		String uri = WEB_APPLI+"/destinations/allRegions";//		ajout de la partie manquante de l'uri permettant de chercher le bon web service
		Client client = ClientBuilder.newClient();//                creation d'un client pour interroger le serveur
		WebTarget target = client.target(uri);//                    creation de la cible du client à travers l'uri definie precedemment
		String[] regions = target.request("application/json;charset=utf-8").get(String[].class);// requete au web service puis recuperation du resultat
		assertTrue("test 1", regions.length > 0);//                 test si des regions ont ete recuperees
		assertEquals("test 2", "Birmanie", regions[0]);//           test si le premier element est bien celui que l'on attend
		assertEquals("test 3", "Canada", regions[1]);//             test si le second element est bien celui que l'on attend
	}
	
	/**
	 * @see Destination
	 * Test de la recuperation de toutes les destinations qui n'ont pas ete supprimees (deleted).
	 * les destinations sont recuperees sous forme de tableaux
	 * Il faut ajouter "/destinations/allDestinationsValides" à la racine de l'URL.
	 * 
	 */
	
//	test permettant de savoir si l'on recupere les destinations qui ne sont pas raye de la liste
	@org.junit.Test
	public void test_allDestinationsValides() {
		String uri = WEB_APPLI+"/destinations/allDestinationsValides";// ajout de la partie manquante de l'uri permettant de chercher le bon web service
		Client client = ClientBuilder.newClient();//                     creation d'un client pour interroger le serveur
		WebTarget target = client.target(uri);//                         creation de la cible du client à travers l'uri definie precedemment
		Destination[] destinations = target.request("application/json;charset=utf-8").get(Destination[].class);// requete au web service puis recuperation du resultat
		boolean estAbsent = true;//                    booleen true par defaut et modifie si l'on les resultats de ne sont pas conformes à l'attendu
		for(Destination d : destinations) {//          parcours des destinations recuperer pour tester si une regions rayee est presente
			if(d.getRegion().equals("Haïti")) {//      test de la region d'une destination. Celle-ci doit être differente de la region rayee
				estAbsent = false;//                   si l'on trouve la region raye parmie nos destination, on met notre booleen à fausse pour que le test echoue
			}
		}
		assertTrue(estAbsent);//                       test s'il n'y a bien pas la region raye dans les destinations recuperees
	}
//// test permettant de savoir si la creation d'un client s'effectue bien
//	@org.junit.Test
//	public void test_Creation_Client() {
//		String uri = WEB_APPLI+"/destinations/addClient";//  ajout de la partie manquante de l'uri permettant de chercher le bon web service
//		Client client = ClientBuilder.newClient();//         creation d'un client pour interroger le serveur
//		WebTarget target = client.target(uri);//             creation de la cible du client à travers l'uri definie precedemment
//		ClientDTO clientDTO = new ClientDTO();//             declaration d'une instance de client que l'on veut ajouter
//		clientDTO.setNom("Perrin");//                        definition du nom du client que l'on souhaite ajouter en base
//		ClientDTO clientReponse = target.request("application/json;charset=utf-8").post(Entity.entity(clientDTO, MediaType.APPLICATION_JSON), ClientDTO.class);// requete au web service puis recuperation du resultat
//		assertEquals("test 1", "Perrin", clientReponse.getNom());// verification que le client que l'on a souhaite ajoute a bel et bien ete ajoute
//	}
//
//// test permettant de savoir si la creation d'un voyage avec le minimum de paramètre s'effectue bien 	
//	@org.junit.Test
//	public void test_Creation_Voyage() {
//		String uri = WEB_APPLI+"/destinations/addVoyage";//   ajout de la partie manquante de l'uri permettant de chercher le bon web service
//		Client client = ClientBuilder.newClient();//          creation d'un client pour interroger le serveur
//		WebTarget target = client.target(uri);//              creation de la cible du client à travers l'uri definie precedemment
//		Voyage voyage = new Voyage();//                       declaration d'une instance de voyage que l'on veut ajouter en base
//		voyage.setRegion("France");//                         definition du nom d'une region pour le voyage que l'on souhaite ajouter en base
//		voyage.setDescriptif("Le plus beau pays du monde");// definition d'une description de la region pour le voyage que l'on souhaite ajouter en base
//		Voyage voyageReponse = target.request("application/json;charset=utf-8").post(Entity.entity(voyage, MediaType.APPLICATION_JSON), Voyage.class);// requete au web service puis recuperation du resultat
//		assertEquals("test 1", "France", voyageReponse.getRegion());//  test si le voyage que l'on a souhaite cree est bien celui retourne
//	}
////
//// test permettant de savoir si la creation d'un voyage avec le minimum de paramètre s'effectue bien
//	@org.junit.Test
//	public void test_MAJ_Voyage() {
//		String uri = WEB_APPLI+"/destinations/updateVoyage";//  ajout de la partie manquante de l'uri permettant de chercher le bon web service
//		Client client = ClientBuilder.newClient();//            creation d'un client pour interroger le serveur
//		WebTarget target = client.target(uri);//                creation de la cible du client à travers l'uri definie precedemment
//		Voyage voyage = new Voyage();//                         declaration d'une instance de voyage que l'on veut mettre-à-jour dans la base
//		voyage.setId(1);//                                      definition de l'id du voyage que l'on souhaite mettre à jour dans la base
//		voyage.setRegion("France");//                           definition du nom d'une region pour le voyage que l'on souhaite mettre à jour dans la base
//		voyage.setDescriptif("Le pays du fromage");//           definition d'une description de la region pour le voyage que l'on souhaite mettre à jour dans la base
//		Voyage voyageReponse = target.request("application/json;charset=utf-8").post(Entity.entity(voyage, MediaType.APPLICATION_JSON), Voyage.class);// requete au web service puis recuperation du resultat
//		assertEquals("test 1", "Le pays du fromage", voyageReponse.getDescriptif());  test si le voyage que l'on a souhaite modifee est bien celui retourne et correspond à nos modifications
//	}
////
	/**
	 * @see ClientDTO
	 * Test de l'ajout d'un client.
	 * Il faut ajouter "/destinations/addClientVoyage/{id}" à la racine de l'URL.
	 * L'{id} à preciser est un nombre qui correspond à l'identifiant du client. 
	 */
//  test permettant de savoir si l'ajout d'un client à un voyage s'effectue bien 
	@org.junit.Test
	public void test_Ajout_Client_Voyage() {
		String uri = WEB_APPLI+"/destinations/addClientVoyage/1";//  ajout de la partie manquante de l'uri permettant de chercher le bon web service en precisant à quel voyage on souhaite ajouter le client
		Client client = ClientBuilder.newClient();//                 creation d'un client pour interroger le serveur
		WebTarget target = client.target(uri);//                     creation de la cible du client à travers l'uri definie precedemment
		ClientDTO clientDTO = new ClientDTO();//                     declaration d'une instance de client appelee clientDTO pour ne pas faire de redondance avec la classe client JAVA
		clientDTO.setId(1);//                                        definition de l'id du client que l'on souhaite modifier
		clientDTO.setNom("Perrin");//                                definition du nom du client que l'on souhaite ajouter au voyage
		Voyage voyageReponse = target.request("application/json;charset=utf-8").post(Entity.entity(clientDTO, MediaType.APPLICATION_JSON), Voyage.class);// requete au web service puis recuperation du resultat
		assertEquals("test 1", 1, voyageReponse.getFkClient());//    test si le voyage auquel on a rajoute notre client à bel et bien pris en compte le client
	}
//////
//// test permettant de savoir si l'ajout de voyageurs à un voyage s'effectue bien
//	@org.junit.Test
//	public void test_Ajout_Voyageur_A_Voyage() {
//		String uri = WEB_APPLI+"/destinations/addVoyageurAVoyage/1";//  ajout de la partie manquante de l'uri permettant de chercher le bon web service
//		Client client = ClientBuilder.newClient();//                    creation d'un client pour interroger le serveur
//		WebTarget target = client.target(uri);//                        creation de la cible du client à travers l'uri definie precedemment
//		Voyageur[] voyageurs = new Voyageur[1];//                       declaration d'une instance d'un tableau de voyageur de la taille du nombre de voyageur que l'on veut ajouter dans un voyage
//		Voyageur voyageur = new Voyageur();//                           declaration d'une instance de voyageur que l'on va ajouter dans le tableau
//		voyageur.setCivilite("M");//                                    definition de la civilite du voyageur que l'on souhaite ajouter au voyage
//		voyageur.setNom("Dupuit");//                                    definition du nom du voyageur que l'on souhaite ajouter au voyage
//		voyageur.setPrenom("Robert");//                                 definition du prenom du voyageur que l'on souhaite ajouter au voyage
//		voyageurs[0] = voyageur;//                                      ajout du voyageur au tableau
//		Voyageur[] voyageursReponse = target.request("application/json;charset=utf-8").post(Entity.entity(voyageurs, MediaType.APPLICATION_JSON), Voyageur[].class);// requete au web service puis recuperation du resultat
//		assertEquals("test 1", "Dupuit", voyageursReponse[1].getNom());// test si le voyageur que l'on a souhaite ajoute est bel et bien celui que l'on recupère en base
//	}
//////
	
	/**
	 * @see Destination
	 * Test de la recuperation dates de voyages d'une destination (celles qui ne sont pas rayees)
	 * Il faut ajouter "/destinations/allDestinationsValides" à la racine de l'URL.
	 * Les dates voyages sont envoyees sous forme de tableau.
	 */
//// test permettant de savoir si l'on recupère bien toutes les dates d'une destinations que l'on specifie 
	@org.junit.Test
	public void test_allDatesVoyagesValidesDeDestination() {
		String uri = WEB_APPLI+"/destinations/allDatesVoyagesValidesDeDestination/1";//  ajout de la partie manquante de l'uri permettant de chercher le bon web service en precisant de quelle destination on souhaite obtenir les dates de voyages valides
		Client client = ClientBuilder.newClient();//                                     creation d'un client pour interroger le serveur
		WebTarget target = client.target(uri);//                                         creation de la cible du client à travers l'uri definie precedemment
		DatesVoyages[] datesVoyages = target.request(MediaType.APPLICATION_JSON).get(DatesVoyages[].class);// requete au web service puis recuperation du resultat
		assertTrue("test 1", datesVoyages.length > 0);//    test si des dates de voyages ont ete recuperees
		assertTrue("test 2", datesVoyages.length == 3);//   test si il n'y a bien que trois dates de voyages qui ont ete recuperees
	}	
//////
	
	/**
	 * @see Voyage
	 * Test de la creation d'une commande
	 * Il faut ajouter "/destinations/commandeVoyageEnregistre/{id}" à la racine de l'URL.
	 * L'{id} à preciser est celle du client.
	 */
//  test permettant de savoir si l'on commande bien voyage en base
	@org.junit.Test
	public void test_commande_Voyage_en_base() {
		String uri = WEB_APPLI+"/destinations/commandeVoyageEnregistre/1";//  ajout de la partie manquante de l'uri permettant de chercher le bon web service en precisant quel voyage en base on souhaite commander
		Client client = ClientBuilder.newClient();//                          creation d'un client pour interroger le serveur
		WebTarget target = client.target(uri);//                              creation de la cible du client à travers l'uri definie precedemment
		Voyage voyage = new Voyage();//                                       declaration d'une instance d'un voyage
		voyage.setRegion("France");
		voyage.setDescriptif("Ze pays");
		voyage.setFkClient(1);
		Voyageur voyageur = new Voyageur();
		voyageur.setCivilite("M");
		voyageur.setNom("Durand");
		voyageur.setPrenom("Michel");
		List<Voyageur> voyageurs = new ArrayList<Voyageur>();
		voyageurs.add(voyageur);
		voyage.setParticipants(voyageurs);
		voyage.setFk_dates_voyages(3);
		boolean bool = target.request("application/json;charset=utf-8").post(Entity.entity(voyage, MediaType.APPLICATION_JSON), boolean.class);
		assertTrue("test 1", bool);
	}
//////
	
	/*
	 * @see Voyage
	 * Test de la commande d'un voyage.
	 * Il faut ajouter "/destinations/commandeVoyage" à la racine de l'URL.
	 * La DAO revoie un booleen, on verifie (indirectement) que ce boolen est : True.
	 */
//  test permettant de savoir si l'on commande bien un voyage que l'on cree
	@org.junit.Test
	public void test_commande_Voyage_creer_par_client() {
		String uri = WEB_APPLI+"/destinations/commandeVoyage";//  ajout de la partie manquante de l'uri permettant de chercher le bon web service
		Client client = ClientBuilder.newClient();//              creation d'un client pour interroger le serveur
		WebTarget target = client.target(uri);//                  creation de la cible du client à travers l'uri definie precedemment
		Voyage voyage = new Voyage();//                           declaration d'une instance d'un voyage que l'on va commander
		voyage.setRegion("France");//                             definition de la region
		voyage.setDescriptif("Ze pays");//                        definition du descriptif
		voyage.setFkClient(1);//                                  definition du client
		Voyageur voyageur = new Voyageur();//                     declaration d'une instance du voyageur du voyage que l'on souhaite commander
		voyageur.setCivilite("M");//                              definition de la civilite du voyageur du voyage que l'on souhaite commander
		voyageur.setNom("Durand");//                              definition du nom du voyageur du voyage que l'on souhaite commander
		voyageur.setPrenom("Michel");//                           definition du prenom du voyageur du voyage que l'on souhaite commander
		List<Voyageur> voyageurs = new ArrayList<Voyageur>();//   definition de la liste de voyageur du voyage du voyage que l'on souhaite commander
		voyageurs.add(voyageur);//                                ajout du voyageur à liste des voyageurs du voyage du voyage que l'on souhaite commander
		voyage.setParticipants(voyageurs);//                      definition de liste de voyageur du voyage que l'on veut commander
		voyage.setFk_dates_voyages(3);//                          definition de la date du voyage que l'on souhaite commander
		voyage.setFkClient(1);//                                  definitino du client qui passe la commande 
		boolean bool = target.request("application/json;charset=utf-8").post(Entity.entity(voyage, MediaType.APPLICATION_JSON), boolean.class);// requete au web service puis recuperation du resultat, renvoie true si le nombre de passage le permettait et false sinon
		assertTrue("test 1", bool);//  test si le voyage a ete commander
	}
//////
	
	/**
	 * @see Voyageur
	 * Test de la modification d'un voyageur
	 * Il faut ajouter "/destinations/updateVoyageurDeVoyage/{id}" à la racine de l'URL.
	 * L'{id} à preciser est celle du voyageur.
	 * 
	 */
//  test permettant de savoir si l'on met bien à jour un nom de voyageur d'un voyage commande
	@org.junit.Test
	public void test_MAJ_Voyageur_De_Voyage() {
		String uri = WEB_APPLI+"/destinations/updateVoyageurDeVoyage/1";//  ajout de la partie manquante de l'uri permettant de chercher le bon web service avec l'identifiant du voyage que l'on souhaite commander
		Client client = ClientBuilder.newClient();//                        creation d'un client pour interroger le serveur
		WebTarget target = client.target(uri);//                            creation de la cible du client à travers l'uri definie precedemment
		Voyageur voyageur = new Voyageur();//                               declaration d'une instance de voyageur que l'on va remplir pour mettre à jour le voyageur d'un voyage 
		voyageur.setId(4);//                                                definition de l'id du client dont on souhaite modifier le nom dans le voyage
		voyageur.setCivilite("M");//                                        definition de la civilite du client dont on souhaite modifier le nom dans le voyage
		voyageur.setNom("Dupuit");//                                        definition du nom du client dont on souhaite modifier le nom dans le voyage
		voyageur.setPrenom("Robert");//                                     definition du prenom du client dont on souhaite modifier le nom dans le voyage
		LocalDate date = LocalDate.of(2000, Month.DECEMBER, 12);//          déclaration d'une date pour la définir comme date de naissance du voyageur que l'on ajoute 
		voyageur.setDateNaissance(date);//                                  definition de la date de naissance du voyageur que l'on ajoute
		Voyage voyageReponse = target.request("application/json;charset=utf-8").post(Entity.entity(voyageur, MediaType.APPLICATION_JSON), Voyage.class);// requete au web service puis recuperation du resultat, la modification sert à s'assurer que le voyageur que l'on va tester est different de la valeur attendu pour valider le test
		voyageur.setNom("Dupond");// definition du nom du voyageur à la valeur attendue
		voyageReponse = target.request("application/json;charset=utf-8").post(Entity.entity(voyageur, MediaType.APPLICATION_JSON), Voyage.class);// requete au web service puis recuperation du resultat
		assertEquals("test 1", "Dupond", voyageReponse.getParticipants().get(1).getNom());//  test si le voyageur a le bon nom
		voyageur.setNom("Dupuit");// remise à jour de la base
		target.request("application/json;charset=utf-8").post(Entity.entity(voyageur, MediaType.APPLICATION_JSON), Voyage.class);
	}

}
