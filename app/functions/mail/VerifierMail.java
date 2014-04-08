/*********************************************************************************
 * 
 *   Copyright 2014 BOUSSEJRA Malik Olivier, HALDEBIQUE Geoffroy, ROYER Johan
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 *   
 ********************************************************************************/
package functions.mail;

import play.Play;
import play.mvc.Controller;
import play.mvc.Result;
import models.Membre;

import views.html.verificationMail;

public class VerifierMail extends Controller{
	
	public static void envoyerMailDeVerification(Membre membre){
		String contenu = "Veuillez suivre le lien suivant pour valider la création de votre compte :<br>";
		contenu+=Play.application().configuration().getString("domain.name")+"/verification/"+membre.membre_lien_de_validation_de_mail;
		contenu+="<br>Ce sera au webmestre d'accepter ou non votre inscription.";
		Mail mail = new Mail("Validation de la création de votre compte AER",
				contenu,
				membre.membre_email,
				membre.membre_nom);
		mail.sendMail();
	}
	
	public static Result verifier(String lien){
		Membre m = Membre.find.where().eq("membre_lien_de_validation_de_mail", lien).findUnique();
		m.membre_lien_de_validation_de_mail=null;
		m.save();
		envoyerMailAcceptationAAdmin(m);
		return ok(verificationMail.render());
	}
	
	/**
	 * A écrire
	 * @param membre
	 */
	public static void envoyerMailAcceptationAAdmin(Membre membre){
		
	}
}
