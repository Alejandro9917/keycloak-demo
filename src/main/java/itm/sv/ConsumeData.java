package itm.sv;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import io.quarkus.qute.Template;
import io.quarkus.qute.TemplateInstance;

import io.quarkus.security.Authenticated;
import io.quarkus.security.identity.SecurityIdentity;

@Path("/api")
@Authenticated
public class ConsumeData {
    @ConfigProperty(name = "api-3scale")
    public String endpoint;

    @Inject
    SecurityIdentity securityIdentity;

    @Inject
    Template api;

    @GET
    @Produces(MediaType.TEXT_HTML)
    public TemplateInstance noauth() {
        return api.data("endpoint", endpoint);
    }
}
