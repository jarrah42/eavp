/*******************************************************************************
 * Copyright (c) 2011, 2014 UT-Battelle, LLC.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Initial API and implementation and/or initial documentation - Jay Jay 
 *   Billings
 *******************************************************************************/
package org.eclipse.eavp.viz.datastructures.VizObject;

import ca.odell.glazedlists.event.ListEvent;
import ca.odell.glazedlists.event.ListEventListener;

/**
 * This class implements the GlazedList ListEventListener interface to forward
 * updates to an ICE IUpdateableListener.
 * 
 * It accomplishes this task by decorating the IUpdateableListener and the
 * Component it is observing. When the event is posted, it simple calls
 * IUpdateableListener.update().
 * 
 * This class expects non-null input to the constructor or it will fail with a
 * NullPointerException.
 * 
 * @author Jay Jay Billings
 *
 */
public class WrappedGlazedEventListener<T> implements ListEventListener<T> {

	/**
	 * The IUpdateableListener to which events should be dispatched
	 */
	IVizUpdateableListener listener;

	/**
	 * The Component that the listener is observing
	 */
	IVizUpdateable component;

	/**
	 * The constructor
	 * 
	 * @param listener
	 *            The IUpdateableListener to which events should be dispatched
	 * @param component
	 *            The Component that the listener is observing
	 */
	public WrappedGlazedEventListener(IVizUpdateableListener listener, IVizUpdateable component) {
		this.listener = listener;
		this.component = component;
	}

	/**
	 * This GlazedList update operation. The notification is forwarded to the
	 * IUpdateableListener.
	 */
	@Override
	public void listChanged(ListEvent<T> listChanges) {
		// Just post the update
		listener.update(component);
	}

}
