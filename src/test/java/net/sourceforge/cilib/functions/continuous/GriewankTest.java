/**
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

package net.sourceforge.cilib.functions.continuous;

import static org.junit.Assert.assertEquals;
import net.sourceforge.cilib.functions.ContinuousFunction;
import net.sourceforge.cilib.type.types.Real;
import net.sourceforge.cilib.type.types.container.Vector;

import org.junit.Test;

/**
 *
 * @author Edwin Peer
 */
public class GriewankTest {
    
    public GriewankTest() {
    }
    
    /** Test of evaluate method, of class za.ac.up.cs.ailib.Functions.Griewank. */
    @Test
    public void testEvaluate() {
        ContinuousFunction function = new Griewank();
        function.setDomain("R(-600, 600)^3");
        //double[] x = {1, 2, 3};
        Vector     x = new Vector();
        x.append(new Real(1.0));
        x.append(new Real(2.0));
        x.append(new Real(3.0));
        assertEquals(1.01702797, function.evaluate(x), 0.000000009);
    }    
    
}
