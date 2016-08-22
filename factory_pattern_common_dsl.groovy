import companyname.*
import companyname.factory.*
import groovy.json.*

def buildJobFactory = new BuildJobFactory(this)
buildJobFactory.buildWebAppRpm()
buildJobFactory.baseBuildRpmJob('Build-Dynamically-Defined-Rpm', 'dynamic job description ')
    .with{
        scm {
            // your scm (git/hg/perforce/..) repo config here
        }
        steps {
            ant('build-dynamic-rpm')
            ant('test-dynamic')
        }
    }

print new JsonSlurper().parseText(readFileFromWorkspace('chef_environment_data.json'))