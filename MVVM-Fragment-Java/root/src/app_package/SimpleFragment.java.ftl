package ${packageName}.ui.${moduleName};

import ${packageName}.R;
import ${packageName}.base.BaseFragment;
import ${packageName}.databinding.Fragment${underscoreToCamelCase(classToResource(fragmentClass))}Binding;

 
public class ${fragmentClass} extends BaseFragment<${viewModelClass}, Fragment${underscoreToCamelCase(classToResource(fragmentClass))}Binding> {

    @Override
    public int getLayoutId() {
    	return R.layout.${layoutName};
    }
    
    public static ${fragmentClass} newInstance() {
    	return new ${fragmentClass}();
    }

    @Override 
    public void setupViews() {

    }

    @Override 
    public void observeData() {

    }
}