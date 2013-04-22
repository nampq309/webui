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
import org.exoplatform.webui.core.lifecycle.UIApplicationLifecycle;
import org.exoplatform.webui.core.UIPortletApplication;
import org.exoplatform.webui.event.Event;
import org.exoplatform.webui.event.EventListener;

//this part is configuration of the portlet, we set the path to the template groovy.
 @ComponentConfig(
    lifecycle = UIApplicationLifecycle.class,
    template = "app:/groovy/webui/portlet/webui.gtmpl",
        events = {
        @EventConfig(listeners = WebUIPortletExample.OpenPopupActionListener.class)
    }
  )
public class WebUIPortletExample extends UIPortletApplication {

   public WebUIPortletExample() throws Exception {
     
   }
   
   static public class OpenPopupActionListener extends EventListener<WebUIPortletExample> {

     public void execute(Event<WebUIPortletExample> event) throws Exception {
         System.out.println("HelloWorld");
     }
  }

}
 

