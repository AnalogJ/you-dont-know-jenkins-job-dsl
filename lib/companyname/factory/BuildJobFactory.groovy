package companyname.factory
import companyname.*
import groovy.transform.* //this is required for the @InheritConstructors decorator

@InheritConstructors
public class BuildJobFactory extends JobFactory {

    /**
    * Define a base build job.
    */
    def baseBuildRpmJob(_name,_description){
        def job = myJob(_name, _description)
        job.with{
            logRotator(-1, 50, -1, 20)
            publishers {
                archiveArtifacts('dist/**')
                fingerprint('dist/**')
            }
        }
        return job
    }

    /**
    * Define specific jobs.
    */
    def buildWebAppRpm() {
        def job = baseBuildRpmJob('Build-Webapp-RPM', 'Builds the web app v1 RPM')
        job.with{
            scm {
                // your scm (git/hg/perforce/..) repo config here
            }
            steps {
                ant('build-webapp-rpm')
                ant('test-webapp')
            }
        }
        return job
    }
}
