package ${packageName}.ui.${moduleName};

import ${packageName}.R;
import ${packageName}.base.BaseActivity;
import ${packageName}.databinding.Activity${underscoreToCamelCase(classToResource(activityClass))}Binding;

public class ${activityClass} extends BaseActivity<${viewModelClass}, Activity${underscoreToCamelCase(classToResource(activityClass))}Binding> {

    @Override
    public int getLayoutId(){
        return R.layout.${layoutName};
    }

    @Override
    public void setupViews() {
        
    }

    @Override
    public void observeData() {

    }


}
