package itm.sv;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import io.quarkus.qute.Template;
import io.quarkus.qute.TemplateInstance;

import io.quarkus.security.Authenticated;
import io.quarkus.security.identity.SecurityIdentity;

@Path("/user")
@Authenticated
public class UserData {
    @Inject
    SecurityIdentity securityIdentity;

    @Inject
    Template dashboard;

    @GET
    @Produces(MediaType.TEXT_HTML)
    public TemplateInstance noauth() {
        return dashboard.data("username", securityIdentity.getPrincipal().getName());
    }
}
