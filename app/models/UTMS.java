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

package models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import play.db.ebean.Model;

@SuppressWarnings("serial")
@Entity
public class UTMS extends Model {
	@Id
	@Column(columnDefinition="VARCHAR(4)")
	public String utm;
	
	@Column(columnDefinition="VARCHAR(4)")
	public String maille20x20;
	
	@Column(columnDefinition="VARCHAR(4)")
	public String maille50x50;
	
	@Column(columnDefinition="VARCHAR(4)")
	public String maille100x100;
	
	public static Finder<String,UTMS> find = new Finder<String,UTMS>(String.class, UTMS.class);

	public static List<UTMS> findAll(){
		return find.orderBy("utm").findList();
	}
	
	@Override
	public String toString(){
		return utm;
	}
}
