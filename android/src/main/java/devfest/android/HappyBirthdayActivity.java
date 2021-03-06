/*
 * Copyright 2012 c-base e.V.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy
 * of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */

package devfest.android;

import playn.android.GameActivity;
import playn.core.PlayN;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import devfest.core.HappyBirthday;
import devfest.core.Native;


public class HappyBirthdayActivity extends GameActivity {
  private AndroidSettingsDialog settingsDialog;

  @Override
  public void main() {
    platform().assets().setPathPrefix("devfest/resources");

    settingsDialog = new AndroidSettingsDialog(this);
    Native.settingsDialogImpl(settingsDialog);
    PlayN.run(new HappyBirthday());
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    MenuInflater inflater = getMenuInflater();
    inflater.inflate(R.menu.happy_birthday, menu);
    return true;
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    if (item.getItemId() == R.id.menu_restart) {
      settingsDialog.startDialog();
    }
    return super.onOptionsItemSelected(item);
  }
}
