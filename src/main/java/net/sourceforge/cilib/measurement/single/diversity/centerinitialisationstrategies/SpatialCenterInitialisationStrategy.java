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
package net.sourceforge.cilib.measurement.single.diversity.centerinitialisationstrategies;

import java.util.Iterator;

import net.sourceforge.cilib.algorithm.Algorithm;
import net.sourceforge.cilib.algorithm.population.PopulationBasedAlgorithm;
import net.sourceforge.cilib.entity.Entity;
import net.sourceforge.cilib.type.types.container.Vector;

/**
 * TODO: Complete this javadoc.
 */
public class SpatialCenterInitialisationStrategy extends CenterInitialisationStrategy {

    @Override
    public Vector getCenter() {
        PopulationBasedAlgorithm algorithm = (PopulationBasedAlgorithm) Algorithm.get();
        int numberOfEntities = algorithm.getPopulationSize();

        Iterator<? extends Entity> averageIterator = algorithm.getTopology().iterator();
        Entity entity = averageIterator.next();
        Vector averageEntityPosition = (Vector) entity.getCandidateSolution().getClone();

        while (averageIterator.hasNext()) {
            entity = averageIterator.next();
            Vector entityContents = (Vector) entity.getCandidateSolution();
            for (int j = 0; j < averageEntityPosition.getDimension(); ++j)
               averageEntityPosition.setReal(j, averageEntityPosition.getReal(j)+entityContents.getReal(j));
        }

        for (int j = 0; j < averageEntityPosition.getDimension(); ++j)
           averageEntityPosition.setReal(j, averageEntityPosition.getReal(j)/numberOfEntities);

        return averageEntityPosition;
    }

}
