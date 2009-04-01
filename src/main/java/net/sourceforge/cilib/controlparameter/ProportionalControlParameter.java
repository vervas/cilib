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
package net.sourceforge.cilib.controlparameter;


/**
 * A {@linkplain net.sourceforge.cilib.controlparameter.ControlParameter control parameter}
 * that is defined to return a proportional value.
 */
public class ProportionalControlParameter implements ControlParameter {
    private static final long serialVersionUID = 8415953407107514281L;
    private double proportion;

    /**
     * Create a new {@code ProportionalControlParameter} instance. The default proportion
     * value is defined to be 0.1 (10%).
     */
    public ProportionalControlParameter() {
        this.proportion = 0.1;
    }

    /**
     * {@inheritDoc}
     */
    public ProportionalControlParameter getClone() {
        return null;
    }

    /**
     * {@inheritDoc}
     */
    public double getParameter() {
        return this.proportion;
    }

    /**
     * {@inheritDoc}
     */
    public double getParameter(double min, double max) {
        double diff = max - min;
        return this.proportion * diff;
    }

    /**
     * {@inheritDoc}
     */
    public void setParameter(double value) {
        if (value < 0)
            throw new IllegalArgumentException("The proportion must be positive");

        this.proportion = value;
    }

    /**
     * {@inheritDoc}
     */
    public void updateParameter() {
    }
}
