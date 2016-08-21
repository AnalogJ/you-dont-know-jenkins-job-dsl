package companyname.extensions

class FilesystemScm {
    /**
     * Generate configuration for filesystem scm .
     * https://wiki.jenkins-ci.org/display/JENKINS/File+System+SCM
     *
     <scm class="hudson.plugins.filesystem_scm.FSSCM">
     <path>/example/path/on/filesystem</path>
     <clearWorkspace>false</clearWorkspace>
     <copyHidden>false</copyHidden>
     <filterEnabled>false</filterEnabled>
     <includeFilter>false</includeFilter>
     <filters/>
     </scm>
     */

    // based off https://github.com/jenkinsci/job-dsl-plugin/wiki/The-Configure-Block#configure-svn
    static Closure filesystem(String _path, boolean _copyHidden = false, boolean _clearWorkspace = false){
        return { project ->
            project.remove(project / scm) // remove the existing 'scm' element

            project / scm(class: 'hudson.plugins.filesystem_scm.FSSCM') {
                path _path
                clearWorkspace _clearWorkspace
                copyHidden _copyHidden
                filterEnabled 'false'
                includeFilter 'false'
                filters ''
            }
        }
    }
}
