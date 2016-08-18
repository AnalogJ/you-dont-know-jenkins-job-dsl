import companyname.*
import companyname.factory.*

def buildJobFactory = new BuildJobFactory(this)
buildJobFactory.buildWebAppRpm()
buildWebAppRpm.baseBuildRpmJob('Build-Dynamically-Defined-Rpm')
    .with{
        scm {
            // your scm (git/hg/perforce/..) repo config here
        }
        steps {
            ant('build-dynamic-rpm')
            ant('test-dynamic')
        }
    }