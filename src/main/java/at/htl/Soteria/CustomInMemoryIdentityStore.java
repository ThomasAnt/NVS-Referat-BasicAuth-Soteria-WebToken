package at.htl.Soteria;

import javax.enterprise.context.ApplicationScoped;
import javax.security.enterprise.credential.Credential;
import javax.security.enterprise.credential.UsernamePasswordCredential;
import javax.security.enterprise.identitystore.CredentialValidationResult;
import javax.security.enterprise.identitystore.IdentityStore;
import java.util.Arrays;
import java.util.HashSet;

@ApplicationScoped
public class CustomInMemoryIdentityStore implements IdentityStore {

    @Override
    public CredentialValidationResult validate(Credential credential) {
        UsernamePasswordCredential login = (UsernamePasswordCredential) credential;
        if(login.getCaller().equals("admin") && login.getPasswordAsString().equals("admin"))
            return new CredentialValidationResult("admin",new HashSet<>(Arrays.asList("ADMIN","USER")));
        else if(login.getCaller().equals("user") && login.getPasswordAsString().equals("passme"))
            return new CredentialValidationResult("user",new HashSet<>(Arrays.asList("USER")));
        else
            return CredentialValidationResult.NOT_VALIDATED_RESULT;
    }
}
