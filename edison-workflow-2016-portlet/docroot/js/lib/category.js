var getSubCategoriesByParentCategoryId = function(categoryId){
  var url = 'http://localhost:8080/delegate/wfapi/app/categories/' + categoryId;
  return synchronousAjaxHelper.get(url);
};
var getAppsByCategoryId = function(categoryId){
  var url = 'http://localhost:8080/delegate/wfapi/app/categories/' + categoryId + "/apps";
  return synchronousAjaxHelper.get(url);
};

var createOrUpdateCategories = function(node){
  consoleLog("createOrUpdateCategories");
  var $rootDom = $($("#"+node.id).parents(".jstree")[0]);
  if(node.children.length > 0){
    $rootDom.jstree().delete_node(node.children);
  }
  //consoleLog(node.data);
  var subCategories = getSubCategoriesByParentCategoryId(node.data.categoryId);
  $.each(subCategories, function(index){
    subCategories[index]["parent"] = node.id;
    $rootDom.jstree().create_node(node, subCategories[index], "last", false);
  });
  if(node.children.length > 0){
      $rootDom.jstree("open_node", node);
  }
};