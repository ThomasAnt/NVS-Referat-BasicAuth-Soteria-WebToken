package at.htl.model;

import at.htl.Soteria.CustomInMemoryIdentityStore;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import java.util.Arrays;
import java.util.HashSet;

@Startup
@Singleton
public class InitModel {
    @PostConstruct
    void init(){
        CustomInMemoryIdentityStore.users.add(new User("admin","admin",new HashSet<>(Arrays.asList("ADMIN","USER"))));
        CustomInMemoryIdentityStore.users.add(new User("user","passme",new HashSet<>(Arrays.asList("USER"))));
        CustomInMemoryIdentityStore.users.add(new User("Thomas","asdf123",new HashSet<>(Arrays.asList("ADMIN","USER"))));
    }
}
