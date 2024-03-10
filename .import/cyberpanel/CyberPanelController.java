package digital.valorantsoftware.scrum.cyberpanel;

import java.util.Objects;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping({"cloud-panel"})
public class CyberPanelController {
   private final String vhostConfigTemplate = " extprocessor shinobiNetCode {   \n \n    type                    proxy\n    \n    address                 10.142.0.5:44300\n    \n    maxConns                100\n    \n    pcKeepAliveTimeout      60\n    \n    initTimeout             60\n    \n    retryTimeout            0\n    \n    respBuffer              0 \n\n}  \n\nrewrite  {   \n\n    RewriteCond %{HTTPS} !=on \n\n    RewriteRule ^ https://%{HTTP_HOST}%{REQUEST_URI} [L,R=301]  \n\n    RewriteRule /(.*) http://shinobiNetCode/$1 [P]   \n\n    enable                  1 \n\n    autoLoadHtaccess        1 \n\n} \n";

   public CyberPanelController() {
      System.out.println();
      System.out.println("*** ");
      System.out.println("*** init -- CyberPanelController");
      System.out.println("*** ");
      System.out.println();
   }

   @GetMapping({"/"})
   public String hello() {
      return "cyber-panel.";
   }

   @GetMapping({"/health-check"})
   public String returnHealthCheckContentJSON() {
      return "CyberPanelController API Is Up!";
   }

   @PostMapping({"/create-vhost-config"})
   public String createVhostConfig(@RequestBody final String responseString) {
      JSONObject jo = new JSONObject(responseString);
      System.out.println("map? enter // createVhostConfig: ");
      System.out.println(jo);
      Objects.requireNonNull(this);
      String vhostConfigTemplateUpdate = " extprocessor shinobiNetCode {   \n \n    type                    proxy\n    \n    address                 10.142.0.5:44300\n    \n    maxConns                100\n    \n    pcKeepAliveTimeout      60\n    \n    initTimeout             60\n    \n    retryTimeout            0\n    \n    respBuffer              0 \n\n}  \n\nrewrite  {   \n\n    RewriteCond %{HTTPS} !=on \n\n    RewriteRule ^ https://%{HTTP_HOST}%{REQUEST_URI} [L,R=301]  \n\n    RewriteRule /(.*) http://shinobiNetCode/$1 [P]   \n\n    enable                  1 \n\n    autoLoadHtaccess        1 \n\n} \n".replaceAll("shinobiNetCode", jo.getString("localServiceName")).replaceAll("10.142.0.5", jo.getString("remoteServerIP")).replaceAll("44300", jo.getString("remoteServerPort"));
      System.out.println("returning: " + vhostConfigTemplateUpdate);
      return vhostConfigTemplateUpdate;
   }
}
