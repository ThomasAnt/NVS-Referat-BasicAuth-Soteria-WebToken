package at.htl.Soteria;

import at.htl.model.User;

import javax.enterprise.context.ApplicationScoped;
import javax.security.enterprise.credential.Credential;
import javax.security.enterprise.credential.UsernamePasswordCredential;
import javax.security.enterprise.identitystore.CredentialValidationResult;
import javax.security.enterprise.identitystore.IdentityStore;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

@ApplicationScoped
public class CustomInMemoryIdentityStore implements IdentityStore {

    public static List<User> users = new LinkedList<>();

    @Override
    public CredentialValidationResult validate(Credential credential) {
        boolean authenticated = false;
        User user = null;
        UsernamePasswordCredential login = (UsernamePasswordCredential) credential;
        for (User u :users){
            if(u.getUsername().equals(login.getCaller()) && login.getPasswordAsString().equals(u.getPassword()))
                user = u;
        }
        if(user != null)
            return new CredentialValidationResult(user.getUsername(), user.getRoles());
        else
            return CredentialValidationResult.NOT_VALIDATED_RESULT;
    }
}
