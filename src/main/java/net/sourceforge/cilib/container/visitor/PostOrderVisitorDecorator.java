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
package net.sourceforge.cilib.container.visitor;

/**
 * Simple decorator class that wraps the needed <code>Visitor</code> to make it compatible
 * with Post-Order Traversals in the Containers defined.
 *
 * @author Gary Pampara
 * @param <E> The type to be visited.
 */
public class PostOrderVisitorDecorator<E> extends PrePostVisitor<E> {
    private Visitor<E> visitor;

    /**
     * Create a new instance of {@linkplain PostOrderVisitorDecorator}, decorating the
     * provided {@linkplain Visitor} instance.
     * @param v The {@linkplain Visitor} to decorate.
     */
    public PostOrderVisitorDecorator(Visitor<E> v) {
        visitor  = v;
    }

    /**
     * {@inheritDoc}
     */
    public void postVisit(E o) {
        visitor.visit(o);
    }
}
