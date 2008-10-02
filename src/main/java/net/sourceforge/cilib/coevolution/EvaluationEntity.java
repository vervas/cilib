/*
 * Copyright (C) 2003 - 2008
 * Computational Intelligence Research Group (CIRG@UP)
 * Department of Computer Science
 * University of Pretoria
 * South Africa
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
 */
package net.sourceforge.cilib.coevolution;

import net.sourceforge.cilib.type.types.Type;
import net.sourceforge.cilib.util.Cloneable;

/**
 * @author leo
 * This class contains the entity data and population id of a coevolution competitor
 */
public class EvaluationEntity implements Cloneable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2514848906149566022L;
	Type entityData;
	int populationID;
	/**
	 * 
	 */
	
	public EvaluationEntity(Type entityData, int populationID) {		
		this.populationID = populationID;
		this.entityData = entityData; //no clone, reference to the data
	}
	
	public EvaluationEntity(EvaluationEntity other) {
		// TODO Auto-generated constructor stub
		populationID = other.populationID;
		entityData = other.entityData;
	}
	
	public Type getEntityData(){
		return entityData;
	}
	
	public int getPopulationID(){
		return populationID;
	}

	/* (non-Javadoc)
	 * @see net.sourceforge.cilib.util.Cloneable#getClone()
	 */
	public EvaluationEntity getClone() {
		// TODO Auto-generated method stub
		return new EvaluationEntity(this);
	}

}