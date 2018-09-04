<?xml version="1.0"?>
<recipe>
    <#include "../common/recipe_manifest.xml.ftl" />

    <#include "activity_layout_recipe.xml.ftl" />
    

    <instantiate from="src/app_package/SimpleActivity.java.ftl"
      to="${escapeXmlAttribute(srcOut)}/ui/${slashedPackageName(moduleName)}/${activityClass}.java" />

    <instantiate from="src/app_package/SimpleViewModel.java.ftl"
      to="${escapeXmlAttribute(srcOut)}/ui/${slashedPackageName(moduleName)}/${viewModelClass}.java" />


    <instantiate from="src/app_package/SimpleRepository.java.ftl"
      to="${escapeXmlAttribute(srcOut)}/repository/${slashedPackageName(moduleName)}/${repositoryClass}.java" />

</recipe>
