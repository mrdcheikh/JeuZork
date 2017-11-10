import java.util.Set;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.*;
/* 
 * Travail en trinome 
 * Ezeeddine Habiboullah 11709483	
 * Katia CHAIBI 11608816
 * Korka Diallo
*/

/**
 *  Une piece dans un jeu d'aventure. <p>
 *
 *  Cette classe fait partie du logiciel Zork, un jeu d'aventure simple en mode
 *  texte.</p> <p>
 *
 *  Une "Piece" represente un des lieux dans lesquels se déroule l'action du
 *  jeu. Elle est reliée a au plus quatre autres "Piece" par des sorties. Les
 *  sorties sont étiquettées "nord", "est", "sud", "ouest". Pour chaque
 *  direction, la "Piece" possède une référence sur la piece voisine ou null
 *  s'il n'y a pas de sortie dans cette direction.</p>
 *
 * @author     Michael Kolling
 * @author     Marc Champesme (pour la traduction francaise)
 * @version    1.1
 * @since      August 2000
 */

public class Piece {
	private String description;
	private ArrayList<ObjetZork> ObjetPiece;
	// mémorise les sorties de cette piece.
	private Map sorties;

	/**
	 *  Initialise une piece décrite par la chaine de caractères spécifiée.
	 *  Initialement, cette piece ne possède aucune sortie. La description fournie
	 *  est une courte phrase comme "la bibliothèque" ou "la salle de TP".
	 *
	 * @param  description  Description de la piece.
	 */
	public Piece(String description,ArrayList<ObjetZork> ObjetPiece) {
		this.description = description;
		//this.objet=null;
		this.ObjetPiece=ObjetPiece;
		sorties = new HashMap();
		
	}


	/**
	 *  Définie les sorties de cette piece. A chaque direction correspond ou bien
	 *  une piece ou bien la valeur null signifiant qu'il n'y a pas de sortie dans
	 *  cette direction.
	 *
	 * @param  nord   La sortie nord
	 * @param  est    La sortie est
	 * @param  sud    La sortie sud
	 * @param  ouest  La sortie ouest
	 */
	public void setSorties(Piece nord, Piece est, Piece sud, Piece ouest) {
		if (nord != null) {
			sorties.put("nord", nord);
		}
		if (est != null) {
			sorties.put("est", est);
		}
		if (sud != null) {
			sorties.put("sud", sud);
		}
		if (ouest != null) {
			sorties.put("ouest", ouest);
		}
	}


	/**
	 *  Renvoie la description de cette piece (i.e. la description spécifiée lors
	 *  de la création de cette instance).
	 *
	 * @return    Description de cette piece
	 */
	public String descriptionCourte() {
		return description;
	}

	/**
	 *  Renvoie une description de cette piece mentionant ses sorties et
	 *  directement formatée pour affichage, de la forme: <pre>
	 *  Vous etes dans la bibliothèque.
	 *  Sorties: nord ouest</pre> Cette description utilise la chaine de caractères
	 *  renvoyée par la méthode descriptionSorties pour décrire les sorties de
	 *  cette piece.
	 *
	 * @return    Description affichable de cette piece
	 */
	public String descriptionLongue() {
		return "Vous etes dans " + description + ".\n" + descriptionSorties();
	}

	public ArrayList<ObjetZork> getPieceObjet(){
		return ObjetPiece;	
	}
	/**
	 *  Renvoie une description des sorties de cette piece, de la forme: <pre>
	 *  Sorties: nord ouest</pre> Cette description est utilisée dans la
	 *  description longue d'une piece.
	 *
	 * @return    Une description des sorties de cette pièce.
	 */
	public String descriptionSorties() {
		String resulString = "Sorties:";
		Set keys = sorties.keySet();
		for (Iterator iter = keys.iterator(); iter.hasNext(); ) {
			resulString += " " + iter.next();
		}
		return resulString;
	}
	/**
	 *  Renvoie la piece atteinte lorsque l'on se déplace a partir de cette piece
	 *  dans la direction spécifiée. Si cette piece ne possède aucune sortie dans cette direction,
	 *  renvoie null.
	 *
	 * @param  direction  La direction dans laquelle on souhaite se déplacer
	 * @return            Piece atteinte lorsque l'on se déplace dans la direction
	 *      spécifiée ou null.
	 */
	public boolean SupprimmeObjet(ObjetZork o){
			boolean b= ObjetPiece.remove(o);
			return b;
	}
	
	/**
	 * permet de supprime objet par son index 
	 * @return ObjetZork  
	 * @author : Ezeeddine Habiboullah 11709483
	 */

	public ObjetZork supprimmeIndex(int i){
		return this.ObjetPiece.remove(i);
	}

	/**
	 *  Renvoie la piece atteinte lorsque l'on se déplace a partir de cette piece
	 *  dans la direction spécifiée. Si cette piece ne possède aucune sortie dans cette direction,
	 *  renvoie null.
	 *
	 * @param  direction  La direction dans laquelle on souhaite se déplacer
	 * @return            Piece atteinte lorsque l'on se déplace dans la direction
	 *      spécifiée ou null.
	 */
	public Piece pieceSuivante(String direction) {
		return (Piece) sorties.get(direction);
	}

	
	public Piece piecePrecedente(String direction){
		return (Piece) sorties.get(direction);
	}

	public void setSizeList(int i){
		 this.ObjetPiece.ensureCapacity(i);
	}


}	
