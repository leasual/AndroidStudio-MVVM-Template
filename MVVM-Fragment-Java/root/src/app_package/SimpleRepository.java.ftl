package ${packageName}.repository.${moduleName};


import ${packageName}.App;
import ${packageName}.base.BaseRepository;
import javax.inject.Inject;
import javax.inject.Singleton;


@Singleton
public class ${repositoryClass} extends BaseRepository {

	private App app;
    @Inject
    public ${repositoryClass}(App app) {
        this.app = app;
    }
}