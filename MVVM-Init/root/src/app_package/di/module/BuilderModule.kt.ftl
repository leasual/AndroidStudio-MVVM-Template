package ${packageName}.di.module

import dagger.Module
import dagger.android.ContributesAndroidInjector
import ${packageName}.ui.${moduleName}.${activityClass}

/**
 * Created by james.li on 2018/8/21.
 */
@Module
abstract class BuilderModule {

    // support fragment injection
    @ContributesAndroidInjector
    internal abstract fun mainActivity(): ${activityClass}
}