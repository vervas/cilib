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

import java.io.Serializable;

import net.sourceforge.cilib.util.Cloneable;

/**
 * This is a common abstraction for all problem classes. All problems should extend this interface.
 * All {@linkplain net.sourceforge.cilib.problem.Problem problems} are effectively dynamic problems
 * where non-dynamic problems are essentially problems that are "frozen" at an arbitrary time step.
 *
 * @author  Edwin Peer
 */
public interface Problem extends Serializable, Cloneable {

    /**
     * {@inheritDoc}
     */
    public Problem getClone();

    /**
     * Change the environment. TODO: this might need to be refactored.
     */
    public void changeEnvironment();

}
