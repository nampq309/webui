/*
 * Copyright (C) 2003-2013 eXo Platform SAS.
 *
 * This program is free software; you can redistribute it and/or
* modify it under the terms of the GNU Affero General Public License
* as published by the Free Software Foundation; either version 3
* of the License, or (at your option) any later version.
*
* This program is distributed in the hope that it will be useful,
* but WITHOUT ANY WARRANTY; without even the implied warranty of
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
* GNU General Public License for more details.
*
* You should have received a copy of the GNU General Public License
* along with this program; if not, see<http://www.gnu.org/licenses/>.
 */
package org.exoplatform.webui.examples;

import org.exoplatform.webui.config.annotation.ComponentConfig;
import org.exoplatform.webui.config.annotation.EventConfig;
import org.exoplatform.webui.core.UIPopupWindow;
import org.exoplatform.webui.core.lifecycle.UIFormLifecycle;
import org.exoplatform.webui.event.Event;
import org.exoplatform.webui.event.EventListener;
import org.exoplatform.webui.event.Event.Phase;
import org.exoplatform.webui.examples.component.AlertPopup;
import org.exoplatform.webui.form.UIForm;
import org.exoplatform.webui.form.UIFormStringInput;

@ComponentConfig(
  lifecycle = UIFormLifecycle.class,
  template = "app:/groovy/webui/form/UILoginForm.gtmpl",
  events = {
      @EventConfig(listeners = UILoginForm.SaveActionListener.class),
      @EventConfig(phase = Phase.DECODE, listeners = UILoginForm.CancelActionListener.class)
  }
)
public class UILoginForm extends UIForm {
  
  public UILoginForm() throws Exception {
    UIFormStringInput inputText = new UIFormStringInput("TextInput", null, null);
    addUIFormInput(inputText);
    
    UIPopupWindow popup = addChild(UIPopupWindow.class, null, null);
    popup.setWindowSize(400, 300);
    
    AlertPopup alertPopup = createUIComponent(AlertPopup.class, null, null);
    popup.setUIComponent(alertPopup);
    popup.setRendered(false);
    addChild(popup);
    
  }
  
  
  static public class SaveActionListener extends EventListener<UILoginForm> {
    
    public void execute(Event<UILoginForm> event) throws Exception {
      UILoginForm form = event.getSource();
      UIPopupWindow popup = form.getChild(UIPopupWindow.class);
      popup.setRendered(true);
      popup.setShow(true);
    }
  }
  
  static public class CancelActionListener extends EventListener<UILoginForm> {
    
    public void execute(Event<UILoginForm> event) throws Exception {
      UILoginForm form = event.getSource();
      UIPopupWindow popup = form.getChild(UIPopupWindow.class);
      popup.setRendered(true);
      popup.setShow(true);
    }
  }

}
