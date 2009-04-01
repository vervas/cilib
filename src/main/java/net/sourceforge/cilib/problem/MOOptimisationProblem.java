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
package net.sourceforge.cilib.problem;

import java.util.ArrayList;

import net.sourceforge.cilib.problem.dataset.DataSetBuilder;
import net.sourceforge.cilib.type.DomainRegistry;
import net.sourceforge.cilib.type.types.Type;

/**
 * @author Edwin Peer
 *
 */
public class MOOptimisationProblem implements OptimisationProblem {
    private static final long serialVersionUID = 4997914969290350571L;

    public MOOptimisationProblem() {
        problems = new ArrayList<OptimisationProblem>();
    }

    public MOOptimisationProblem(MOOptimisationProblem copy) {

    }

    public MOOptimisationProblem getClone() {
        return new MOOptimisationProblem(this);
    }

    public Fitness getFitness(Type[] solutions, boolean count) {
        return new MOFitness(this, solutions, count);
    }

    public Fitness getFitness(Type solution, boolean count) {
        return new MOFitness(this, new Type[]{solution}, count);
    }

    public int getProblemCount() {
        return problems.size();
    }

    public Fitness getFitness(int index, Type solution, boolean count) {
        return problems.get(index).getFitness(solution, count);
    }

    public int getFitnessEvaluations() {
        int sum = 0;

        for (OptimisationProblem problem : problems) {
            sum += problem.getFitnessEvaluations();
        }
        return sum;
    }

    public void addOptimisationProblem(OptimisationProblem problem) {
        // TODO: Check problem domains match using DomainValidators.
        problems.add(problem);
    }

    public OptimisationProblem getOptimisationProblem(int index) {
        return problems.get(index);
    }

    public void removeOptimisationProblem(OptimisationProblem problem) {
        problems.remove(problem);
    }

    private ArrayList<OptimisationProblem> problems;

    public DomainRegistry getDomain() {
        // TODO Auto-generated method stub
        return null;
    }

    public DomainRegistry getBehaviouralDomain() {
        // TODO Auto-generated method stub
        return null;
    }

    public DataSetBuilder getDataSetBuilder() {
        // TODO Auto-generated method stub
        return null;
    }

    public void setDataSetBuilder(DataSetBuilder dataSetBuilder) {
        // TODO Auto-generated method stub

    }

    public void accept(ProblemVisitor visitor) {
        throw new UnsupportedOperationException("This method is not implemented");
    }

    public void changeEnvironment() {
        throw new UnsupportedOperationException("This method is not implemented");
    }
}
