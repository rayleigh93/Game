// Generated code from Butter Knife. Do not modify!
package com.game.ozanne.gameoz;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.LinearLayout;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;

public class GameView_ViewBinding implements Unbinder {
  private GameView target;

  @UiThread
  public GameView_ViewBinding(GameView target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public GameView_ViewBinding(GameView target, View source) {
    this.target = target;

    target.caseOne = Utils.findRequiredViewAsType(source, R.id.caseOne, "field 'caseOne'", LinearLayout.class);
    target.caseTwo = Utils.findRequiredViewAsType(source, R.id.caseTwo, "field 'caseTwo'", LinearLayout.class);
    target.caseThree = Utils.findRequiredViewAsType(source, R.id.caseThree, "field 'caseThree'", LinearLayout.class);
    target.caseFour = Utils.findRequiredViewAsType(source, R.id.caseFour, "field 'caseFour'", LinearLayout.class);
    target.caseFive = Utils.findRequiredViewAsType(source, R.id.caseFive, "field 'caseFive'", LinearLayout.class);
    target.caseSix = Utils.findRequiredViewAsType(source, R.id.caseSix, "field 'caseSix'", LinearLayout.class);
    target.caseSeven = Utils.findRequiredViewAsType(source, R.id.caseSeven, "field 'caseSeven'", LinearLayout.class);
    target.caseHeight = Utils.findRequiredViewAsType(source, R.id.caseHeight, "field 'caseHeight'", LinearLayout.class);
    target.caseNine = Utils.findRequiredViewAsType(source, R.id.caseNine, "field 'caseNine'", LinearLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    GameView target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.caseOne = null;
    target.caseTwo = null;
    target.caseThree = null;
    target.caseFour = null;
    target.caseFive = null;
    target.caseSix = null;
    target.caseSeven = null;
    target.caseHeight = null;
    target.caseNine = null;
  }
}
