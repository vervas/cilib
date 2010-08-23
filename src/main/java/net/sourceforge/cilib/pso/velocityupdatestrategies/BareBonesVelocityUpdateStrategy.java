/**
 * Computational Intelligence Library (CIlib)
 * Copyright (C) 2003 - 2010
 * Computational Intelligence Research Group (CIRG@UP)
 * Department of Computer Science
 * University of Pretoria
 * South Africa
 *
 * This library is free software; you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation; either version 3 of the License, or
 * (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this library; if not, see <http://www.gnu.org/licenses/>.
 */
package net.sourceforge.cilib.pso.velocityupdatestrategies;

import net.sourceforge.cilib.controlparameter.ConstantControlParameter;
import net.sourceforge.cilib.controlparameter.ControlParameter;
import net.sourceforge.cilib.entity.Particle;
import net.sourceforge.cilib.math.random.GaussianDistribution;
import net.sourceforge.cilib.math.random.ProbabilityDistributionFuction;
import net.sourceforge.cilib.type.types.container.Vector;

/**
 *  The <tt>VelocityUpdateStrategy</tt> strategy for the Bare Bones PSO as
 *  defined by Kennedy.
 *
 *  TODO: get the required references
 *
 *  @author Gary Pampara
 *  @author Andries Engelbrecht
 */
public class BareBonesVelocityUpdateStrategy implements VelocityUpdateStrategy {

    private static final long serialVersionUID = -823686042197742768L;

    protected ProbabilityDistributionFuction randomDistribution;

    public BareBonesVelocityUpdateStrategy() {
        this.randomDistribution = new GaussianDistribution();
    }

    public BareBonesVelocityUpdateStrategy(BareBonesVelocityUpdateStrategy copy) {
        this.randomDistribution = copy.randomDistribution;
    }

    @Override
    public BareBonesVelocityUpdateStrategy getClone() {
        return new BareBonesVelocityUpdateStrategy(this);
    }

    @Override
    public Vector get(Particle particle) {
        Vector localGuide = (Vector) particle.getLocalGuide();
        Vector globalGuide = (Vector) particle.getGlobalGuide();

        Vector.Builder builder = new Vector.Builder();
        for (int i = 0; i < particle.getDimension(); ++i) {
            //double tmp1 = cognitive.getParameter();
            //double tmp2 = social.getParameter();

            double sigma = Math.abs(localGuide.doubleValueOf(i) - globalGuide.doubleValueOf(i));
            //according to Kennedy
            double mean = (localGuide.doubleValueOf(i) + globalGuide.doubleValueOf(i)) / 2;
            //andries proposal: double mean = (tmp1*personalBestPosition.getReal(i) + tmp2*nBestPosition.getReal(i)) / (tmp1+tmp2);

            builder.add(this.randomDistribution.getRandomNumber(mean, sigma));
        }
        return builder.build();
    }

    @Override
    public void updateControlParameters(Particle particle) {
    }

    public ProbabilityDistributionFuction getRandomDistribution() {
        return this.randomDistribution;
    }

    public void setRandomDistribution(ProbabilityDistributionFuction pdf) {
        this.randomDistribution = pdf;
    }
}
