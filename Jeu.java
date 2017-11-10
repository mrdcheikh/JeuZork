/**
 *  Classe principale du jeu "Zork". <p>
 *
 *  Zork est un jeu d'aventure très rudimentaire avec une interface en mode
 *  texte: les joueurs peuvent juste se déplacer parmi les différentes pieces.
 *  Ce jeu nécessite vraiment d'etre enrichi pour devenir intéressant!</p> <p>
 *
 *  Pour jouer a ce jeu, créer une instance de cette classe et appeler sa
 *  méthode "jouer". </p> <p>
 *
 *  Cette classe crée et initialise des instances de toutes les autres classes:
 *  elle crée toutes les pieces, crée l'analyseur syntaxique et démarre le jeu.
 *  Elle se charge aussi d'exécuter les commandes que lui renvoie l'analyseur
 *  syntaxique.</p>
 *
 * @author     Michael Kolling
 * @author     Marc Champesme (pour la traduction francaise)
 * @version    1.1
 * @since      March 2000
 */
import java.util.ArrayList;
import java.util.*;
public class Jeu {
	private AnalyseurSyntaxique analyseurSyntaxique;
	private Piece pieceCourante;
	private ArrayList<Piece> pieceSauv = new ArrayList<Piece>(); 
	private Joueur joueur;



	
	/**
	 * 
	 * Ameliorer par Korka diallo 
	 */


	public Jeu() {
		creerPieces();
		analyseurSyntaxique = new AnalyseurSyntaxique();
		ArrayList<ObjetZork> sac= new ArrayList<ObjetZork>();
		joueur= new Joueur(prenomJoueur(),9,sac);

	}


	/**
	 * Affiche le message d'accueil pour le joueur.
	 * Ameliorer par  Korka Diallo 11609328 and  Ezeeddine Habiboullah 11709483
	 */
	public void creerPieces() {
		Piece dehors;
		Piece salleTD;
		Piece taverne;
		Piece batimentC;
		Piece burreau;
		Piece pieceAjouter;
		//declaration des objets
		ObjetZork oz1;
		ObjetZork oz2;
		ObjetZork oz3;
		ObjetZork oz4;
		ObjetZork oz5;
		ObjetZork oz6;
		ObjetZork oz7;
		ObjetZork oz8;
		ObjetZork oz9;
		ObjetZork oz10;
		ObjetZork oz11;
		ObjetZork oz12;
		

		//ceration des objets
		oz1= new ObjetZork("crai",0.25,true);
		oz3= new ObjetZork("tableau",15,false);
		oz2= new ObjetZork("table",20,false);
		oz4= new ObjetZork("fichier TD",0.25,true);
		oz5= new ObjetZork("chaise",20,true);
		oz6= new ObjetZork("cafe",12,true);
		oz7= new ObjetZork("rochet",15,false);
		oz8= new ObjetZork("cailloux",20,false);
		oz7= new ObjetZork("ordinateur portable",3,true);
		oz8= new ObjetZork("souris",0.5,true);
		oz9= new ObjetZork("clavier",0.5,true);
		oz10 = new ObjetZork("Boite a lettre",10,false);
		oz11 = new ObjetZork("Pouble",19,false);
		oz12 = new ObjetZork("Porte",142,false);

		// liste 1 for TD
		ArrayList<ObjetZork>  liste1 = new ArrayList<ObjetZork>();
		ArrayList<ObjetZork>  liste2 = new ArrayList<ObjetZork>();
		ArrayList<ObjetZork>  liste3 = new ArrayList<ObjetZork>();
		ArrayList<ObjetZork>  liste4 = new ArrayList<ObjetZork>();
		ArrayList<ObjetZork>  liste5 = new ArrayList<ObjetZork>();


		liste1.add(oz1);
		liste1.add(oz4);
		liste1.add(oz2);
		liste1.add(oz1);
		// liste 2 for Desktop
		liste2.add(oz7);
		liste2.add(oz8);
		liste2.add(oz9);

		// liste 3 for Batiment G
		liste3.add(oz6);
		
		// liste 4 for Taverne 
		liste4.add(oz1);
		

		// liste 5 for Dehors 
		liste5.add(oz10);
		liste5.add(oz11);	
		liste5.add(oz12);		
		
		
		


		
		// création des pieces
		dehors = new Piece("devant le batiment C",liste5);
		salleTD = new Piece("une salle de TD dans le batiment G",liste1);
		taverne = new Piece("la taverne",liste4);
		batimentC = new Piece("le batiment C",liste3);
		burreau = new Piece("le secrétariat",liste2);

		//burreau.changerNomPiece(burreau);
		
	
		dehors.setSorties(null, salleTD, batimentC, taverne);
		salleTD.setSorties(null, null, burreau, dehors);
		taverne.setSorties(null, dehors, null, null);
		batimentC.setSorties(dehors, burreau, null, null);
		burreau.setSorties(salleTD, null, null, batimentC);
		// le jeu commence dehors
		pieceCourante = dehors;
		pieceSauv.add(pieceCourante);System.out.println("entrez le numero de l'objet que vous voulez emporter");
	}


	/**
	 *  Pour lancer le jeu. Boucle jusqu'a la fin du jeu.
	 */
	public void jouer() {
		afficherMsgBienvennue();
		afficherSituationgagner();


		// Entrée dans la boucle principale du jeu. Cette boucle lit
		// et exécute les commandes entrées par l'utilisateur, jusqu'a
		// ce que la commande choisie soit la commande "quitter"
		boolean termine = false;
		while (!termine) {
			Commande commande = analyseurSyntaxique.getCommande();
			termine = traiterCommande(commande);
		}
		System.out.println("Merci d'avoir jouer.  Au revoir.");
	
		
	}
	

	/**
	 * permet de changer le prenom du joueur .
	 * @author Korka Diallo 11609328
	 */
	public String  prenomJoueur(){
		System.out.println("Entrez votre Prenom");
		Scanner sc=new Scanner(System.in);
		String prenom;
		prenom =sc.nextLine();
		return prenom;
	}


	/**
	 * Affiche le message d'accueil pour le joueur.
	 * Ameliorer par  Ezeeddine HABIBOULLAH 11709483
	 */
	public void afficherMsgBienvennue() {
		System.out.println();
		System.out.println("Bienvennue dans le monde de Zork !"+joueur.getNom());
		System.out.println("Zork est un nouveau jeu d'aventure, terriblement enuyeux.");
		System.out.println("Tapez 'aide' si vous avez besoin d'aide.");
		System.out.println();
		System.out.println(pieceCourante.descriptionLongue());
		System.out.println("=================== les Objets disponibles dans la list =======================");
		for(int i=0 ; i<pieceCourante.getPieceObjet().size(); i++){
		System.out.print("Num : "+i+"[ Description : "+pieceCourante.getPieceObjet().get(i).getDescription()+"- Poid :"+pieceCourante.getPieceObjet().get(i).getPoids()+"-]");
		System.out.println(" ");
		}	
		System.out.println("entrez le numero de l'objet que vous voulez emporter");	
	}


	/**
	 *  Exécute la commande spécifiée. Si cette commande termine le jeu, la valeur
	 *  true est renvoyée, sinon false est renvoyée
	 *
	 * @param  commande  La commande a exécuter
	 * @return           true si cette commande termine le jeu ; false sinon.
	 */
	public boolean traiterCommande(Commande commande) {
		if (commande.estInconnue()) {
			System.out.println("Je ne comprends pas ce que vous voulez...");
			return false;
		}

		String motCommande = commande.getMotCommande();
		if (motCommande.equals("aide")) {
			afficherAide();
		}

		if(motCommande.equals("monsac")){
			monsac();
		}
		 else if (motCommande.equals("aller")) {
			deplacerVersAutrePiece(commande);
		} 
		 else if (motCommande.equals("retour")) {
			retour();
		} 
 		
		else if (motCommande.equals("chemin")) {
			afficherChemin();
		}
		else if (motCommande.equals("emporter")) {
			emporter(commande);
		}
		else if (motCommande.equals("objetpiece")) {
			objetpiece();
		}
		else if (motCommande.equals("compteur")) { 
			System.out.println("LE NOMBRE DE DEPLACEMENT EST : "+pieceSauv.size());
		}
		else if (motCommande.equals("quitter")) {
			if (commande.aSecondMot()) {
				System.out.println("Quitter quoi ?");
			} else {
				return true;
			}
		}
		return false;
	}




	/**
	 *  Affichage de l'aide. Affiche notament la liste des commandes utilisables.
	 */
	public void afficherAide() {
		System.out.println("Vous etes perdu. Vous etes seul. Vous errez");
		System.out.println("sur le campus de l'Université Paris 13.");
		System.out.println();
		System.out.println("Les commandes reconnues sont:");
		analyseurSyntaxique.afficherToutesLesCommandes();
		System.out.println("=================== les Objets disponibles dans la list =======================");
		
	}


	/**
	 *  Tente d'aller dans la direction spécifiée par la commande. Si la piece
	 *  courante possède une sortie dans cette direction, la piece correspondant a
	 *  cette sortie devient la piece courante, dans les autres cas affiche un
	 *  message d'erreur.
	 *
	 * @param  commande  Commande dont le second mot spécifie la direction a suivre
	 */
	public void deplacerVersAutrePiece(Commande commande) {

		if (!commande.aSecondMot()) {
			// si la commande ne contient pas de second mot, nous ne
			// savons pas ou aller..
			System.out.println("Aller où ?");
			return;
		}

		String direction = commande.getSecondMot();

		// Tentative d'aller dans la direction indiquée.
		Piece pieceSuivante = pieceCourante.pieceSuivante(direction);

		if (pieceSuivante == null) {
			System.out.println("Il n'y a pas de porte dans cette direction!");
		} else {
			pieceCourante = pieceSuivante;
			System.out.println(pieceCourante.descriptionLongue());
			System.out.println("=================== les Objets disponibles dans la pièce =======================");
			for(int i=0 ; i<pieceCourante.getPieceObjet().size(); i++){
			System.out.print("Num : "+i+"[ Description : "+pieceCourante.getPieceObjet().get(i).getDescription()+"- Poid :"+pieceCourante.getPieceObjet().get(i).getPoids()+"-]");
			System.out.println(" ");
			
		}
			System.out.println("entrez  le numero de l'objet");
		}
		// sauvegarder le deplacement "la piece courante"
		pieceSauv.add(pieceCourante);	
	}

	/**
	 * elle retourne le Joueur vers la piece precedante
	 * avec le commande retour 
	 * @author : Katia Chaibi 11608816
	 * 
	 */
	void retour(){
		
		if( pieceSauv.size() > 1 ){
		int i = pieceSauv.size() - 2;
		pieceCourante = pieceSauv.get(i);
		System.out.println(pieceCourante.descriptionLongue());
		System.out.println("=================== les Objets disponibles dans la list =======================");
		for(int j=0 ; j< pieceCourante.getPieceObjet().size(); j++){
			System.out.print("[ Description : "+pieceCourante.getPieceObjet().get(j).getDescription()+"- Poid :"+pieceCourante.getPieceObjet().get(j).getPoids()+"-]");
			System.out.println(" ");
		}
		System.out.println("entrer numero objet");
		System.out.println("le nom de la piece"+pieceCourante.descriptionLongue());
		}
		if(pieceSauv.size()==1){
			System.out.println("vous vous n'êtes pas deplacer");
		}

	}
	
	
	/**
	 * elle affiche si le joueur peut transporter ou non  
	 * avec le commande Chemin
	 * @author : Ezeeddine HABIBOULLAH 11709483
	 * Affiche 
	 */

	public boolean peuTransporter(){
			if(joueur.getPoidsTotaleSac() == joueur.getPoidsmax())
			return false;
			if(joueur.getPoidsTotaleSac() <= joueur.getPoidsmax())
			return true;
			
			return false;

	
	}


	/**
	 * elle affiche le chemin parcouris par le joueur 
	 * avec le commande Chemin
	 * @author : Ezeeddine HABIBOULLAH 11709483
	 * Affiche 
	 */
	void afficherChemin()
	{	

		System.out.println("Le chemin : " );
		for(int i=0 ;i< pieceSauv.size() ; i++){
			
			System.out.print(pieceSauv.get(i).descriptionCourte() + " => " ); 
		}
		System.out.println("");
		}
		

	/**
	 * 
	 * avec le contenu de sac de Joueur
	 * avec la commande monsac  
	 * le poid Max qu il peut Transporter apres le poid Max dans le sac
	 * @author : Koka Diallo 11609328
	 * 
	 */



	void monsac(){
			System.out.println("++++ Poid Max :"+joueur.getPoidsmax()+"++++ le sac du Joueur ++++ Poids sac : "+joueur.getPoidsTotaleSac()+"++++" );
			joueur.afficherSac();
		}


	
	/**
	 * Cette fonction permet a joueur de Transporter des objet en choisisant le numero  
	 * avec la commande emporter 
	 * @author : Ezeeddine HABIBOULLAH 11709483
	 * @param commande : emporter avec secondeCommand un Entier  
	 */

	void emporter(Commande commande){
	
		if (!commande.aSecondMot()) {
			// si la commande ne contient pas de second mot, nous ne
			// savons pas ou aller..
			System.out.println("lesquelles de ces objets voulez vous emportez ? ");
			System.out.println("=================== les Objets disponibles dans la list =======================");

		for(int i=0 ; i<pieceCourante.getPieceObjet().size(); i++){
			System.out.print("Num : "+i+"[ Description : "+pieceCourante.getPieceObjet().get(i).getDescription()+"- Poid :"+pieceCourante.getPieceObjet().get(i).getPoids()+"-]");
			System.out.println("");

		}
			return;
		}


			String str = commande.getSecondMot();
			// caster String to integer a l aide du fonction parseInt predefinie en java 

			int i = Integer.parseInt(str);

			if(pieceCourante.getPieceObjet().size() == 0)
			{
				System.out.println("il n ya plus d'objet a transporter");
				return;
			}
			

			if(pieceCourante.getPieceObjet().get(i).getPoids() + joueur.getPoidsTotaleSac() > joueur.getPoidsmax()){
				System.out.println("le joueur ne peut pas transporter des objets");
				return;	
			}


			
			joueur.ajouterUnObjetSac(pieceCourante.getPieceObjet().get(i));
			pieceCourante.supprimmeIndex(i);
						
			System.out.println("il te reste dans cette piece");

			System.out.println("");
			for(int j=0 ;j<pieceCourante.getPieceObjet().size(); j++){
			System.out.print("Num : "+j+"[ Description : "+pieceCourante.getPieceObjet().get(j).getDescription()+"- Poid :"+pieceCourante.getPieceObjet().get(j).getPoids()+"-]");
			System.out.println("");

				}

			return;
	}

	
	/**
	 * Cette fonction permet d afficher le contenu dans la piece
	 * avec la commande objetpiece
	 * @author : Katia  Chaibi 11608816
	 * @param ne prend pas de parametre 
	 */

	public void objetpiece(){
		for(int j=0 ; j<pieceCourante.getPieceObjet().size(); j++){
		System.out.print("[ Description : "+pieceCourante.getPieceObjet().get(j).getDescription()+"- Poid :"+pieceCourante.getPieceObjet().get(j).getPoids()+"-]");
		System.out.println("");
		}
	}

	/**
	 * Situation Gangnate 
	 * Elle Affiche si le joueur a ganger ou non desqu'il fait un chemin de 6 pieces 
	 * @author : Korka Diallo Et Habiboullah Ezeedine 
	 * @param ne prend pas de parametre 
	 */

	void afficherSituationgagner() {
		ObjetZork oz4= new ObjetZork("fichier TD",0.25,true);
		ObjetZork oz6= new ObjetZork("cafe",12,true);
		ObjetZork oz8= new ObjetZork("cailloux",20,false);
		ObjetZork oz9= new ObjetZork("clavier",0.5,true);
		
		if(pieceSauv.size() == 6){

				if(joueur.getSac().contains(oz4) && joueur.getSac().contains(oz6) && joueur.getSac().contains(oz8) && joueur.getSac().contains(oz9) )
				{
					System.out.println("Vous avez gagner ");
				}
				else{
					System.out.println("Game over "); 
				}
	

			}

		}
		

}
