package companyname

import jenkins.model.*
import hudson.security.*
import org.jenkinsci.plugins.*
import jenkins.*
import hudson.*
import hudson.model.*
import companyname.*

public class Utilities {
    static populateUserAuthorizationPerFolder(out, user_permissions) {

        if (!Jenkins.instance.isUseSecurity()) {
            out.print "--> no authorization strategy found. skipping user management."
            return
        }
        out.println "--> retrieving and verifying project matrix authorization strategy"
        if (Jenkins.instance.getAuthorizationStrategy().getClass().getName() != "hudson.security.ProjectMatrixAuthorizationStrategy"){
            out.println "--> authorization strategy is not matrix authorization. skipping user management."
            return
        }

        //create a new strategy so that we can guarantee that only the users specified have permissions to Jenkins.
        def strategy = Jenkins.instance.getDescriptor("hudson.security.ProjectMatrixAuthorizationStrategy")

        out.println('--> Set permissions for automation users:')
        addUserPermissionsToStrategy(strategy, Constants.automation_username, ['jenkins.model.Jenkins.ADMINISTER'], out)

        out.println('--> add permissions for each specified user')
        user_permissions.each{ k, v ->
            addUserPermissionsToStrategy(strategy, k, v, out)
        }

        out.println('--> set the project matrix authorization strategy')
        Jenkins.instance.setAuthorizationStrategy(strategy)
    }

    static addUserPermissionsToStrategy(strategy, user, permissions, out){
        out.println("--> adding ${user}:${permissions}")
        permissions.each { perm_string ->
            out.println(perm_string)
            out.println(Permission.fromId(perm_string))
            strategy.add(Permission.fromId(perm_string), user)
        }
    }
}