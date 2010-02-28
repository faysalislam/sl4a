/*
 * Copyright (C) 2010 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package com.google.ase.facade.ui;

import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;

import com.google.ase.future.FutureActivityTask;
import com.google.ase.future.FutureIntent;

/**
 * Wrapper class for progress dialog running in separate thread
 *
 * @author MeanEYE.rcf (meaneye.rcf@gmail.com)
 */
class RunnableProgressDialog extends FutureActivityTask implements RunnableDialog {
  private ProgressDialog mDialog;
  private final int mStyle;
  private final String mTitle;
  private final String mMessage;
  private final Boolean mCancelable;

  public RunnableProgressDialog(int style, String title, String message, boolean cancelable) {
    mStyle = style;
    mTitle = title;
    mMessage = message;
    mCancelable = cancelable;
  }

  @Override
  public Dialog getDialog() {
    return mDialog;
  }

  @Override
  public void run(Activity activity, FutureIntent result) {
    mDialog = new ProgressDialog(activity);
    mDialog.setProgressStyle(mStyle);
    mDialog.setCancelable(mCancelable);
    mDialog.setTitle(mTitle);
    mDialog.setMessage(mMessage);
    mDialog.show();
  }
}
