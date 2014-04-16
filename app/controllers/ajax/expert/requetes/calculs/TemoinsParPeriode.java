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
package controllers.ajax.expert.requetes.calculs;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import controllers.ajax.expert.requetes.Calculs;
import models.Espece;
import models.FicheHasMembre;
import models.Groupe;
import models.InformationsComplementaires;
import models.Membre;
import models.Observation;
import models.SousGroupe;
import models.StadeSexe;
import models.UTMS;

public class TemoinsParPeriode implements Comparator<TemoinsParPeriode>{
	public Membre temoin;
	public int nombreDeTemoignages;

	public TemoinsParPeriode(Membre temoin, Integer nombreDeTemoignage){
		this.temoin=temoin;
		this.nombreDeTemoignages=nombreDeTemoignage;
	}

	@Override
	public String toString(){
		return temoin.membre_nom+" : "+nombreDeTemoignages;
	}

	/**
	 * Trie par ordre décroissant de nombre de témoignages
	 */
	@Override
	public int compare(TemoinsParPeriode t1, TemoinsParPeriode t2) {
		return (t1.nombreDeTemoignages<t2.nombreDeTemoignages ? 1 : (t1.nombreDeTemoignages==t2.nombreDeTemoignages ? 0 : -1));
	}
	private TemoinsParPeriode(){}


	public static List<TemoinsParPeriode> calculeTemoinsParPeriode(Map<String,String> info) throws ParseException {
		List<TemoinsParPeriode> temoins = new ArrayList<TemoinsParPeriode>();
		List<Observation> observations = TemoinsParPeriode.getObservations(info);
		//On commence la génération des témoins par période.
		int i=0;
		for(Observation observation : observations){
			List<FicheHasMembre> fhms = FicheHasMembre.find.where().eq("fiche", observation.getFiche()).findList();
			if(i%1000==0){System.out.println(i);}
			for(FicheHasMembre fhm : fhms){
				int position;
				if((position=position(fhm.membre,temoins))==-1){
					temoins.add(new TemoinsParPeriode(fhm.membre,1));
				}else{
					temoins.get(position).nombreDeTemoignages++;
				}
			}
			i++;
		}
		Collections.sort(temoins,new TemoinsParPeriode());
		return temoins;
	}

	/**
	 * Renvoie la position du membre dans la liste temoins
	 * @param membre
	 * @param temoins
	 * @return
	 */
	private static int position(Membre membre, List<TemoinsParPeriode> temoins) {
		int i = 0;
		while(i<temoins.size()){
			if(temoins.get(i).temoin.equals(membre))
				return i;
			i++;
		}
		return -1;
	}
	
	/**
	 * Renvoie les observations pour afficher temoins par période
	 * @param info
	 * @return
	 * @throws ParseException
	 */
	public static List<Observation> getObservations(Map<String,String> info) throws ParseException{
		Espece espece = Espece.find.byId(Integer.parseInt(info.get("espece")));
		SousGroupe sous_groupe = SousGroupe.find.byId(Integer.parseInt(info.get("sous_groupe")));
		Groupe groupe = Groupe.find.byId(Integer.parseInt(info.get("groupe")));
		StadeSexe stade_sexe = StadeSexe.find.byId(Integer.parseInt(info.get("stade")));
		List<UTMS> mailles = UTMS.parseMaille(info.get("maille"));
		Calendar date1 = Calculs.getDataDate1(info);
		Calendar date2 = Calculs.getDataDate2(info);
		List<Observation> observations;
		if(espece!=null){
			observations = Observation.find.where()
								.eq("observation_espece",espece)
								.between("observation_fiche.fiche_date", date1.getTime(), date2.getTime())
								.in("observation_fiche.fiche_utm", mailles)
								.findList();
		}else if(sous_groupe!=null){
			observations = Observation.find.where()
								.eq("observation_espece.espece_sous_groupe",sous_groupe)
								.between("observation_fiche.fiche_date", date1.getTime(), date2.getTime())
								.in("observation_fiche.fiche_utm", mailles)
								.findList();
		}else if(groupe!=null){
			observations = Observation.find.where()
								.eq("observation_espece.espece_sous_groupe.sous_groupe_groupe",groupe)
								.between("observation_fiche.fiche_date", date1.getTime(), date2.getTime())
								.in("observation_fiche.fiche_utm", mailles)
								.findList();
		}else{
			observations = Observation.find.where()
					.between("observation_fiche.fiche_date", date1.getTime(), date2.getTime())
					.in("observation_fiche.fiche_utm", mailles)
					.findList();
		}
		//On enlève les stades/sexes non concernés
		List<Observation> observationsAvecStadeSexe = new ArrayList<Observation>();
		if(stade_sexe!=null){
			for(Observation observation : observations){
				List<InformationsComplementaires> complements = InformationsComplementaires.find.where().eq("informations_complementaires_observation", observation).findList();
				for(InformationsComplementaires complement : complements){
					if(stade_sexe.equals(complement.informations_complementaires_stade_sexe)
							&& !observationsAvecStadeSexe.contains(observation)){
						observationsAvecStadeSexe.add(observation);
					}
				}
			}
			observations = observationsAvecStadeSexe;
		}
		return observations;
	}
}
