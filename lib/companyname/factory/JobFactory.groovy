package companyname.factory
import companyname

public class JobFactory {

    JobFactory(dslFactory){
        _dslFactory = dslFactory
    }

    def myJob(_name, _description) {
        return _dslFactory.freeStyleJob(_name){
            description "DSL MANAGED: - $_descripton"
            logRotator(-1, 10, -1, 10)
        }
    }

    def myPipelineJob(_name, _description) {
        return _dslFactory.pipelineJob(_name){
            description "DSL MANAGED: - $_descripton"
            logRotator(-1, 10, -1, 10)
        }
    }

    def myMavenJob(_name, _description) {
        return _dslFactory.mavenJob(_name){
            description "DSL MANAGED: - $_descripton"
            logRotator(-1, 10, -1, 10)
        }
    }
}