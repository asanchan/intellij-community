/*
 * Copyright 2000-2009 JetBrains s.r.o.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.intellij.openapi.roots.impl;

import com.intellij.openapi.diagnostic.Logger;
import com.intellij.openapi.roots.OrderEntry;

public abstract class OrderEntryBaseImpl extends RootModelComponentBase implements OrderEntry {
  private static final Logger LOG = Logger.getInstance("#com.intellij.openapi.roots.impl.OrderEntryVeryBaseImpl");

  private int myIndex;
  private static int _hc = 0;

  @SuppressWarnings({"AssignmentToStaticFieldFromInstanceMethod"})
  private final int hc = _hc++;

  protected OrderEntryBaseImpl(RootModelImpl rootModel) {
    super(rootModel);
  }

  public void setIndex(int index) {
    myIndex = index;
  }

  public int compareTo(OrderEntry orderEntry) {
    LOG.assertTrue(orderEntry.getOwnerModule() == getOwnerModule());
    return myIndex - ((OrderEntryBaseImpl)orderEntry).myIndex;
  }

  boolean sameType(OrderEntry that) {
    return getClass().equals(that.getClass());
  }

  @Override
  @SuppressWarnings({"EqualsWhichDoesntCheckParameterClass"})
  public boolean equals(Object obj) {
    return obj == this;
  }

  @Override
  public int hashCode() {
    return hc;
  }
}
