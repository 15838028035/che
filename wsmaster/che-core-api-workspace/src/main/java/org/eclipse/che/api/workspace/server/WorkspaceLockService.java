/*
 * Copyright (c) 2012-2018 Red Hat, Inc.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Red Hat, Inc. - initial API and implementation
 */
package org.eclipse.che.api.workspace.server;

import org.eclipse.che.commons.lang.concurrent.Unlocker;

/**
 * Defines an abstract synchronization mechanism for operations associated with workspaces.(e.g.
 * sync statuses and runtime states). Note that different Che assemblies can provide various
 * implementations of the locking mechanism, these implementations are not required to follow the
 * contract defined by {@link java.util.concurrent.locks.ReadWriteLock}.
 *
 * @author Anton Korneta
 */
public interface WorkspaceLockService {

  /**
   * Acquires read lock. Returned instance may follow the read lock contract defined in
   * {@link java.util.concurrent.locks.ReadWriteLock}.
   *
   * @return lock instance wrapped in {@link Unlocker}
   */
  Unlocker readLock();

  /**
   * Acquires write lock. Returned instance may follow the write lock contract defined in
   * {@link java.util.concurrent.locks.ReadWriteLock}.
   *
   * @return lock instance wrapped in {@link Unlocker}
   */
  Unlocker writeLock();
}
