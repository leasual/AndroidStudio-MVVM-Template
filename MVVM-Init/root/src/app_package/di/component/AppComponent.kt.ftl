package ${packageName}.di.component

import ${packageName}.App
import ${packageName}.di.module.AppModule
import ${packageName}.di.module.BuilderModule
import ${packageName}.di.module.NetworkModule
import ${packageName}.di.module.ViewModelModule
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

/**
 * Created by james.li on 2018/8/21.
 */
@Singleton
@Component(modules = [
    AndroidSupportInjectionModule::class,
    AppModule::class,
    BuilderModule::class,
    NetworkModule::class,
    ViewModelModule::class
])
interface AppComponent: AndroidInjector<App> {

    @Component.Builder
    abstract class Builder: AndroidInjector.Builder<App>()
}